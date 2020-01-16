package naru.backend_personal_trainer.service.client;

import naru.backend_personal_trainer.dto.entities.ClientDto;
import naru.backend_personal_trainer.dto.entities.ClientRegistrationDto;
import naru.backend_personal_trainer.dto.mapper.ClientMapper;
import naru.backend_personal_trainer.dto.mapper.ClientRegistrationMapper;
import naru.backend_personal_trainer.model.Client;
import naru.backend_personal_trainer.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;
    private ClientRegistrationMapper clientRegistrationMapper;
    @Autowired
    ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper,ClientRegistrationMapper clientRegistrationMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper=clientMapper;
        this.clientRegistrationMapper = clientRegistrationMapper;
    }


    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map( client -> clientMapper.clientToClientDto(client)).collect(Collectors.toList());
        //.stream().map(client -> clientmapper.clienttoclientdto(client)).collect(Collectors.toList()
    }

    @Override
    public ClientRegistrationDto getByIdToEdit(int clientId) {
        Client client = clientRepository.findById(clientId).orElse(new Client());
        return clientRegistrationMapper.clientToClientRegistrationDto(client);
    }
    @Override
    public ClientDto getById(int clientId) {

        Client client = clientRepository.findById(clientId).orElse(new Client());
        return clientMapper.clientToClientDto(client);
    }

    @Override
    public void save(ClientDto clientDto) {
        Client client = clientMapper.clientDtoToClient(clientDto);
        clientRepository.save(client);
    }

    @Override
    public void delete(int clientId) {
        clientRepository.deleteById(clientId);
    }
}
