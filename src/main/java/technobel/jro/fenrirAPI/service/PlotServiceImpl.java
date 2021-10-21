package technobel.jro.fenrirAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.fenrirAPI.exceptions.ElementNotFoundException;
import technobel.jro.fenrirAPI.mapper.PlotMapper;
import technobel.jro.fenrirAPI.models.dto.PlotDTO;
import technobel.jro.fenrirAPI.models.entity.PlotEntity;
import technobel.jro.fenrirAPI.models.form.PlotForm;
import technobel.jro.fenrirAPI.repository.PlotRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlotServiceImpl implements PlotService {

    private final PlotMapper mapper;
    private final PlotRepository repository;

    public PlotServiceImpl(PlotMapper mapper, PlotRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<PlotDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public PlotDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public PlotDTO insert(PlotForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        PlotEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public PlotDTO delete(int id){
        PlotEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public PlotDTO update(int id, PlotForm form){

        PlotEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setName(form.getName());
        toUpdate.setDescription(form.getDescription());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
