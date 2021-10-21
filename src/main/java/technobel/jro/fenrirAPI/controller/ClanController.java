package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.ClanDTO;
import technobel.jro.fenrirAPI.models.form.ClanForm;
import technobel.jro.fenrirAPI.service.ClanService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Clan")
public class ClanController {

    private final ClanService service;

    public ClanController(ClanService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<ClanDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public ClanDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public ClanDTO insert(@Valid @RequestBody ClanForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public ClanDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public ClanDTO update(@RequestParam int id,@Valid @RequestBody ClanForm form){
        return service.update(id,form);
    }



}


