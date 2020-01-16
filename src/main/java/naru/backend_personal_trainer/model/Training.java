package naru.backend_personal_trainer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Training {

    public Training( String title,String description) {
        this.title = title;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String title;
    private String description;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    //overriders

    @Override
    public String toString() {
        return "Training{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                '}';
    }
}
