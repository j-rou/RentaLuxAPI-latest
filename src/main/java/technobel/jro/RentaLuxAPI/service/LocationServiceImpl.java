package technobel.jro.RentaLuxAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.RentaLuxAPI.exceptions.ElementNotFoundException;
import technobel.jro.RentaLuxAPI.mapper.LocationMapper;
import technobel.jro.RentaLuxAPI.models.dto.LocationDTO;
import technobel.jro.RentaLuxAPI.models.entity.LocationEntity;
import technobel.jro.RentaLuxAPI.models.form.LocationForm;
import technobel.jro.RentaLuxAPI.repository.LocationRepository;

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


}
