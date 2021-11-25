package technobel.jro.RentaLuxAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.ProfileDTO;
import technobel.jro.RentaLuxAPI.models.entity.ProfileEntity;
import technobel.jro.RentaLuxAPI.models.form.ProfileForm;


@Service
public class ProfileMapper {

    public ProfileDTO toDTO(ProfileEntity entity){

        if( entity == null ) {
            return null;
        }

        return ProfileDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .bio( entity.getBio() )
                .build();
    }


    public ProfileEntity formToEntity(ProfileForm form){
        if( form == null ) {
            return null;
        }

        ProfileEntity Profile = new ProfileEntity();

        Profile.setId(form.getId());
        Profile.setName(form.getName());
        Profile.setBio(form.getBio());

        return Profile;
    }


}
