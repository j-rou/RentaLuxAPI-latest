package technobel.jro.RentaLuxAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.RentaLuxAPI.models.dto.LocationDTO;
import technobel.jro.RentaLuxAPI.models.form.LocationForm;
import technobel.jro.RentaLuxAPI.service.LocationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Location")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<LocationDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public LocationDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public LocationDTO insert(@Valid @RequestBody LocationForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public LocationDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public LocationDTO update(@RequestParam int id,@Valid @RequestBody LocationForm form){
        return service.update(id,form);
    }



}


