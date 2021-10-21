package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.EquipementDTO;
import technobel.jro.fenrirAPI.models.form.EquipementForm;
import technobel.jro.fenrirAPI.service.EquipementService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Equipement")
public class EquipementController {

    private final EquipementService service;

    public EquipementController(EquipementService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<EquipementDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public EquipementDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public EquipementDTO insert(@Valid @RequestBody EquipementForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public EquipementDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public EquipementDTO update(@RequestParam int id,@Valid @RequestBody EquipementForm form){
        return service.update(id,form);
    }



}


