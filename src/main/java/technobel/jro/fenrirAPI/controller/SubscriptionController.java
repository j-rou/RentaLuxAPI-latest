package technobel.jro.fenrirAPI.controller;


import org.springframework.web.bind.annotation.*;
import technobel.jro.fenrirAPI.models.dto.ClanDTO;
import technobel.jro.fenrirAPI.models.form.ClanForm;
import technobel.jro.fenrirAPI.service.ClanService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sub")
public class SubscriptionController {



    public SubscriptionController(ClanService service){

    }


    @GetMapping(path = {"/sayhi"})
    public void getall(){

        System.out.println("hello");

    }




}


