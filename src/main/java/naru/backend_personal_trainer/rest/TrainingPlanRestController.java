package naru.backend_personal_trainer.rest;


import naru.backend_personal_trainer.dto.entities.TrainingPlanDto;
import naru.backend_personal_trainer.service.training_plan.TrainingPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
@CrossOrigin
public class TrainingPlanRestController {

    private final TrainingPlanService trainingPlanService;

    public TrainingPlanRestController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }

    @GetMapping("/training_plans")
    public List<TrainingPlanDto> getList() {
        return trainingPlanService.findAll();
    }

    @GetMapping("/training_plans/{trainingPlanId}")
    public TrainingPlanDto getById(@PathVariable int trainingPlanId) {

        TrainingPlanDto trainingPlanDto = trainingPlanService.getById(trainingPlanId);
        if (trainingPlanDto.getId() == 0) {
            throw new RuntimeException("cannot find trainer with id = " + trainingPlanId);
        }
        return trainingPlanDto;
    }

    @PostMapping("/training_plans")
    public TrainingPlanDto saveTrainingPlan(@RequestBody TrainingPlanDto trainingPlanDto) {
        trainingPlanService.save(trainingPlanDto);
        return trainingPlanDto;
    }

    @PutMapping("/training_plans/{trainingPlanId}")
    public TrainingPlanDto updateTrainingPlan(@RequestBody TrainingPlanDto trainingPlanDto, @PathVariable int trainingPlanId) {
        TrainingPlanDto trainingPlanFromDB = trainingPlanService.getById(trainingPlanId);

        trainingPlanService.updateTrainingPlan(trainingPlanFromDB, trainingPlanDto);
        return trainingPlanDto;

    }

    @DeleteMapping("/training_plans/{trainingPlanId}")
    public String deleteTrainingPlan(@PathVariable int trainingPlanId) {
        TrainingPlanDto trainingPlanDto = trainingPlanService.getById(trainingPlanId);

        if (trainingPlanDto.getId() == 0) {
            throw new RuntimeException("cannot find employee with id: " + trainingPlanDto);
        }

        trainingPlanService.delete(trainingPlanId);
        return "Deleted employee with id: " + trainingPlanId;
    }
}
