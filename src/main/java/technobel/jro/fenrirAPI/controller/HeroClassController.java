package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.HeroClassDTO;
import technobel.jro.fenrirAPI.models.form.HeroClassForm;
import technobel.jro.fenrirAPI.service.HeroClassService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/HeroClass")
public class HeroClassController {

    private final HeroClassService service;

    public HeroClassController(HeroClassService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<HeroClassDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public HeroClassDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public HeroClassDTO insert(@Valid @RequestBody HeroClassForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public HeroClassDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public HeroClassDTO update(@RequestParam int id,@Valid @RequestBody HeroClassForm form){
        return service.update(id,form);
    }



}


