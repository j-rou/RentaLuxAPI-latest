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
                .username(entity.getUsername())
                .address( entity.getAddress() )
                .firstName( entity.getFirstName() )
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .tel(entity.getTel())
                .tva(entity.getTva())
                .rentalsId(entity.getRentalsId())
                .build();
    }


    public ProfileEntity formToEntity(ProfileForm form){
        if( form == null ) {
            return null;
        }

        ProfileEntity Profile = new ProfileEntity();

        Profile.setId(form.getId());
        Profile.setUsername(form.getUsername());
        Profile.setAddress( form.getAddress() );
        Profile.setFirstName( form.getFirstName() );
        Profile.setLastName(form.getLastName());
        Profile.setEmail(form.getEmail());
        Profile.setTel(form.getTel());
        Profile.setTva(form.getTva());
        Profile.setRentalsId(form.getRentalsId());

        return Profile;
    }


}
