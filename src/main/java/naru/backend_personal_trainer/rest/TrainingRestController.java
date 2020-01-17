package naru.backend_personal_trainer.rest;


import naru.backend_personal_trainer.dto.entities.TrainingDto;
import naru.backend_personal_trainer.service.training.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
@CrossOrigin
public class TrainingRestController {

    private final TrainingService trainingService;

    public TrainingRestController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/trainings")
    public List<TrainingDto> getList() {
        return trainingService.findAll();
    }

    @GetMapping("/trainings/{trainingId}")
    public TrainingDto getById(@PathVariable int trainingId) {

        TrainingDto trainingDto = trainingService.getById(trainingId);
        if (trainingDto.getId() == 0) {
            throw new RuntimeException("cannot find trainer with id = " + trainingId);
        }
        return trainingDto;
    }


    @PostMapping("/trainings")
    public TrainingDto saveTraining(@RequestBody TrainingDto trainingDto) {
        trainingService.save(trainingDto);
        return trainingDto;
    }

    @PutMapping("/trainings/{trainingId}")
    public TrainingDto updateTraining(@RequestBody TrainingDto trainingDto, @PathVariable int trainingId) {
        TrainingDto trainingFromDB = trainingService.getById(trainingId);

        trainingService.updateTraining(trainingFromDB, trainingDto);
        return trainingDto;

    }

    @DeleteMapping("/trainings/{trainingId}")
    public String deleteTraining(@PathVariable int trainingId) {
        TrainingDto trainingDto = trainingService.getById(trainingId);

        if (trainingDto.getId() == 0) {
            throw new RuntimeException("cannot find employee with id: " + trainingDto);
        }

        trainingService.delete(trainingId);
        return "Deleted employee with id: " + trainingId;
    }

}
