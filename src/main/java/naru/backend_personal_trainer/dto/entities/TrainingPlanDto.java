package naru.backend_personal_trainer.dto.entities;

import lombok.Data;

import java.util.List;

@Data
public class TrainingPlanDto {

    private int id;
    private String title;
    private int trainerId;
    private int clientId;
    private List<TrainingDto> trainingsDto;
}
