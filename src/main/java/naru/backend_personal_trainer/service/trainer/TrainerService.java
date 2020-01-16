package naru.backend_personal_trainer.service.trainer;

import naru.backend_personal_trainer.model.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> findAll();
    Trainer getById(int trainerId);
    void save(Trainer trainer);
    void delete(int trainerId);
}
