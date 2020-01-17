package naru.backend_personal_trainer.service.trainer;

import naru.backend_personal_trainer.dto.entities.ClientRegistrationDto;
import naru.backend_personal_trainer.dto.entities.TrainerDto;
import naru.backend_personal_trainer.dto.entities.TrainerRegistrationDto;
import naru.backend_personal_trainer.dto.mapper.TrainerMapper;
import naru.backend_personal_trainer.dto.mapper.TrainerRegistrationMapper;
import naru.backend_personal_trainer.model.Client;
import naru.backend_personal_trainer.model.Trainer;
import naru.backend_personal_trainer.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return trainerRepository.findAll().stream().map(trainerMapper::trainerToTrainerDto).collect(Collectors.toList());
    }

    @Override
    public TrainerDto getById(int trainerId) {

        Trainer trainer = trainerRepository.findById(trainerId).orElse(new Trainer());
        return trainerMapper.trainerToTrainerDto(trainer);
    }

    @Override
    public TrainerRegistrationDto getByIdToEdit(int trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId).orElse(new Trainer());
        return trainerRegistrationMapper.trainerToTrainerRegistrationDto(trainer);
    }

    @Override
    public void save(TrainerDto trainerDto) {
        Trainer trainer = trainerMapper.trainerDtoToTrainer(trainerDto);
        trainerRepository.save(trainer);

    }

    @Override
    public void save(TrainerRegistrationDto trainerRegistrationDto) {
        Trainer trainer = trainerRegistrationMapper.trainerRegistrationDtoToTrainer(trainerRegistrationDto);
        trainerRepository.save(trainer);
    }

    @Override
    public void delete(int trainerId) {
    trainerRepository.deleteById(trainerId);
    }

    @Override
    public void updateTrainer(String oldPassword, String newPassword, TrainerDto trainerDtoFromDataBase, TrainerDto trainerDtoToSave) {
        Trainer trainer = trainerMapper.trainerDtoToTrainer(trainerDtoFromDataBase);
        Trainer trainerToUpdate = trainerMapper.trainerDtoToTrainer(trainerDtoToSave);
        if(trainer.getPassword().equals(oldPassword)){
            trainer.setPassword(newPassword);
            trainer.setSpecialization(trainerToUpdate.getSpecialization());
            trainer.setFirstName(trainerToUpdate.getFirstName());
            trainer.setLastName(trainerToUpdate.getLastName());
        }else throw new RuntimeException("wrong password!");
        trainerRepository.save(trainer);
    }


}
