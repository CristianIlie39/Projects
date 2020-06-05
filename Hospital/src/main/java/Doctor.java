public class Doctor extends Person implements Surgery, Radiology, Orthopedics {

    private String workPresence;

    public Doctor(String surname, String name, String department, String workPresence) {
        this.surname = surname;
        this.name = name;
        this.department = department;
        this.workPresence = workPresence;
    }

    public String getWorkPresence() {
        return workPresence;
    }

    public String toString() {
        return this.surname + ";" + this.name + ";" + this.department + ";" + this.workPresence;
    }

    public void operates() {
        if (this.department.equals("chirurgie") && this.workPresence.equals("prezent")) {
            System.out.println("The surgeon operates the patients");
        } else {
            System.out.println("The surgeon is free from work");
        }
    }

    public void ultrasound() {
        if (this.department.equals("radiologie") && this.workPresence.equals("prezent")) {
            System.out.println("The radiologist does ultrasounds on the patients");
        } else {
            System.out.println("The radiologist is free from work");
        }
    }

    public void recovery() {
        if (this.department.equals("ortopedie") && this.workPresence.equals("prezent")) {
            System.out.println("The orthopedic recovers the patients");
        } else {
            System.out.println("The orthopedic is free from work");
        }
    }


}
