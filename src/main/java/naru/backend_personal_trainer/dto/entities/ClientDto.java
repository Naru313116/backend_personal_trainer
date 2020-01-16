package naru.backend_personal_trainer.dto.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ClientDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
