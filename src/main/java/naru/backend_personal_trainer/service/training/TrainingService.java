package naru.backend_personal_trainer.service.training;


import naru.backend_personal_trainer.dto.entities.TrainingDto;

import java.util.List;

public interface TrainingService {

    List<TrainingDto> findAll();
    TrainingDto getById(int trainingId);
    void save(TrainingDto trainingDto);
    void updateTraining(TrainingDto trainingDtoFromDataBase, TrainingDto trainingDtoToSave);
    void delete(int trainingId);

}
