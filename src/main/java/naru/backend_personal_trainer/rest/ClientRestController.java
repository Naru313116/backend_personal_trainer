
package naru.backend_personal_trainer.rest;

import naru.backend_personal_trainer.dto.entities.ClientDto;
import naru.backend_personal_trainer.dto.entities.ClientRegistrationDto;
import naru.backend_personal_trainer.service.client.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
@CrossOrigin
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientDto> getList() {
        return clientService.findAll();
    }

    @GetMapping("/clients/{clientId}")
    public ClientDto getById(@PathVariable int clientId) {

        ClientDto client = clientService.getById(clientId);
        if (client.getId() == 0) {
            throw new RuntimeException("cannot find Employee with id = " + clientId);
        }
        return client;
    }

    @GetMapping("/edit_client/{clientId}")
    public ClientRegistrationDto getByIdToEdit(@PathVariable int clientId) {

        ClientRegistrationDto client = clientService.getByIdToEdit(clientId);
        if (client.getId() == 0) {
            throw new RuntimeException("cannot find Employee with id = " + clientId);
        }
        return client;
    }


    @PostMapping("/clients")
    public ClientRegistrationDto saveClient(@RequestBody ClientRegistrationDto clientRegistrationDto) {
        clientService.save(clientRegistrationDto);
        return clientRegistrationDto;
    }

    @PutMapping("/clients/{clientId}")
    public ClientDto updateClient(@RequestParam(value = "oldPass", required = false) String oldPassword,
                                  @RequestParam(value = "newPass", required = false) String newPassword,
                                  @RequestBody ClientDto clientDto, @PathVariable int clientId) {
        ClientDto tmpClientDto = clientService.getById(clientId);

        /*if(tmpClientDto.getId() == 0){
            clientDto.setId(clientId);
             clientService.save(clientDto);
            return clientDto;
        }*/
        clientService.updateClient(oldPassword, newPassword, tmpClientDto, clientDto);
        return tmpClientDto;
    }

    @DeleteMapping("/clients/{clientId}")
    public String deleteClient(@PathVariable int clientId) {
        ClientDto client = clientService.getById(clientId);
        if (client.getId() == 0) {
            throw new RuntimeException("cannot find employee with id: " + clientId);
        }
        clientService.delete(clientId);
        return "Deleted employee with id: " + clientId;
    }

}

