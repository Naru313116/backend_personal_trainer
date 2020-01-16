
package naru.backend_personal_trainer.rest;

import naru.backend_personal_trainer.model.Client;
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
    public List<Client> getList() {
        return clientService.findAll();
    }

    @GetMapping("/clients/{clientId}")
    public Client getById(@PathVariable int clientId) {

        Client client = clientService.getById(clientId);
        if (client == null) {
            throw new RuntimeException("cannot find Employee with id = " + clientId);
        }
        return client;
    }

    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client) {
        clientService.save(client);
        return client;
    }

    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client client) {
        clientService.save(client);
        return client;
    }

    @DeleteMapping("/clients/{clientId}")
    public String deleteEmployee(@PathVariable int clientId){
        Client client = clientService.getById(clientId);
        if(client == null){
            throw new RuntimeException("cannot find employee with id: " + clientId);
        }
        clientService.delete(clientId);
        return "Deleted employee with id: "+ clientId;
    }

}

