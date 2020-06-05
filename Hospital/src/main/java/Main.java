import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //Se se modeleze un spital
        //Dintr-un fisier se vor citi de pe fiecare rand numele, prenumele, sectia, si daca e de tura sau nu (boolean) pt un medic (ce inseamna sa nu fie nimeni de tura? cum se verifica?)
        //Se se separe medicii in 2 colectii: 1 - in fct de specializare (chirurgie, radiologie, ortopedie), 2 - daca sunt de tura sau nu (2 categorii)
        //Fiecare categorie din fiecare colectie sa fie scrisa intr-un fisier separat (5 fisiere)
        //Daca exista vreo categorie in fct de specializare care nu este de tura, sa se arunce o exceptie - NobodyOnShiftException
        //Dintr-un alt fisier se vor citi de pe fiecare rand numele, prenumele, varsta si specializarea pt care a venit la spital fiecare pacient
        //Sa se separe pacientii intr-o colectie in fct de specializarea pt care au venit
        //Daca sunt mai mult de 5 pacienti la o specializare, sa se arunce o exceptie - TooCrowdedException

        //Pt obiectele pacient si medic folosim mostenirea (care pe care mosteneste, care sunt chestiile comune)
        //Medicul va avea un comportament specific specializarii (chirurgul opereaza, radiologul face ecografie, ortopedul - ortopedie) -> comportamentele sunt date de interfete diferite
        //Sa se scrie teste unitare pt fiecare comportament (medicul opereaza o sa returneze un string -> nu prea avem ce verifica, dar pt exersare facem test)

        //Plan de executie
        //Avem nevoie de 10 fisiere
        //Avem nevoie de 2 colectii Map - prima in fct de specializare (vom avea 3 categorii: chirurg, radiolog, ortoped)
        // a doua - in fct de tura (vom avea 2 categorii (stringuri) -> adevarat, false)
        //Avem nevoie de 1 colectie Map pt pacienti cu 3 sectii/specializari: chirurgie, radiologie si ortopedie

        //Inventar
        //Creem o clasa abstracta Person care sa fie mostenita de Medic si Pacient; clasa va avea atribute: nume, prenume, sectia
        //Creem o clasa Doctor care mosteneste clasa Person - o sa aiba in plus daca e de tura sau nu
        //Creem o clasa Pacient care mosteneste clasa Person - o sa aiba in plus varsta
        //Comportamentele -> le punem in 3 interfete: Oprereaza, Radiologie, Ortopedie (le dam nume sugestive)
        //Exceptii -> creem 2 exceptii: prima - NobodyOnShiftException cand nu este de tura respectiva medicul, a doua - TooCrowdedException - cand sunt mai mult de 5 pacienti la o specializare


        try {
            String doctorsFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\DoctorsFile.txt";
            FileReader doctorsFileReader = new FileReader(doctorsFilePath);
            BufferedReader doctorsBufferedReader = new BufferedReader(doctorsFileReader);

            //creem 2 colectii Map pentru doctori
            Map<String, ArrayList<Doctor>> doctorsDepartmentMap = new HashMap<String, ArrayList<Doctor>>();
            Map<String, ArrayList<Doctor>> doctorsWorkPresenceMap = new HashMap<String, ArrayList<Doctor>>();

            //pregatim Map-urile dupa chei: specialitate si prezenta la serviciu
            doctorsDepartmentMap.put("chirurgie", new ArrayList<Doctor>());
            doctorsDepartmentMap.put("radiologie", new ArrayList<Doctor>());
            doctorsDepartmentMap.put("ortopedie", new ArrayList<Doctor>());

            doctorsWorkPresenceMap.put("prezent", new ArrayList<Doctor>());
            doctorsWorkPresenceMap.put("absent", new ArrayList<Doctor>());

            //aici citim prima linie din fisierul DoctorsFile
            String text = doctorsBufferedReader.readLine();

            //cu while urmeaza sa filtram Map-urile
            while (text != null) {
                //creeam un array de String-uri care desparte textul in cuvinte dupa ";"
                String[] arrayWords = text.split(";");

                //creeam obiectul doctor
                Doctor doctor = new Doctor(arrayWords[0], arrayWords[1], arrayWords[2], arrayWords[3]);

                //adaugam doctorii in colectii pe fiecare specializare in parte

                if (doctor.getDepartment().equals("chirurgie")) {
                    doctorsDepartmentMap.get("chirurgie").add(doctor);
                } else if (doctor.getDepartment().equals("radiologie")) {
                    doctorsDepartmentMap.get("radiologie").add(doctor);
                } else if (doctor.getDepartment().equals("ortopedie")) {
                    doctorsDepartmentMap.get("ortopedie").add(doctor);
                }

                if (doctor.getWorkPresence().equals("prezent")) {
                    doctorsWorkPresenceMap.get("prezent").add(doctor);
                } else if (doctor.getWorkPresence().equals("absent")) {
                    doctorsWorkPresenceMap.get("absent").add(doctor);
                }

                text = doctorsBufferedReader.readLine(); //am dat comanda sa se citeasca fiecare linie din text atat timp cat textul este diferit de null

            }

            //declaram calea catre fisierele de scris
            String surgeonDoctorsFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\SurgeonDoctorsFile.txt";
            String radiologistDoctorsFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\RadiologistDoctorsFile.txt";
            String orthopedicDoctorFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\OrthopedicDoctorFile.txt";
            String presentDoctorsFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\PresentDoctors.txt";
            String absentDoctorsFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\AbsentDoctors.txt";

            //importam fisierele de scris in program
            FileWriter surgeonDoctorsFileWriter = new FileWriter(surgeonDoctorsFilePath);
            FileWriter radiologistDoctorsfileWriter = new FileWriter(radiologistDoctorsFilePath);
            FileWriter orthopedicDoctorfileWriter = new FileWriter(orthopedicDoctorFilePath);
            FileWriter presentDoctorsFileWriter = new FileWriter(presentDoctorsFilePath);
            FileWriter absentDoctorsFileWriter = new FileWriter(absentDoctorsFilePath);

            //creem obiectele de citit
            BufferedWriter surgeonDoctorsBufferedWriter = new BufferedWriter(surgeonDoctorsFileWriter);
            BufferedWriter radiologistDoctorsBufferedWriter = new BufferedWriter(radiologistDoctorsfileWriter);
            BufferedWriter orthopedicDoctorBufferedWriter = new BufferedWriter(orthopedicDoctorfileWriter);
            BufferedWriter presentDoctorsBufferedWriter = new BufferedWriter(presentDoctorsFileWriter);
            BufferedWriter absentDoctorsBufferedWriter = new BufferedWriter(absentDoctorsFileWriter);

            //scriem in fisier doctorii de la specialitatea chirurgie
            ArrayList<Doctor> surgeonDoctor = doctorsDepartmentMap.get("chirurgie");
            for (Doctor doctor : surgeonDoctor) {
                surgeonDoctorsBufferedWriter.write(doctor.toString());
                surgeonDoctorsBufferedWriter.newLine();
                doctor.operates(); //aici am apelat metoda operates()

            }
            surgeonDoctorsBufferedWriter.flush();
            surgeonDoctorsBufferedWriter.close();
            System.out.println();

            //scriem in fisier doctorii de la specialitatea radiologie
            ArrayList<Doctor> radiologistDoctor = doctorsDepartmentMap.get("radiologie");
            for (Doctor doctor : radiologistDoctor) {
                radiologistDoctorsBufferedWriter.write(doctor.toString());
                radiologistDoctorsBufferedWriter.newLine();
                doctor.ultrasound(); // aici am apelat metoda ultrasound()
            }
            radiologistDoctorsBufferedWriter.flush();
            radiologistDoctorsBufferedWriter.close();
            System.out.println();

            //scriem in fisier doctorii de la specialitatea ortopedie
            ArrayList<Doctor> orthopedicDoctor = doctorsDepartmentMap.get("ortopedie");
            for (Doctor doctor : orthopedicDoctor) {
                orthopedicDoctorBufferedWriter.write(doctor.toString());
                orthopedicDoctorBufferedWriter.newLine();
                doctor.recovery(); //aici am apelat metoda   recovery()
            }
            orthopedicDoctorBufferedWriter.flush();
            orthopedicDoctorBufferedWriter.close();

            //scriem in fisier doctorii care sunt de tura/prezenti
            ArrayList<Doctor> presentDoctor = doctorsWorkPresenceMap.get("prezent");
            for (Doctor doctor : presentDoctor) {
                presentDoctorsBufferedWriter.write(doctor.toString());
                presentDoctorsBufferedWriter.newLine();
            }
            presentDoctorsBufferedWriter.flush();
            presentDoctorsBufferedWriter.close();

            //scriem in fisier doctorii care nu sunt de tura/absenti
            ArrayList<Doctor> absentDoctor = doctorsWorkPresenceMap.get("absent");
            for (Doctor doctor : absentDoctor) {
                absentDoctorsBufferedWriter.write(doctor.toString());
                absentDoctorsBufferedWriter.newLine();
            }
            absentDoctorsBufferedWriter.flush();
            absentDoctorsBufferedWriter.close();


            try {
                if (absentDoctor.contains(surgeonDoctor.get(0)) && absentDoctor.contains(surgeonDoctor.get(1)) && absentDoctor.contains(surgeonDoctor.get(2)) && absentDoctor.contains(surgeonDoctor.get(3))) {
                    throw new NobodyOnShiftException("Nobody on shift");
                } else if (absentDoctor.contains(radiologistDoctor.get(0)) && absentDoctor.contains(radiologistDoctor.get(1)) && absentDoctor.contains(radiologistDoctor.get(2))) {
                    throw new NobodyOnShiftException("Nobody on shift");
                } else if (absentDoctor.contains(orthopedicDoctor.get(0)) & absentDoctor.contains(orthopedicDoctor.get(1))) {
                    throw new NobodyOnShiftException("Nobody on shift");
                }

            } catch (NobodyOnShiftException e) {
                System.out.println("An exception appeared: " + e.getMessage());
            }
            System.out.println();

            //in continuare ne ocupam de pacienti
            //declaram calea catre fisierul de pacienti de citit; creem fileReader si bufferReader
            String patientsFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\PatientsFile.txt";
            FileReader patientsFileReader = new FileReader(patientsFilePath);
            BufferedReader patientsBufferedReader = new BufferedReader(patientsFileReader);

            //creeam o colectie Map pentru pacienti
            Map<String, ArrayList<Patient>> patientsMap = new HashMap<String, ArrayList<Patient>>();

            //pregatim colectia Map pe categorii dupa sectia unde sunt internati pacientii
            patientsMap.put("chirurgie", new ArrayList<Patient>());
            patientsMap.put("radiologie", new ArrayList<Patient>());
            patientsMap.put("ortopedie", new ArrayList<Patient>());

            //aici citim prima linie din fisierul PatientsFile
            String text1 = patientsBufferedReader.readLine();

            //cu while urmeaza sa filtram Map-ul
            while (text1 != null) {
                String[] arrayWords = text1.split(";");
                Patient patient = new Patient(arrayWords[0], arrayWords[1], arrayWords[2], arrayWords[3]);

                if (patient.getDepartment().equals("chirurgie")) {
                    patientsMap.get("chirurgie").add(patient);
                } else if (patient.getDepartment().equals("radiologie")) {
                    patientsMap.get("radiologie").add(patient);
                } else if (patient.getDepartment().equals("ortopedie")) {
                    patientsMap.get("ortopedie").add(patient);
                }

                text1 = patientsBufferedReader.readLine();
            }

            //declaram caile catre fisierele de scris
            String surgeryFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\SurgeryDepartment.txt";
            String radiologyFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\RadiologyDepartment.txt";
            String orthopedicFilePath = "D:\\cursuri Alex\\31.05.2020\\Hospital\\HospitalFiles\\OrthopedicsDepartment.txt";

            //creem fileWriter si bufferWriter pt fiecare fisier de scris
            FileWriter surgeryFileWriter = new FileWriter(surgeryFilePath);
            FileWriter radiologyFileWriter = new FileWriter(radiologyFilePath);
            FileWriter orthopedicFileWriter = new FileWriter(orthopedicFilePath);

            BufferedWriter surgeryBufferedWriter = new BufferedWriter(surgeryFileWriter);
            BufferedWriter radiologyBufferedWriter = new BufferedWriter(radiologyFileWriter);
            BufferedWriter orthopedicBufferedWriter = new BufferedWriter(orthopedicFileWriter);

            //scriem pacientii in fisiere pe sectii
            ArrayList<Patient> radiologyPatient = patientsMap.get("radiologie");
            int radiologyPatientsNumber = 0;
            for (Patient patient : radiologyPatient) {
                radiologyBufferedWriter.write(patient.toString());
                radiologyPatientsNumber++;
                radiologyBufferedWriter.newLine();
            }
            radiologyBufferedWriter.flush();
            radiologyBufferedWriter.close();
            System.out.println("The number of patients in radiology department is: " + radiologyPatientsNumber);
            if (radiologyPatientsNumber > 5) {
                throw new TooCrowdedException("The radiology department is too crowded!");
            }

            ArrayList<Patient> orthopedicPatient = patientsMap.get("ortopedie");
            int orthopedicPatientsNumber = 0;
            for (Patient patient : orthopedicPatient) {
                orthopedicBufferedWriter.write(patient.toString());
                orthopedicPatientsNumber++;
                orthopedicBufferedWriter.newLine();
            }
            orthopedicBufferedWriter.flush();
            orthopedicBufferedWriter.close();
            System.out.println("The number of patients in orthopedics departement is: " + orthopedicPatientsNumber);
            if (orthopedicPatientsNumber > 5) {
                throw new TooCrowdedException("The orthopedics department is too crowded!");
            }

            ArrayList<Patient> surgeryPatients = patientsMap.get("chirurgie");
            int surgeryPatientsNumber = 0;
            for (Patient patient : surgeryPatients) {
                surgeryBufferedWriter.write(patient.toString());
                surgeryPatientsNumber++;
                surgeryBufferedWriter.newLine();
            }
            surgeryBufferedWriter.flush();
            surgeryBufferedWriter.close();
            System.out.println("The number of patients in surgery department is: : " + surgeryPatientsNumber);
            if (surgeryPatientsNumber > 5) {
                throw new TooCrowdedException("The surgery department is too crowded!");
            }


        } catch (TooCrowdedException e) {
            System.out.println("An exception appeared: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An exception appeared: " + e.getMessage());
        }

    }


}
