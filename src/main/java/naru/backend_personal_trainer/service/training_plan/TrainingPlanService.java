package naru.backend_personal_trainer.service.training_plan;

import naru.backend_personal_trainer.dto.entities.TrainingPlanDto;
import naru.backend_personal_trainer.model.TrainingPlan;

import java.util.List;

public interface TrainingPlanService {

    List<TrainingPlanDto> findAll();
    TrainingPlanDto getById(int trainingPlanId);
    void save(TrainingPlanDto trainingPlan);
    void delete(int trainingPlanId);

}
