package naru.backend_personal_trainer.dto.mapper;

import naru.backend_personal_trainer.dto.entities.TrainerDto;
import naru.backend_personal_trainer.model.Trainer;
import naru.backend_personal_trainer.repository.TrainingPlanRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses =  TrainingPlanRepository.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TrainerMapper {
    @Mapping(source = "trainingPlans", target = "trainingPlans")
    TrainerDto trainerToTrainerDto(Trainer trainer);
//todo wali rekursje cweloswo jedno
    @Mapping(source = "trainingPlans", target = "trainingPlans")
    @Mapping(ignore = true, target = "password")
    Trainer trainerDtoToTrainer(TrainerDto trainerDto);

}
