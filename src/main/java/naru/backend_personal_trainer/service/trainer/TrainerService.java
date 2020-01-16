package naru.backend_personal_trainer.service.trainer;

import naru.backend_personal_trainer.dto.entities.TrainerDto;
import naru.backend_personal_trainer.model.Trainer;

import java.util.List;

public interface TrainerService {
    List<TrainerDto> findAll();
    TrainerDto getById(int trainerId);
    void save(TrainerDto trainer);
    void delete(int trainerId);
}
