package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.RpgDTO;
import technobel.jro.fenrirAPI.models.form.RpgForm;
import technobel.jro.fenrirAPI.service.RpgService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Rpg")
public class RpgController {

    private final RpgService service;

    public RpgController(RpgService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<RpgDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public RpgDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public RpgDTO insert(@Valid @RequestBody RpgForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public RpgDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public RpgDTO update(@RequestParam int id,@Valid @RequestBody RpgForm form){
        return service.update(id,form);
    }



}


