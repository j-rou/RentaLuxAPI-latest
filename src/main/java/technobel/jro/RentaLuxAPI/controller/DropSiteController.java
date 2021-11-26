package technobel.jro.RentaLuxAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.RentaLuxAPI.models.dto.DropSiteDTO;
import technobel.jro.RentaLuxAPI.models.form.DropSiteForm;
import technobel.jro.RentaLuxAPI.service.DropSiteService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/DropSite")
public class DropSiteController {

    private final DropSiteService service;

    public DropSiteController(DropSiteService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<DropSiteDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public DropSiteDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public DropSiteDTO insert(@Valid @RequestBody DropSiteForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public DropSiteDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public DropSiteDTO update(@RequestParam int id,@Valid @RequestBody DropSiteForm form){
        return service.update(id,form);
    }



}


