package business.dto;

public class AuthorDTO {

    public String surname;
    public String firstName;

    public AuthorDTO(String surname, String firstName) {
        this.surname = surname;
        this.firstName = firstName;
    }

    public AuthorDTO() {

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
