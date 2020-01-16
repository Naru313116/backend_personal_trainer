package naru.backend_personal_trainer.repository;

import naru.backend_personal_trainer.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

}
