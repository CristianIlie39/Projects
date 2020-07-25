package entities;


import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Delete_Department_By_Number_Of_Employees", query = "delete Department where numberOfEmployees = :numberOfEmployees"),
        @NamedQuery(name = "Select_Department_By_Floor", query = "select department from Department department where floor = :floor")
})

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_department")
    private String nameOfDepartment;

    @Column(name = "floor")
    private int floor;

    @Column(name = "number_of_employees")
    private int numberOfEmployees;

    @Column(name = "name_of_department_head")
    private String nameOfDepartmentHead;

    public Department(String nameOfDepartment, int floor, int numberOfEmployees, String nameOfDepartmentHead) {
        this.nameOfDepartment = nameOfDepartment;
        this.floor = floor;
        this.numberOfEmployees = numberOfEmployees;
        this.nameOfDepartmentHead = nameOfDepartmentHead;
    }

    public Department() {

    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getNameOfDepartmentHead() {
        return nameOfDepartmentHead;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setNameOfDepartmentHead(String nameOfDepartmentHead) {
        this.nameOfDepartmentHead = nameOfDepartmentHead;
    }

    public String toString() {
        return this.nameOfDepartment + " " + this.floor + " " + this.numberOfEmployees + " " + this.nameOfDepartmentHead;
    }
}
