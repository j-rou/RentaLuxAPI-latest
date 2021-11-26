package technobel.jro.RentaLuxAPI.service;


import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.exceptions.ElementAlreadyExistsException;
import technobel.jro.RentaLuxAPI.exceptions.ElementNotFoundException;
import technobel.jro.RentaLuxAPI.mapper.DropSiteMapper;
import technobel.jro.RentaLuxAPI.models.dto.DropSiteDTO;
import technobel.jro.RentaLuxAPI.models.entity.DropSiteEntity;
import technobel.jro.RentaLuxAPI.models.form.DropSiteForm;
import technobel.jro.RentaLuxAPI.repository.DropSiteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service("DropSiteservice")
public class DropSiteServiceImpl implements DropSiteService {

    private final DropSiteMapper mapper;
    private final DropSiteRepository repository;

    public DropSiteServiceImpl(DropSiteMapper mapper, DropSiteRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<DropSiteDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public DropSiteDTO getOne(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }


    @Override
    public DropSiteDTO insert(DropSiteForm form){
        if( repository.existsById(form.getId()) )
            throw new ElementAlreadyExistsException();

        DropSiteEntity toInsert = mapper.formToEntity(form);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public DropSiteDTO delete(int id){
        DropSiteEntity toDelete = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public DropSiteDTO update(int id, DropSiteForm form){

        DropSiteEntity toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setId(form.getId());
        toUpdate.setAddress(form.getAddress());

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);


    }


}
