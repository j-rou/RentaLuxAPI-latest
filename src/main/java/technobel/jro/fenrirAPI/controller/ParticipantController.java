package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.ParticipantDTO;
import technobel.jro.fenrirAPI.models.form.ParticipantForm;
import technobel.jro.fenrirAPI.service.ParticipantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    private final ParticipantService service;

    public ParticipantController(ParticipantService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<ParticipantDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public ParticipantDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public ParticipantDTO insert(@Valid @RequestBody ParticipantForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public ParticipantDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public ParticipantDTO update(@RequestParam int id,@Valid @RequestBody ParticipantForm form){
        return service.update(id,form);
    }



}


