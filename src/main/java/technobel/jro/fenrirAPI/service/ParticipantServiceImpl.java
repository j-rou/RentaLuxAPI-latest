package technobel.jro.fenrirAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.fenrirAPI.exceptions.ElementNotFoundException;
import technobel.jro.fenrirAPI.mapper.ParticipantMapper;
import technobel.jro.fenrirAPI.models.dto.ParticipantDTO;
import technobel.jro.fenrirAPI.models.entity.ParticipantEntity;
import technobel.jro.fenrirAPI.models.form.ParticipantForm;
import technobel.jro.fenrirAPI.repository.ParticipantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantMapper mapper;
    private final ParticipantRepository repository;

    public ParticipantServiceImpl(ParticipantMapper mapper, ParticipantRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<ParticipantDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ParticipantDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public ParticipantDTO insert(ParticipantForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        ParticipantEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public ParticipantDTO delete(int id){
        ParticipantEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public ParticipantDTO update(int id, ParticipantForm form){

        ParticipantEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setLastName(form.getLastName());
        toUpdate.setFirstName(form.getFirstName());
        toUpdate.setAddress(form.getAddress());
        toUpdate.setHero(form.getHero());
        toUpdate.setHeroClass(form.getHeroClass());
        //toUpdate.setSubscription(form.getSubscription());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
