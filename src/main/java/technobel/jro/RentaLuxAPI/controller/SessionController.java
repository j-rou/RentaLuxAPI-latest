package technobel.jro.RentaLuxAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import technobel.jro.RentaLuxAPI.models.dto.LoginSuccessDTO;
import technobel.jro.RentaLuxAPI.models.form.LoginForm;
import technobel.jro.RentaLuxAPI.service.SessionService;

import javax.validation.Valid;

@RestController
public class SessionController {

    private final SessionService service;

    public SessionController(SessionService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginSuccessDTO> login(@Valid @RequestBody LoginForm form){
        return ResponseEntity.ok( service.login(form) );
    }

}
