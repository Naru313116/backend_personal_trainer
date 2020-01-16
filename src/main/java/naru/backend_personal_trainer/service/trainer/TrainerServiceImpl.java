package naru.backend_personal_trainer.service.trainer;

import naru.backend_personal_trainer.dto.entities.TrainerDto;
import naru.backend_personal_trainer.dto.mapper.TrainerMapper;
import naru.backend_personal_trainer.dto.mapper.TrainerRegistrationMapper;
import naru.backend_personal_trainer.model.Trainer;
import naru.backend_personal_trainer.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;
    private final TrainerRegistrationMapper trainerRegistrationMapper;
    public TrainerServiceImpl(TrainerRepository trainerRepository, TrainerMapper trainerMapper, TrainerRegistrationMapper trainerRegistrationMapper) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
        this.trainerRegistrationMapper = trainerRegistrationMapper;
    }

    @Override
    public List<TrainerDto> findAll() {
        return null;//TODO trainerRepository.findAll();
    }

    @Override
    public TrainerDto getById(int trainerId) {

        Trainer trainer = trainerRepository.findById(trainerId).orElse(new Trainer());
        return trainerMapper.trainerToTrainerDto(trainer);
    }

    @Override
    public void save(TrainerDto trainer) {
    //TODO trainerRepository.save(trainer);
    }

    @Override
    public void delete(int trainerId) {
    trainerRepository.deleteById(trainerId);
    }
}
