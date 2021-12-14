package technobel.jro.RentaLuxAPI.controller;


import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.*;
import technobel.jro.RentaLuxAPI.models.dto.LocationDTO;
import technobel.jro.RentaLuxAPI.models.form.LocationForm;
import technobel.jro.RentaLuxAPI.service.LocationService;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/location")
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


    @GetMapping(path = {"/vds"}, params = {"startDate", "endDate", "vehicleId"}) // TODO attention throws
    public boolean verifyDateScope(@RequestParam String startDate, @RequestParam String endDate, @RequestParam int vehicleId ) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        /* Le parse s'attend expresséement a recevoir des minutes secondes pour la création de sa date. Les parametres recus par la */
        /* méthode verify sont des dates sans heures minutes. Afin d'éviter les chevauchements de date, on force l'ajout dans la chaine */
        /* de charactere des heures et secondes (dans le parse). Ainsi une startDate sera toujours en 00min:00sec et une endDate */
        /* sera toujours en 23min:59sec. En comparant une endDate le 01/01 sera bien après une startDate le 01/01 ce qui n'est pas le cas  */
        /* si on ne compare que les jours et mois */
        return service.verifyDateScope(sdf.parse((startDate+"T00:00")),sdf.parse((endDate+"T23:59")),vehicleId);

    }


}


