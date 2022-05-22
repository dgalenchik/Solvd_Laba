package parsers.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import parsers.jaxb.DateConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@XmlType(propOrder = {"name", "surname", "birthday"})
public class Engeneer {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
    private String name;
    private String surname;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date birthday;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    @XmlJavaTypeAdapter(DateConverter.class)
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Engeneer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + formatter.format(birthday) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engeneer)) return false;
        Engeneer engeneer = (Engeneer) o;
        return Objects.equals(name, engeneer.name) && Objects.equals(surname, engeneer.surname) && Objects.equals(birthday, engeneer.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday);
    }
}
