package naru.backend_personal_trainer.rest;


import naru.backend_personal_trainer.service.training_plan.TrainingPlanService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
@CrossOrigin
public class TrainingPlanRestController {

    private final TrainingPlanService trainingPlanService;

    public TrainingPlanRestController(TrainingPlanService trainingPlanService) {
        this.trainingPlanService = trainingPlanService;
    }


}
