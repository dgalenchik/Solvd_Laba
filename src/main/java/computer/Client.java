package computer;

import java.util.Objects;

public class Client {
    private String firstName;
    private String patronymicName;
    private String surname;

    public Client() {
    }


    public Client(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Client(String firstName, String patronymicName, String surname) {
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) && Objects.equals(patronymicName, client.patronymicName) && Objects.equals(surname, client.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, patronymicName, surname);
    }
}
