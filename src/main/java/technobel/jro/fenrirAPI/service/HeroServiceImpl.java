package technobel.jro.fenrirAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.fenrirAPI.exceptions.ElementNotFoundException;
import technobel.jro.fenrirAPI.mapper.HeroMapper;
import technobel.jro.fenrirAPI.models.dto.HeroDTO;
import technobel.jro.fenrirAPI.models.entity.HeroEntity;
import technobel.jro.fenrirAPI.models.form.HeroForm;
import technobel.jro.fenrirAPI.repository.HeroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroMapper mapper;
    private final HeroRepository repository;

    public HeroServiceImpl(HeroMapper mapper, HeroRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<HeroDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public HeroDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public HeroDTO insert(HeroForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        HeroEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public HeroDTO delete(int id){
        HeroEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public HeroDTO update(int id, HeroForm form){

        HeroEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setName(form.getName());
        toUpdate.setClan(form.getClan());
        toUpdate.setHeroClass(form.getHeroClass());
        toUpdate.setSkills(form.getSkills());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
