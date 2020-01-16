package naru.backend_personal_trainer.service.client;

import naru.backend_personal_trainer.dto.entities.ClientDto;
import naru.backend_personal_trainer.dto.entities.ClientRegistrationDto;

import java.util.List;


public interface ClientService {

   List<ClientDto> findAll();
   ClientRegistrationDto getByIdToEdit(int clientId);
   ClientDto getById(int clientId);
   void save(ClientDto clientDto);
   void delete(int clientId);

}
