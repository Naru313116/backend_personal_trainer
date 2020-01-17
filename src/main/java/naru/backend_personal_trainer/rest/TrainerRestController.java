package naru.backend_personal_trainer.rest;


import naru.backend_personal_trainer.dto.entities.TrainerDto;
import naru.backend_personal_trainer.dto.entities.TrainerRegistrationDto;
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

    @GetMapping("/edit_trainer/{trainerId}")
    public TrainerRegistrationDto getByIdToEdit(@PathVariable int trainerId) {
        TrainerRegistrationDto trainer = trainerService.getByIdToEdit(trainerId);
        if (trainer.getId() == 0) {
            throw new RuntimeException("cannot find Employee with id = " + trainerId);
        }
        return trainer;
    }

    @PostMapping("/trainers")
    public TrainerRegistrationDto saveTrainer(@RequestBody TrainerRegistrationDto trainerRegistrationDto) {
        trainerService.save(trainerRegistrationDto);
        return trainerRegistrationDto;
    }

    @PutMapping("/trainers/{trainerId}")
    public TrainerDto updateTrainer(@RequestParam(value = "oldPass", required = false) String oldPassword,
                                    @RequestParam(value = "newPass", required = false) String newPassword,
                                    @RequestBody TrainerDto trainerDto, @PathVariable int trainerId) {
        TrainerDto tmpTrainerDto = trainerService.getById(trainerId);

        trainerService.updateTrainer(oldPassword, newPassword, tmpTrainerDto,trainerDto);
        return tmpTrainerDto;
    }

    @DeleteMapping("/trainers/{trainerId}")
    public String deleteTrainer(@PathVariable int trainerId) {
        TrainerDto trainerDto = trainerService.getById(trainerId);
        if (trainerDto.getId() == 0) {
            throw new RuntimeException("cannot find employee with id: " + trainerDto);
        }
        trainerService.delete(trainerId);
        return "Deleted employee with id: " + trainerId;
    }

}
