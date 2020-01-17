package naru.backend_personal_trainer.dto.entities;

import lombok.Data;

import java.util.List;

@Data
public class TrainerDto {

    private int id;
    private String firstName;
    private String lastName;
    private String specialization;
    private List<TrainingPlanDto> trainingPlansDto;

}
