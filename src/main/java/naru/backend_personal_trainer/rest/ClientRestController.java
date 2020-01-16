
package naru.backend_personal_trainer.rest;

import naru.backend_personal_trainer.dto.entities.ClientDto;
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

    @PostMapping("/clients")
    public ClientDto saveClient(@RequestBody ClientDto clientDto) {
        clientService.save(clientDto);
        return clientDto;
    }

    @PutMapping("/clients")
    public ClientDto updateClient(@RequestBody ClientDto clientDto) {
        clientService.save(clientDto);
        return clientDto;
    }

    @DeleteMapping("/clients/{clientId}")
    public String deleteEmployee(@PathVariable int clientId){
        ClientDto client = clientService.getById(clientId);
        if(client == null){
            throw new RuntimeException("cannot find employee with id: " + clientId);
        }
        clientService.delete(clientId);
        return "Deleted employee with id: "+ clientId;
    }

}

