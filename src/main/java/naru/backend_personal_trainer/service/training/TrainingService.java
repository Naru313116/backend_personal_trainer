package naru.backend_personal_trainer.service.training;


import naru.backend_personal_trainer.model.Training;

import java.util.List;

public interface TrainingService {

    List<Training> findAll();
    Training getById(int trainingId);
    void save(Training training);
    void delete(int trainingId);

}
