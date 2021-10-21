package technobel.jro.fenrirAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.fenrirAPI.exceptions.ElementNotFoundException;
import technobel.jro.fenrirAPI.mapper.SkillMapper;
import technobel.jro.fenrirAPI.models.dto.SkillDTO;
import technobel.jro.fenrirAPI.models.entity.SkillEntity;
import technobel.jro.fenrirAPI.models.form.SkillForm;
import technobel.jro.fenrirAPI.repository.SkillRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillMapper mapper;
    private final SkillRepository repository;

    public SkillServiceImpl(SkillMapper mapper, SkillRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<SkillDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public SkillDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public SkillDTO insert(SkillForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        SkillEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public SkillDTO delete(int id){
        SkillEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public SkillDTO update(int id, SkillForm form){

        SkillEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setName(form.getName());
        toUpdate.setDescription(form.getDescription());
        toUpdate.setLevel(form.getLevel());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
