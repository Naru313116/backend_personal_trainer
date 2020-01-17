package naru.backend_personal_trainer.dto.mapper;

import naru.backend_personal_trainer.dto.entities.TrainerRegistrationDto;
import naru.backend_personal_trainer.model.Trainer;
import naru.backend_personal_trainer.repository.TrainingPlanRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses =  TrainingPlanRepository.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TrainerRegistrationMapper {

    TrainerRegistrationDto trainerToTrainerRegistrationDto(Trainer trainer);

    @Mapping(ignore = true, target = "trainingPlans")
    Trainer trainerRegistrationDtoToTrainer(TrainerRegistrationDto trainerDto);

}
