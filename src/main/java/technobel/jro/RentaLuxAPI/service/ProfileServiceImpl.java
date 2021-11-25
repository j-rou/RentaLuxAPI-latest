package technobel.jro.RentaLuxAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.RentaLuxAPI.exceptions.ElementNotFoundException;
import technobel.jro.RentaLuxAPI.mapper.ProfileMapper;
import technobel.jro.RentaLuxAPI.models.dto.ProfileDTO;
import technobel.jro.RentaLuxAPI.models.entity.ProfileEntity;
import technobel.jro.RentaLuxAPI.models.form.ProfileForm;
import technobel.jro.RentaLuxAPI.repository.ProfileRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service("Profileservice")
public class ProfileServiceImpl implements ProfileService {

    private final ProfileMapper mapper;
    private final ProfileRepository repository;

    public ProfileServiceImpl(ProfileMapper mapper, ProfileRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<ProfileDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }


    @Override
    public ProfileDTO insert(ProfileForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        ProfileEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public ProfileDTO delete(int id){
        ProfileEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public ProfileDTO update(int id, ProfileForm form){

        ProfileEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setName(form.getName());
        toUpdate.setBio(form.getBio());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
