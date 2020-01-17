package naru.backend_personal_trainer.dto.entities;

import lombok.Data;

@Data
public class TrainingDto {

    private int Id;
    private String title;
    private String description;
    private int trainingPlanId;
}
