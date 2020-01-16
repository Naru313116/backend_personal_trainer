package naru.backend_personal_trainer.service.training_plan;

import naru.backend_personal_trainer.model.TrainingPlan;
import naru.backend_personal_trainer.repository.TrainingPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

   private final TrainingPlanRepository trainingPlanRepository;

    public TrainingPlanServiceImpl(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }

    @Override
    public List<TrainingPlan> findAll() {
        return trainingPlanRepository.findAll();
    }

    @Override
    public TrainingPlan getById(int trainingPlanId) {
        return trainingPlanRepository.findById(trainingPlanId).orElse(new TrainingPlan());
    }

    @Override
    public void save(TrainingPlan trainingPlan) {
    trainingPlanRepository.save(trainingPlan);
    }

    @Override
    public void delete(int trainingPlanId) {
    trainingPlanRepository.deleteById(trainingPlanId);
    }
}
