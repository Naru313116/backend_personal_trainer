package naru.backend_personal_trainer.service.trainer;

import naru.backend_personal_trainer.dto.entities.*;
import naru.backend_personal_trainer.model.Trainer;

import java.util.List;

public interface TrainerService {
    List<TrainerDto> findAll();
    TrainerDto getById(int trainerId);
    TrainerRegistrationDto getByIdToEdit(int trainerId);
    void save(TrainerDto trainerDto);
    void save(TrainerRegistrationDto trainerRegistrationDto);
    void delete(int trainerId);
    void updateTrainer(String oldPassword, String newPassword, TrainerDto trainerDtoFromDataBase, TrainerDto trainerDtoToSave);
}
