package naru.backend_personal_trainer.service.training_plan;

import naru.backend_personal_trainer.dto.entities.TrainingPlanDto;
import naru.backend_personal_trainer.dto.mapper.TrainingPlanMapper;
import naru.backend_personal_trainer.model.TrainingPlan;
import naru.backend_personal_trainer.repository.TrainingPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

    private final TrainingPlanRepository trainingPlanRepository;
    private final TrainingPlanMapper trainingPlanMapper;

    public TrainingPlanServiceImpl(TrainingPlanRepository trainingPlanRepository, TrainingPlanMapper trainingPlanMapper) {
        this.trainingPlanRepository = trainingPlanRepository;
        this.trainingPlanMapper = trainingPlanMapper;
    }

    @Override
    public List<TrainingPlanDto> findAll() {
        return trainingPlanRepository.findAll().stream().map(trainingPlanMapper::trainingPlanToTrainingPlanDto).collect(Collectors.toList());
    }

    @Override
    public TrainingPlanDto getById(int trainingPlanId) {
        TrainingPlan trainingPlan = trainingPlanRepository.findById(trainingPlanId).orElse(new TrainingPlan());
        return trainingPlanMapper.trainingPlanToTrainingPlanDto(trainingPlan);
    }

    @Override
    public void save(TrainingPlanDto trainingPlan) {
        trainingPlanRepository.save(trainingPlanMapper.trainingPlanDtoToTrainingPlan(trainingPlan));
    }

    @Override
    public void delete(int trainingPlanId) {
        trainingPlanRepository.deleteById(trainingPlanId);
    }

    @Override
    public void updateTrainingPlan(TrainingPlanDto trainingPlanDtoFromDataBase, TrainingPlanDto trainingPlanDtoToUpdate) {
        TrainingPlan trainingPlanFromDataBase = trainingPlanMapper.trainingPlanDtoToTrainingPlan(trainingPlanDtoFromDataBase);
        TrainingPlan trainingPlanToUpdate = trainingPlanMapper.trainingPlanDtoToTrainingPlan(trainingPlanDtoFromDataBase);

        trainingPlanFromDataBase.setTitle(trainingPlanToUpdate.getTitle());
        trainingPlanFromDataBase.setClient(trainingPlanToUpdate.getClient());

        trainingPlanRepository.save(trainingPlanFromDataBase);


    }
}
