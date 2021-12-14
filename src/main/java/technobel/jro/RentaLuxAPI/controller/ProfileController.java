package technobel.jro.RentaLuxAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.RentaLuxAPI.models.dto.ProfileDTO;
import technobel.jro.RentaLuxAPI.models.form.ProfileForm;
import technobel.jro.RentaLuxAPI.service.ProfileService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service){
        this.service = service;
    }


    @GetMapping(path = {"/getall"})
    public List<ProfileDTO> getall(){
        return service.getAll();
    }


    @PostMapping(path = {"/insert"})
    public ProfileDTO insert(@Valid @RequestBody ProfileForm form){
        return service.insert(form);
    }

    @DeleteMapping("/del/{id}")
    public ProfileDTO delete(@PathVariable int id){
        return service.delete(id);
    }

    @PutMapping(params = "id")
    public ProfileDTO update(@RequestParam int id,@Valid @RequestBody ProfileForm form){
        return service.update(id,form);
    }


    @GetMapping(path = {"/getbyusername"},params={"username"})
    public ProfileDTO getProfileByEmail(@RequestParam String username){
        return service.getProfileByUsername(username);
    }





}


