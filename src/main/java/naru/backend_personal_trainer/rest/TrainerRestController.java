package naru.backend_personal_trainer.rest;


import naru.backend_personal_trainer.dto.entities.ClientDto;
import naru.backend_personal_trainer.dto.entities.TrainerDto;
import naru.backend_personal_trainer.service.trainer.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
@CrossOrigin
public class TrainerRestController {

    private final TrainerService trainerService;

    public TrainerRestController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @GetMapping("/trainers")
    public List<TrainerDto> getList() {
        return trainerService.findAll();
    }

    @GetMapping("/trainers/{trainerId}")
    public TrainerDto getById(@PathVariable int trainerId) {

        TrainerDto trainerDto = trainerService.getById(trainerId);
        if (trainerDto.getId() == 0) {
            throw new RuntimeException("cannot find trainer with id = " + trainerId);
        }
        return trainerDto;
    }

}
