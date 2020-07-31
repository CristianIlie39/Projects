import persistence.dao.PersonDAO;
import persistence.dao.SubscriptionDAO;
import persistence.dao.WorkoutDAO;
import persistence.entities.Gym;
import persistence.entities.Person;
import persistence.entities.Subscription;
import persistence.entities.Workout;

import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        //Sa se insereze 5 persoane, 3 abonamente si 10 antrenamente

        SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
        WorkoutDAO workoutDAO = new WorkoutDAO();
        PersonDAO personDAO = new PersonDAO();

        //aici inseram 5 persoane si 3 abonamente
        Subscription subscription1 = new Subscription("Silver",100, "2020-08-01", "2020-08-31");
        Person person1 = new Person("Marculescu", "George", 1979, subscription1);
        personDAO.insert(person1); //abonamentul 1 a fost introdus automat prin cascadare

        Person person2 = new Person("Popescu", "Marcel", 1975, subscription1);
        personDAO.insert(person2);

        Subscription subscription2 = new Subscription("Gold", 200, "2020-08-01", "2020-08-31");
        Person person3 = new Person("Ionescu", "Andrei", 1985, subscription2);
        personDAO.insert(person3); //abonamentul 2 a fost introdus automat prin cascadare

        Person person4 = new Person("Gergescu", "Alexandru", 1995, subscription2);
        personDAO.insert(person4);

        Subscription subscription3 = new Subscription("Platinum", 300, "2020-08-01", "2020-08-31");
        Person person5 = new Person("Codreanu", "Dumitrel", 1978, subscription3);
        personDAO.insert(person5); //abonamentul 3 a fost introdus automat prin cascadare


        //aici inseram 10 antrenamente
        Gym gym1 = new Gym("sala forta");
        Workout workout1 = new Workout("forta", 20, true, gym1);
        workoutDAO.insert(workout1);

        Gym gym2 = new Gym("sala yoga");
        Workout workout2 = new Workout("yoga", 15, false, gym2);
        workoutDAO.insert(workout2);

        Gym gym3 = new Gym("sala pilates");
        Workout workout3 = new Workout("pilates", 20, false, gym3);
        workoutDAO.insert(workout3);

        Gym gym4 = new Gym("sala gimnastica");
        Workout workout4 = new Workout("gimnastica ritmica", 30, true, gym4);
        workoutDAO.insert(workout4);

        Gym gym5 = new Gym("sala culturism");
        Workout workout5 = new Workout("culturism", 30, true, gym5);
        workoutDAO.insert(workout5);

        Gym gym6 = new Gym("sala body pump");
        Workout workout6 = new Workout("body pump", 25, true, gym6);
        workoutDAO.insert(workout6);

        Gym gym7 = new Gym("sala fitball");
        Workout workout7 = new Workout("fitball", 20, true, gym7);
        workoutDAO.insert(workout7);

        Gym gym8 = new Gym("sala kangoo jumping");
        Workout workout8 = new Workout("kangoo jumping", 30, true, gym8);
        workoutDAO.insert(workout8);

        Gym gym9 = new Gym("sala stick");
        Workout workout9 = new Workout("stick", 25, false, gym9);
        workoutDAO.insert(workout9);

        Gym gym10 = new Gym("sala cardio");
        Workout workout10 = new Workout("cardio", 20, true, gym10);
        workoutDAO.insert(workout10);






    }
}
