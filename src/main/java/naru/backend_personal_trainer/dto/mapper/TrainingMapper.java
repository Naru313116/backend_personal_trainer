package naru.backend_personal_trainer.dto.mapper;

import naru.backend_personal_trainer.dto.entities.TrainingDto;
import naru.backend_personal_trainer.model.Training;
import naru.backend_personal_trainer.repository.TrainingPlanRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = TrainingPlanRepository.class,injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TrainingMapper {

    @Mapping(source = "trainingPlan.id", target = "trainingPlanId")
    TrainingDto trainingToTrainingDto(Training training);

    @Mapping(source = "trainingPlanId", target = "trainingPlan.id")
    Training trainingDtoToTraining(TrainingDto trainingDto);


    List<TrainingDto> trainingsToTrainingsDto(List<Training> trainings);

    List<Training> trainingsDtoToTrainings(List<TrainingDto> trainingsDto);
}
