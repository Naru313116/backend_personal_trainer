package naru.backend_personal_trainer.dto.mapper;

import naru.backend_personal_trainer.dto.entities.TrainingPlanDto;
import naru.backend_personal_trainer.model.TrainingPlan;
import naru.backend_personal_trainer.repository.ClientRepository;
import naru.backend_personal_trainer.repository.TrainerRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        TrainerRepository.class,
        ClientRepository.class,
        TrainingMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface TrainingPlanMapper {
    @Mapping(source = "trainer.id", target = "trainerId")
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "trainings", target = "trainingsDto")
    TrainingPlanDto trainingPlanToTrainingPlanDto(TrainingPlan trainingPlan);


    @Mapping(source = "trainerId", target = "trainer.id")
    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "trainingsDto", target = "trainings")
    TrainingPlan trainingPlanDtoToTrainingPlan(TrainingPlanDto trainingPlanDto);


    List<TrainingPlanDto> trainingPlansToTrainingPlansDto(List<TrainingPlan> trainingPlans);

    List<TrainingPlan> trainingPlansDtoToTrainingPlans(List<TrainingPlanDto> trainingPlansDto);
}
