package naru.backend_personal_trainer.dto.entities;


import lombok.Data;

@Data
public class ClientDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
