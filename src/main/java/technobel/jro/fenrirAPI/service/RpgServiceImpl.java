package technobel.jro.fenrirAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.fenrirAPI.exceptions.ElementNotFoundException;
import technobel.jro.fenrirAPI.mapper.RpgMapper;
import technobel.jro.fenrirAPI.models.dto.RpgDTO;
import technobel.jro.fenrirAPI.models.entity.RpgEntity;
import technobel.jro.fenrirAPI.models.form.RpgForm;
import technobel.jro.fenrirAPI.repository.RpgRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RpgServiceImpl implements RpgService {

    private final RpgMapper mapper;
    private final RpgRepository repository;

    public RpgServiceImpl(RpgMapper mapper, RpgRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<RpgDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public RpgDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public RpgDTO insert(RpgForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        RpgEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public RpgDTO delete(int id){
        RpgEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public RpgDTO update(int id, RpgForm form){

        RpgEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setPlot(form.getPlot());
        toUpdate.setStartDate(form.getStartDate());
        toUpdate.setEndDate(form.getEndDate());
        toUpdate.setLocation(form.getLocation());
        toUpdate.setPrice(form.getPrice());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
