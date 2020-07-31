package persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "gyms")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "gym", cascade = CascadeType.ALL)
    private Workout workout;

    public Gym(String name, Workout workout) {
        this.name = name;
        this.workout = workout;
    }

    public Gym(String name) {
        this.name = name;
    }

    public Gym() {

    }

    public String getName() {
        return name;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public String toString() {
        return this.name;
    }

}
