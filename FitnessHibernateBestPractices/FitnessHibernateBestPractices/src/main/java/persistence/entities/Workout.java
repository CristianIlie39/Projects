package persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @Column(name = "aerobic")
    private boolean aerobic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gyms_id")
    private Gym gym;

    public Workout(String name, int duration, boolean aerobic, Gym gym) {
        this.name = name;
        this.duration = duration;
        this.aerobic = aerobic;
        this.gym = gym;
    }

    public Workout() {

    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public boolean getAerobic() {
        return aerobic;
    }

    public Gym getGym() {
        return gym;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAerobic(boolean aerobic) {
        this.aerobic = aerobic;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public String toString() {
        return this.name + " " + this.duration + " " + this.aerobic;
    }


}
