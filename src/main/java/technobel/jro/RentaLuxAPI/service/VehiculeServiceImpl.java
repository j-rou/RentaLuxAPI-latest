package technobel.jro.RentaLuxAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.RentaLuxAPI.exceptions.ElementNotFoundException;
import technobel.jro.RentaLuxAPI.mapper.VehiculeMapper;
import technobel.jro.RentaLuxAPI.models.dto.VehiculeDTO;
import technobel.jro.RentaLuxAPI.models.entity.VehiculeEntity;
import technobel.jro.RentaLuxAPI.models.form.VehiculeForm;
import technobel.jro.RentaLuxAPI.repository.VehiculeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service("Vehiculeservice")
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeMapper mapper;
    private final VehiculeRepository repository;

    public VehiculeServiceImpl(VehiculeMapper mapper, VehiculeRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<VehiculeDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public VehiculeDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }


    @Override
    public VehiculeDTO insert(VehiculeForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        VehiculeEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public VehiculeDTO delete(int id){
        VehiculeEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public VehiculeDTO update(int id, VehiculeForm form){

        VehiculeEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setBrand(form.getBrand());
        toUpdate.setModel(form.getModel());
        toUpdate.setCategory(form.getCategory());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
