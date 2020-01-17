package naru.backend_personal_trainer.dto.mapper;

import naru.backend_personal_trainer.dto.entities.ClientRegistrationDto;
import naru.backend_personal_trainer.model.Client;
import naru.backend_personal_trainer.repository.TrainingPlanRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses =  TrainingPlanRepository.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientRegistrationMapper {


    ClientRegistrationDto clientToClientRegistrationDto(Client client);

    @Mapping(ignore = true, target = "trainingPlan")
    Client clientRegistrationDtoToClient(ClientRegistrationDto clientDto);


}
