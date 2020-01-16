package naru.backend_personal_trainer.service.client;

import naru.backend_personal_trainer.model.Client;
import naru.backend_personal_trainer.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
        //.stream().map(client -> clientmapper.clienttoclientdto(client)).collect(Collectors.toList()
    }

    @Override
    public Client getById(int clientId) {
        return clientRepository.findById(clientId).orElse(new Client());
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(int clientId) {
        clientRepository.deleteById(clientId);
    }
}
