import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        /* Inventar:
           - 4 fisiere text din care citim 1 Trainee si 3 Grupele

           - 1 clasa abstracta Person
           - 1 clasa Trainer
           - 1 clasa Trainee
           - 1 clasa Group
           - 1 clasa cu exceptia MaximumNumberOfStudentsReached
           - 1 clasa SoftwareDevelopmentAcademy (folosim Singleton) contine o colectie Set de grupe

           - o colectie Set pentru Trainee

         */
        try {

            String filePathTrainees1 = "D:\\cursuri Alex\\20.06.2020\\FisierTrainees1.txt";
            String filePathTrainees2 = "D:\\cursuri Alex\\20.06.2020\\FisierTrainees2.txt";
            String filePathTrainees3 = "D:\\cursuri Alex\\20.06.2020\\FisierTrainees3.txt";
            String filePathGroups = "D:\\cursuri Alex\\20.06.2020\\FisierGrupe.txt";

            FileReader fileReaderTrainees1 = new FileReader(filePathTrainees1);
            FileReader fileReaderTrainees2 = new FileReader(filePathTrainees2);
            FileReader fileReaderTrainees3 = new FileReader(filePathTrainees3);
            FileReader fileReaderGroups = new FileReader(filePathGroups);

            BufferedReader bufferedReaderTrainees1 = new BufferedReader(fileReaderTrainees1);
            BufferedReader bufferedReaderTrainees2 = new BufferedReader(fileReaderTrainees2);
            BufferedReader bufferedReaderTrainees3 = new BufferedReader(fileReaderTrainees3);
            BufferedReader bufferedReaderGroups = new BufferedReader(fileReaderGroups);

            //aici ne ocupam de studentii din grupa1
            Set<Trainee> traineesGroup1 = new HashSet<Trainee>();
            String text = bufferedReaderTrainees1.readLine();

            while (text != null && !(text.isEmpty())) {
                String[] arrayCuvinte = text.split(";");
                Trainee trainee = new Trainee(arrayCuvinte[0], arrayCuvinte[1], Integer.valueOf(arrayCuvinte[2]), Boolean.valueOf(arrayCuvinte[3]));
                if (traineesGroup1.size() == 5) {
                    throw new MaximumNumberOfStudentsReached("Numarul studentilor din grupa 1 este mai mare decat 5");
                } else {
                    traineesGroup1.add(trainee);
                }
                text = bufferedReaderTrainees1.readLine();

            }
            System.out.println("Afisam studentii din grupa 1");
            for (Trainee trainee : traineesGroup1) {
                System.out.println(trainee.toString());
            }


            //aici ne ocupam de studentii din grupa2
            Set<Trainee> traineesGroup2 = new HashSet<>();
            String text2 = bufferedReaderTrainees2.readLine();
            while (text2 != null && !text2.isEmpty()) {
                String[] arrayCuvinte = text2.split(";");
                Trainee trainee = new Trainee(arrayCuvinte[0], arrayCuvinte[1], Integer.valueOf(arrayCuvinte[2]), Boolean.valueOf(arrayCuvinte[3]));
                if (traineesGroup2.size() == 5) {
                    throw new MaximumNumberOfStudentsReached("Numarul studentilor din grupa 2 este mai mare decat 5");
                } else {
                    traineesGroup2.add(trainee);
                }
                text2 = bufferedReaderTrainees2.readLine();
            }
            System.out.println("Afisam studentii din grupa 2");
            for (Trainee trainee : traineesGroup2) {
                System.out.println(trainee);
            }


            //Ne ocupam de studentii din grupa 3
            Set<Trainee> traineesGroup3 = new HashSet<>();
            String text3 = bufferedReaderTrainees3.readLine();
            while (text3 != null && !text3.isEmpty()) {
                String[] arrayCuvinte = text3.split(";");
                Trainee trainee = new Trainee(arrayCuvinte[0], arrayCuvinte[1], Integer.valueOf(arrayCuvinte[2]), Boolean.valueOf(arrayCuvinte[3]));
                if (traineesGroup3.size() == 5) {
                    throw new MaximumNumberOfStudentsReached("Numarul studentilor din grupa 3 este mai mare decat 5");
                } else {
                    traineesGroup3.add(trainee);
                }
                text3 = bufferedReaderTrainees3.readLine();
            }
            System.out.println("Afisam studentii din grupa 3");
            for (Trainee trainee : traineesGroup3) {
                System.out.println(trainee);
            }




            //aici ne ocupam de grupe
            Set<Group> groups = new HashSet<>();
            String text4 = bufferedReaderGroups.readLine();
            while (text4 != null && !text4.isEmpty()) {
                String[] arrayCuvinte = text4.split(";");
                Trainer trainer = new Trainer(arrayCuvinte[1], arrayCuvinte[2], 30, true);
                Group group = new Group(arrayCuvinte[0], trainer);
                if (trainer.getName().equals("Alex")) {
                    group.setGroupTrainees(traineesGroup1);
                } else if (trainer.getName().equals("Ion")) {
                    group.setGroupTrainees(traineesGroup2);
                } else if (trainer.getName().equals("Popescu")) {
                    group.setGroupTrainees(traineesGroup3);
                } else {
                    System.out.println("Nu exista trainerul");
                }
                groups.add(group);

                text4 = bufferedReaderGroups.readLine();
            }
            System.out.println("Afisam grupele"); //trebuie sa vad de ce nu le afiseaza
            for (Group group : groups) {
                System.out.println("Afisam urmatoarea grupa " + group);
            }


            //folosim Singleton; am pregatit situatia, am incarcat datele
            SoftwareDevelopmentAcademy softwareDevelopmentAcademy = SoftwareDevelopmentAcademy.getInstance();
            softwareDevelopmentAcademy.setGroups(groups);

            //Aici rezolvam exercitiul: Afisam grupele care au numar maxim de studenti
            Set<Group> groupSet = softwareDevelopmentAcademy.getGroups();
            for (Group group : groupSet) {
                if (group.getGroupTrainees().size() == 5) {
                    System.out.println("Afisam grupa " + group);
                }
            }

            //Aici rezolvam exercitiul: Afisam din toate grupele studentii care au pana in 25 de ani
            Set<Group> groupSet1 = softwareDevelopmentAcademy.getGroups();
            for (Group group: groupSet1) {
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (Year.now().getValue() - trainee.getAge() < 25) {
                        System.out.println(trainee.toString());
                    }
                }
            }

            //Aici rezolvam exercitiul: Afisam toti studentii care mai au cunostinte de programare
            Set<Group> groupSet2 = softwareDevelopmentAcademy.getGroups();
            for (Group group: groupSet2) {
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (trainee.isKnowProgramming() == true) {
                        System.out.println(trainee);
                    }
                }
            }

            //Aici rezolvam exercitiul:Afisam grupa care are cei mai multi studenti care nu au cunostinte de programare
            


        } catch (MaximumNumberOfStudentsReached e) {
            System.out.println("A aparut exceptia " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Nu am gasit fisierul " + e.getMessage());
        } catch (IOException e) {
            System.out.println("A aparut o exceptie " + e.getMessage());
        }


    }

}
