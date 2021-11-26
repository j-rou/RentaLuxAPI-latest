package technobel.jro.RentaLuxAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.RentaLuxAPI.models.dto.VehiculeDTO;
import technobel.jro.RentaLuxAPI.models.form.VehiculeForm;
import technobel.jro.RentaLuxAPI.service.VehiculeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Vehicule")
public class VehiculeController {

    private final VehiculeService service;

    public VehiculeController(VehiculeService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<VehiculeDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public VehiculeDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public VehiculeDTO insert(@Valid @RequestBody VehiculeForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public VehiculeDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public VehiculeDTO update(@RequestParam int id,@Valid @RequestBody VehiculeForm form){
        return service.update(id,form);
    }



}


