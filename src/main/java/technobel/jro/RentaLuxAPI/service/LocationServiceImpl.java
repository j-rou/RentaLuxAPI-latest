package technobel.jro.RentaLuxAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.RentaLuxAPI.exceptions.ElementNotFoundException;
import technobel.jro.RentaLuxAPI.mapper.LocationMapper;
import technobel.jro.RentaLuxAPI.models.dto.LocationDTO;
import technobel.jro.RentaLuxAPI.models.entity.LocationEntity;
import technobel.jro.RentaLuxAPI.models.form.LocationForm;
import technobel.jro.RentaLuxAPI.repository.LocationRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("Locationservice")
public class LocationServiceImpl implements LocationService {

    private final LocationMapper mapper;
    private final LocationRepository repository;

    public LocationServiceImpl(LocationMapper mapper, LocationRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<LocationDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public LocationDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }


    @Override
    public LocationDTO insert(LocationForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        LocationEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public LocationDTO delete(int id){
        LocationEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public LocationDTO update(int id, LocationForm form){

        LocationEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setProfileId(form.getProfileId());
        toUpdate.setVehiculeId(form.getVehiculeId());
        toUpdate.setDropSiteId(form.getDropSiteId());
        toUpdate.setStartDate(form.getStartDate());
        toUpdate.setEndDate(form.getEndDate());
        toUpdate.setUpclassable(form.isUpclassable());
        toUpdate.setUpClassVehiculeId(form.getUpClassVehiculeId());
        toUpdate.setPayementStatus(form.getPayementStatus());
        toUpdate.setInvoiceAccount(form.getInvoiceAccount());


        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }

    @Override
    public boolean verifyDateScope(Date startDate, Date endDate, int vehicleId) {
        System.out.println(startDate.toString());
//        List<LocationDTO> listOfLocation = repository.findAll()
//                .stream()
//                .filter(locationEntity -> locationEntity.getVehiculeId()==vehicleId)
//                .map(mapper::toDTO)
//                .collect(Collectors.toList());

        List<LocationDTO> listOfLocation = repository.findByVehiculeId(vehicleId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());


        for (LocationDTO locationDTO : listOfLocation) {
            /* Si la start demandée est comprise entre une start et une end d'une location enregistrée */
            /* On peut déja retourner FALSE */

            if(startDate.after(locationDTO.getStartDate()) && startDate.before(locationDTO.getEndDate()) ){
                return false;
            }
            /* Sinon si la start demandée est avant la start d'une location enregistrée, alors il faut */
            /* vérifier qu'elle se termine aussi avant cette date */
            else if ( startDate.before(locationDTO.getStartDate()) && endDate.after(locationDTO.getStartDate()) ){
                return false;
            }
            /* Sinon si la start demandée est après la end d'une location enregistrée, alors on peut retourner TRUE */
            //  /* NON NON NON !! Sinon on retourne TRUE sans être passé par les autres locations !!! */
            //  /* On doit retourner TRUE si on sort de cette boucle */
            //
            //  else if ( startDate.before(locationDTO.getStartDate()) && endDate.after(locationDTO.getEndDate()) ){
            //      return false;
            //  }
            //
        }

        // On ne devrait arriver ici que si on est dans un scope sans chevauchement.
        return true;
    }


}
