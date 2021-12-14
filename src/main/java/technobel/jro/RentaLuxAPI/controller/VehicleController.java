package technobel.jro.RentaLuxAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.RentaLuxAPI.models.dto.VehicleDTO;
import technobel.jro.RentaLuxAPI.models.form.VehicleForm;
import technobel.jro.RentaLuxAPI.service.VehicleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<VehicleDTO> getAll(){
        return service.getAll();
    }

    @GetMapping(path ={"/getone"}, params = "id")
    public VehicleDTO getOne(@RequestParam int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public VehicleDTO insert(@Valid @RequestBody VehicleForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public VehicleDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public VehicleDTO update(@RequestParam int id,@Valid @RequestBody VehicleForm form){
        return service.update(id,form);
    }



}


