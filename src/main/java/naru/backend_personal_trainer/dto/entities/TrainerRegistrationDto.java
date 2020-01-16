package naru.backend_personal_trainer.dto.entities;

import lombok.Data;

@Data
public class TrainerRegistrationDto {

    private int id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String password;

}
