package naru.backend_personal_trainer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TrainingPlan {

    public TrainingPlan(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToOne( cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "trainingPlan", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Training> trainings;

    public void add(Training training) {
        if (trainings == null) {
            trainings = new ArrayList<>();
        }
        trainings.add(training);
        training.setTrainingPlan(this);
    }

//overriders
    @Override
    public String toString() {
        return "TrainingPlan{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", trainer=" + trainer +
                ", client=" + client +
                ", trainings=" + trainings +
                '}';
    }
}
