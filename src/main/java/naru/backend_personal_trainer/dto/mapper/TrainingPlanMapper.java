package naru.backend_personal_trainer.dto.mapper;

import naru.backend_personal_trainer.dto.entities.TrainingPlanDto;
import naru.backend_personal_trainer.model.TrainingPlan;
import naru.backend_personal_trainer.repository.ClientRepository;
import naru.backend_personal_trainer.repository.TrainerRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TrainerRepository.class, ClientRepository.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface TrainingPlanMapper {
        @Mapping(source = "trainer.id", target = "trainerId")
        @Mapping(source = "client.id", target = "clientId")
        TrainingPlanDto trainingPlanToTrainingPlanDto(TrainingPlan trainingPlan);


    @Mapping(source = "trainerId", target = "trainer.id")
    @Mapping(source = "clientId", target = "client.id")
    @Mapping(ignore = true, target = "trainings")
    TrainingPlan trainingPlanDtoToTrainingPlan(TrainingPlanDto trainingPlanDto);


    List<TrainingPlanDto> trainingPlanToTrainingPlansDto(List<TrainingPlan> trainingPlans);

    List<TrainingPlan> trainingPlansDtoToTrainingPlan(List<TrainingPlanDto> trainingPlansDto);
}
