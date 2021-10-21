package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.PlotDTO;
import technobel.jro.fenrirAPI.models.form.PlotForm;
import technobel.jro.fenrirAPI.service.PlotService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/plot")
public class PlotController {

    private final PlotService service;

    public PlotController(PlotService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<PlotDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public PlotDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public PlotDTO insert(@Valid @RequestBody PlotForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public PlotDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public PlotDTO update(@RequestParam int id,@Valid @RequestBody PlotForm form){
        return service.update(id,form);
    }



}


