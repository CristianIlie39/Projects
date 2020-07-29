import persistence.dao.GroupDAO;
import persistence.dao.StudentDAO;
import persistence.dao.TeacherDAO;
import persistence.entities.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        GroupDAO groupDAO = new GroupDAO();

        //inseram 3 studenti intr-o grupa (aceeasi grupa) din baza de date school
        //inseram studentul 1 in grupa 12A din baza de date school
        Group studentGroup1 = new Group("12A");
        Address studentAddress1 = new Address("Iasi", "strada Lapusneanu");
        Identifier studentIdentifier1 = new Identifier(23);
        Student student1 = new Student("Niculescu", "Viorel", 1975, "matematica",
                studentAddress1, studentIdentifier1, studentGroup1);
        studentDAO.insert(student1);

        //inseram studentul 2 in grupa 12A din baza de date school
        Address studentAddress2 = new Address("Galati", "bulevardul George Cosbuc");
        Identifier studentIdentifier2 = new Identifier(25);
        Student student2 = new Student("Ionescu", "Bogdan", 1995, "fizica",
                studentAddress2, studentIdentifier2, studentGroup1);
        studentDAO.insert(student2);

        //inseram studentul 3 in grupa 12A din baza de date school
        Address studentAddress3 = new Address("Braila", "Calea Calarasilor");
        Identifier studentIdentifier3 = new Identifier(27);
        Student student3 = new Student("Daminescu", "Daniel", 1979, "informatica",
                studentAddress3, studentIdentifier3, studentGroup1);
        studentDAO.insert(student3);

        //inseram 3 profesori in baza de date school
        //inseram profesorul 1 in baza de date school
        Address teacherAddress1 = new Address("Iasi", "strada Nicolae Grigorescu");
        Identifier teacherIdentifier1 = new Identifier(3);
        Teacher teacher1 = new Teacher("Matei", "Alexandru", 32, "informatica", true,
                "diriginte", teacherAddress1, teacherIdentifier1);
        teacherDAO.insert(teacher1);

        //inseram profesorul 2 in baza de date school
        Address teacherAddress2 = new Address("Bucuresti", "bulevardul Gheorghe Magheru");
        Identifier teacherIdentifier2 = new Identifier(7);
        Teacher teacher2 = new Teacher("Teodorescu", "Dumitru", 52, "fizica", false,
                "profesor", teacherAddress2, teacherIdentifier2);
        teacherDAO.insert(teacher2);

        //inseram profesorul 3 in baza de date school
        Address teacherAddress3 = new Address("Cluj-Napoca", "strada Regele Ferdinand");
        Identifier teacherIdentifier3 = new Identifier(9);
        Teacher teacher3 = new Teacher("Andreescu", "Paul", 48, "matematica", true,
                "diriginte", teacherAddress3, teacherIdentifier3);
        teacherDAO.insert(teacher3);

        //cautam un student dupa nume
        String studentName = "Daminescu";
        List<Student> studentList1 = studentDAO.findByName(studentName);
        System.out.println("Afisam studentul cu numele Daminescu");
        for (Student student : studentList1) {
            System.out.println(student);
        }

        //cautam un student dupa anul nasterii
        int studentYearOfBirth = 1995;
        List<Student> studentList2 = studentDAO.findByYear(studentYearOfBirth);
        System.out.println("Afisam studentul nascut in anul 1995");
        for (Student student : studentList2) {
            System.out.println(student);
        }

        //stergem un student dupa nume
        String studentName2 = "Niculescu";
        studentDAO.deleteByName(studentName2);

        //stergem un student dupa anul nasterii
        int StudentByYearOfBirth = 1995;
        studentDAO.deleteByYear(StudentByYearOfBirth);

        //stergem un profesor dupa nume
        String teacherName = "Teodorescu";
        teacherDAO.deleteByName(teacherName);

        //stergem un profesor dupa varsta
        int teacherAge = 48;
        teacherDAO.deleteByAge(teacherAge);


        //se adauga o grupa noua cu o lista noua de studenti

        Address studentAddress4 = new Address("Iasi", "str. Sararie");
        Identifier studentIdentifier4 = new Identifier(29);
        Student student4 = new Student("Paraschiv", "Marius", 1985, "geografie",
                studentAddress4, studentIdentifier4);

        Address studentAddress5 = new Address("Galati", "str. Brailei");
        Identifier studentIdentifier5 = new Identifier(31);
        Student student5 = new Student("Dumitrescu", "Aurel", 1977, "economie",
                studentAddress5, studentIdentifier5);

        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student4);
        studentSet.add(student5);
        Group group2 = new Group("12B", studentSet);
        groupDAO.insert(group2);

        //se adauga un student nou intr-o grupa deja existenta
        Address studentAddress6 = new Address("Braila", "bulevardul Dorobantilor");
        Identifier studentIdentifier6 = new Identifier(33);
        Student student6 = new Student("Constantinescu", "Tudor", 2000, "sport",
                studentAddress6, studentIdentifier6);
        String groupName = "12B";
        List<Group> groupList = groupDAO.findByName(groupName);
        student6.setGroup(groupList.get(0));
        studentDAO.insert(student6);

    }

}
