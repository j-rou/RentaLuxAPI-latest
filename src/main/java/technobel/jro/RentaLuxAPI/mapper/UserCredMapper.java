package technobel.jro.RentaLuxAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.UserCredDTO;
import technobel.jro.RentaLuxAPI.models.entity.UserCredEntity;
import technobel.jro.RentaLuxAPI.models.form.UserCredForm;


@Service
public class UserCredMapper {

    public UserCredDTO toDTO(UserCredEntity entity){

        if( entity == null ) {
            return null;
        }

        return UserCredDTO.builder()
                .id( entity.getId() )
                .email( entity.getEmail() )
                .password( entity.getPassword() )
                .accountType(entity.getAccountType())
                .build();
    }


    public UserCredEntity formToEntity(UserCredForm form){
        if( form == null ) {
            return null;
        }

        UserCredEntity UserCred = new UserCredEntity();

        UserCred.setId(form.getId());
        UserCred.setEmail(form.getEmail());
        UserCred.setPassword(form.getPassword());
        UserCred.setAccountType(form.getAccountType());


        return UserCred;
    }


}
