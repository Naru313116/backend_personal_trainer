package naru.backend_personal_trainer.service.trainer;

import naru.backend_personal_trainer.model.Trainer;
import naru.backend_personal_trainer.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    private final TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getById(int trainerId) {
        return trainerRepository.findById(trainerId).orElse(new Trainer());
    }

    @Override
    public void save(Trainer trainer) {
    trainerRepository.save(trainer);
    }

    @Override
    public void delete(int trainerId) {
    trainerRepository.deleteById(trainerId);
    }
}
