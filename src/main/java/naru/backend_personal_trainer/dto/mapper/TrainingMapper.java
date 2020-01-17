package naru.backend_personal_trainer.dto.mapper;

import naru.backend_personal_trainer.repository.TrainingPlanRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TrainingPlanRepository.class,injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TrainingMapper {

}
