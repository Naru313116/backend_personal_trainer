package naru.backend_personal_trainer.service.training_plan;

import naru.backend_personal_trainer.model.TrainingPlan;

import java.util.List;

public interface TrainingPlanService {

    List<TrainingPlan> findAll();
    TrainingPlan getById(int trainingPlanId);
    void save(TrainingPlan trainingPlan);
    void delete(int trainingPlanId);

}
