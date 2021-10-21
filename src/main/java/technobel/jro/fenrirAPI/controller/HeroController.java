package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.HeroDTO;
import technobel.jro.fenrirAPI.models.form.HeroForm;
import technobel.jro.fenrirAPI.service.HeroService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Hero")
public class HeroController {

    private final HeroService service;

    public HeroController(HeroService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<HeroDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public HeroDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public HeroDTO insert(@Valid @RequestBody HeroForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public HeroDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public HeroDTO update(@RequestParam int id,@Valid @RequestBody HeroForm form){
        return service.update(id,form);
    }



}


