package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.SkillDTO;
import technobel.jro.fenrirAPI.models.form.SkillForm;
import technobel.jro.fenrirAPI.service.SkillService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Skills")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<SkillDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public SkillDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public SkillDTO insert(@Valid @RequestBody SkillForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public SkillDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public SkillDTO update(@RequestParam int id, @Valid @RequestBody SkillForm form){
        return service.update(id,form);
    }



}


