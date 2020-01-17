package naru.backend_personal_trainer.service.training;

import naru.backend_personal_trainer.dto.entities.TrainingDto;
import naru.backend_personal_trainer.dto.mapper.TrainingMapper;
import naru.backend_personal_trainer.model.Training;
import naru.backend_personal_trainer.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {


    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;

    public TrainingServiceImpl(TrainingRepository trainingRepository, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.trainingMapper = trainingMapper;
    }

    @Override
    public List<TrainingDto> findAll() {
        return trainingRepository.findAll().stream().map(trainingMapper::trainingToTrainingDto).collect(Collectors.toList());
    }

    @Override
    public TrainingDto getById(int trainingId) {

        Training training = trainingRepository.findById(trainingId).orElse(new Training());
            return trainingMapper.trainingToTrainingDto(training);
    }

    @Override
    public void save(TrainingDto trainingDto) {
       Training training = trainingMapper.trainingDtoToTraining(trainingDto);
       trainingRepository.save(training);
    }

    @Override
    public void updateTraining(TrainingDto trainingDtoFromDataBase, TrainingDto trainingDtoToSave) {
        Training trainingFromDB = trainingMapper.trainingDtoToTraining(trainingDtoFromDataBase);
        Training trainingToUpdate = trainingMapper.trainingDtoToTraining(trainingDtoToSave);

        trainingFromDB.setTrainingPlan(trainingToUpdate.getTrainingPlan());
        trainingFromDB.setTitle(trainingToUpdate.getTitle());
        trainingFromDB.setDescription(trainingToUpdate.getDescription());

        trainingRepository.save(trainingFromDB);
    }


    @Override
    public void delete(int trainingId) {

        trainingRepository.deleteById(trainingId);
    }
}
