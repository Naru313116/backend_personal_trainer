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
@Table
public class Trainer {

    public Trainer(String firstName, String lastName, String specialization, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String password;

    @OneToMany(mappedBy = "trainer", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<TrainingPlan> trainingPlans;

    //methods
    public void add(TrainingPlan trainingPlan){
        if(trainingPlans == null){
            trainingPlans = new ArrayList<>();
        }
        trainingPlans.add(trainingPlan);
        trainingPlan.setTrainer(this);
    }
    //Overriders
    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }


}
