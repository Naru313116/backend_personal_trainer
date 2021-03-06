package naru.backend_personal_trainer.dto.mapper;

import naru.backend_personal_trainer.dto.entities.ClientDto;
import naru.backend_personal_trainer.model.Client;
import naru.backend_personal_trainer.repository.TrainingPlanRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses =  TrainingPlanRepository.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper {


    ClientDto clientToClientDto(Client client);

    @Mapping(ignore = true, target = "trainingPlan")
    @Mapping(ignore = true, target = "password")
    Client clientDtoToClient(ClientDto clientDto);


}
