package naru.backend_personal_trainer.rest;


import naru.backend_personal_trainer.dto.entities.TrainerDto;
import naru.backend_personal_trainer.dto.entities.TrainingPlanDto;
import naru.backend_personal_trainer.service.training_plan.TrainingPlanService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
