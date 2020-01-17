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
        return clientRepository.findAll().stream().map(clientMapper::clientToClientDto).collect(Collectors.toList());
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
    public void save(ClientRegistrationDto clientDto) {
        Client client = clientRegistrationMapper.clientRegistrationDtoToClient(clientDto);
        clientRepository.save(client);
    }

    @Override
    public void delete(int clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public void updateClient(String oldPassword, String newPassword, ClientDto clientDtoFromDataBase, ClientDto clientDtoToSave) {
        Client client = clientMapper.clientDtoToClient(clientDtoFromDataBase);
        Client clientToUpdate = clientMapper.clientDtoToClient(clientDtoToSave);
        if(client.getPassword().equals(oldPassword)){
            client.setPassword(newPassword);
            client.setEmail(clientToUpdate.getEmail());
            client.setFirstName(clientToUpdate.getFirstName());
            client.setLastName(clientToUpdate.getLastName());
        }else throw new RuntimeException("wrong password!");
        clientRepository.save(client);
    }


}
