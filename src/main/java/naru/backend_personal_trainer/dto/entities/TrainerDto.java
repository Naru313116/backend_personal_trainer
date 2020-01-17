package naru.backend_personal_trainer.dto.entities;

import lombok.Data;
import naru.backend_personal_trainer.model.TrainingPlan;

import java.util.List;
import java.util.Set;

@Data
public class TrainerDto {

    private int id;
    private String firstName;
    private String lastName;
    private String specialization;
    private List<TrainingPlanDto> trainingPlansDto;

}
