package technobel.jro.RentaLuxAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.RentaLuxAPI.models.dto.UserCredDTO;
import technobel.jro.RentaLuxAPI.models.form.UserCredForm;
import technobel.jro.RentaLuxAPI.service.UserCredServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usercred")
public class UserCredController {

    private final UserCredServiceImpl service;

    public UserCredController(UserCredServiceImpl service) {
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<UserCredDTO> getall(){
        return service.getAll();
    }

    @GetMapping(params = {"/getone/{id}"})
    public UserCredDTO getOne(@PathVariable int id){
        return service.getOne(id);
    }

    @PostMapping(path = {"/insert"})
    public UserCredDTO insert(@Valid @RequestBody UserCredForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public UserCredDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public UserCredDTO update(@RequestParam int id,@Valid @RequestBody UserCredForm form){
        return service.update(id,form);
    }



}


