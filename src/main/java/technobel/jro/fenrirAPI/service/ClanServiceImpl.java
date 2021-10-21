package technobel.jro.fenrirAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.fenrirAPI.exceptions.ElementNotFoundException;
import technobel.jro.fenrirAPI.mapper.ClanMapper;
import technobel.jro.fenrirAPI.models.dto.ClanDTO;
import technobel.jro.fenrirAPI.models.entity.ClanEntity;
import technobel.jro.fenrirAPI.models.form.ClanForm;
import technobel.jro.fenrirAPI.repository.ClanRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClanServiceImpl implements ClanService {

    private final ClanMapper mapper;
    private final ClanRepository repository;

    public ClanServiceImpl(ClanMapper mapper, ClanRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<ClanDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ClanDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public ClanDTO insert(ClanForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        ClanEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public ClanDTO delete(int id){
        ClanEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public ClanDTO update(int id, ClanForm form){

        ClanEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setName(form.getName());
        toUpdate.setBio(form.getBio());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
