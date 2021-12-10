package technobel.jro.RentaLuxAPI.service;

import technobel.jro.RentaLuxAPI.models.dto.LoginSuccessDTO;
import technobel.jro.RentaLuxAPI.models.form.LoginForm;

public interface SessionService {

    LoginSuccessDTO login(LoginForm form);

}
