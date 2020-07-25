package entities; //clasele care sunt mapate cu tabele din baza de date se numesc Entitati

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Delete_Employee_By_Age", query = "delete Employee where age > :age"),
        @NamedQuery(name = "Update_Employee_By_Position", query = "update Employee set position = :position where age <= :age1 and age >= :age2"),
        @NamedQuery(name = "Select_Employee_By_Department", query = "select employee from Employee employee where employee.departmentName = :departmentName"),
        @NamedQuery(name = "Select_Employee_By_Name_And_Surname", query = "select employee from Employee employee where employee.name =: name and employee.surname = :surname")
})

@Entity  //facem clasa entitate
@Table(name = "employees")  //mapam clasa Employee cu tabelul employees din baza de date
public class Employee {

    @Id  //folosit pt coloana id din tabelul employees din baza de date, coloana cu rol de primary_key si care se
    //auto_incrementeaza
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //spunem Hibernate ca valorile din acest atribut vor fi
    //autogenerate de catre baza de date => nu mai preluam atributul id in constructorul clasei si nu-i facem metode
    //getter si setter
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "position")
    private String position;

    public Employee(String name, String surname, String address, int age, String departmentName, String position) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.departmentName = departmentName;
        this.position = position;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.address + " " + this.age + " " + this.departmentName + " " +
                this.position;
    }
}
