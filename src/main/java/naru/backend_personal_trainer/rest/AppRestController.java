package naru.backend_personal_trainer.rest;


import naru.backend_personal_trainer.model.Client;
import naru.backend_personal_trainer.model.Trainer;
import naru.backend_personal_trainer.model.Training;
import naru.backend_personal_trainer.model.TrainingPlan;
import naru.backend_personal_trainer.service.client.ClientService;
import naru.backend_personal_trainer.service.trainer.TrainerService;
import naru.backend_personal_trainer.service.training.TrainingService;
import naru.backend_personal_trainer.service.training_plan.TrainingPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
@CrossOrigin
public class AppRestController {

    private final TrainerService trainerService;
    private final ClientService clientService;
    private final TrainingService trainingService;
    private final TrainingPlanService trainingPlanService;

    public AppRestController(TrainerService trainerService, ClientService clientService, TrainingService trainingService,TrainingPlanService trainingPlanService) {
        this.trainerService = trainerService;
        this.clientService = clientService;
        this.trainingService=trainingService;
        this.trainingPlanService = trainingPlanService;
    }

    //test
    @GetMapping("/trainers")
    List<Trainer> getTrainerList() {
        return trainerService.findAll();
    }
    //test
    @GetMapping("/clients")
    List<Client> getClientList(){
        return clientService.findAll();
    }

    //test
    @DeleteMapping("/trainings")
   String deleteTraining(){
        Training tmp = trainingService.getById(1);
        trainingService.delete(tmp.getId());
    return "deleted " + tmp;
    }
    //test
    @PostMapping("/create")
    String creator(){

        Trainer tmpTrainer = new Trainer("Ania", "Zawisza", " Yoga");
        Training tmpTraining = new Training("Meditation","Meditate for 2 min's");
        Training tmpTraining2 =  new Training("Pumps","do 20 pumps x3 with 2 min's break");
        TrainingPlan tmpTrainingPlan = new TrainingPlan("Maestro Arms");
        Client tmpClient = new Client("Damian", "Tomasik", "żołdak@robak.com");

        tmpTrainingPlan.add(tmpTraining);
        tmpTrainingPlan.add(tmpTraining2);
        tmpTrainingPlan.setClient(tmpClient);
        tmpClient.setTrainingPlan(tmpTrainingPlan);
        tmpTrainer.add(tmpTrainingPlan);

        trainingService.save(tmpTraining);
        trainingService.save(tmpTraining2);
        clientService.save(tmpClient);
        trainerService.save(tmpTrainer);
        trainingPlanService.save(tmpTrainingPlan);




      return "saved!" + tmpTrainingPlan;

    }
    @GetMapping("/training_plans")
    List<TrainingPlan> getTrainingPlanList() {
        return trainingPlanService.findAll();
    }
}
