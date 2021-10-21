package technobel.jro.fenrirAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.fenrirAPI.exceptions.ElementNotFoundException;
import technobel.jro.fenrirAPI.mapper.EquipementMapper;
import technobel.jro.fenrirAPI.models.dto.EquipementDTO;
import technobel.jro.fenrirAPI.models.entity.EquipementEntity;
import technobel.jro.fenrirAPI.models.form.EquipementForm;
import technobel.jro.fenrirAPI.repository.EquipementRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipementServiceImpl implements EquipementService {

    private final EquipementMapper mapper;
    private final EquipementRepository repository;

    public EquipementServiceImpl(EquipementMapper mapper, EquipementRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<EquipementDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public EquipementDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public EquipementDTO insert(EquipementForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        EquipementEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public EquipementDTO delete(int id){
        EquipementEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public EquipementDTO update(int id, EquipementForm form){

        EquipementEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setName(form.getName());
        toUpdate.setDescription(form.getDescription());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
