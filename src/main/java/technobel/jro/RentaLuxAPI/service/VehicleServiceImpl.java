package technobel.jro.RentaLuxAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.RentaLuxAPI.exceptions.ElementNotFoundException;
import technobel.jro.RentaLuxAPI.mapper.VehicleMapper;
import technobel.jro.RentaLuxAPI.models.dto.VehicleDTO;
import technobel.jro.RentaLuxAPI.models.entity.VehicleEntity;
import technobel.jro.RentaLuxAPI.models.form.VehicleForm;
import technobel.jro.RentaLuxAPI.repository.VehicleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service("Vehicleservice")
public class VehicleServiceImpl implements VehicleService {

    private final VehicleMapper mapper;
    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleMapper mapper, VehicleRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<VehicleDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }


    @Override
    public VehicleDTO insert(VehicleForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        VehicleEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public VehicleDTO delete(int id){
        VehicleEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public VehicleDTO update(int id, VehicleForm form){

        VehicleEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setBrand(form.getBrand());
        toUpdate.setModel(form.getModel());
        toUpdate.setUsage(form.getUsage());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }

    @Override
    public List<VehicleDTO> getFromFilter(List<String> filtres ){
        List<VehicleDTO> liste = null;

        liste =  repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return liste;
    }


}
