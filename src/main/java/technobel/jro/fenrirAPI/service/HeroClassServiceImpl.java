package technobel.jro.fenrirAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.fenrirAPI.exceptions.ElementNotFoundException;
import technobel.jro.fenrirAPI.mapper.HeroClassMapper;
import technobel.jro.fenrirAPI.models.dto.HeroClassDTO;
import technobel.jro.fenrirAPI.models.entity.HeroClassEntity;
import technobel.jro.fenrirAPI.models.form.HeroClassForm;
import technobel.jro.fenrirAPI.repository.HeroClassRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroClassServiceImpl implements HeroClassService {

    private final HeroClassMapper mapper;
    private final HeroClassRepository repository;

    public HeroClassServiceImpl(HeroClassMapper mapper, HeroClassRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<HeroClassDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public HeroClassDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public HeroClassDTO insert(HeroClassForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        HeroClassEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public HeroClassDTO delete(int id){
        HeroClassEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public HeroClassDTO update(int id, HeroClassForm form){

        HeroClassEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setAvailableEquipement(form.getAvailableEquipement());
        toUpdate.setName(form.getName());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
