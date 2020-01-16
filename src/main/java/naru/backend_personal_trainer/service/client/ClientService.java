package naru.backend_personal_trainer.service.client;

import naru.backend_personal_trainer.model.Client;

import java.util.List;


public interface ClientService {

   List<Client> findAll();
   Client getById(int clientId);
   void save(Client client);
   void delete(int clientId);

}
