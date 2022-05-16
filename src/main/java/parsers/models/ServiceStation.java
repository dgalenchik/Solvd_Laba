package parsers.models;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "service_station")
@XmlType(propOrder = {"id", "name", "address", "workers", "equipment"})
public class ServiceStation {
    private int id;
    private String name;
    private String address;
    private List<Worker> workers = new ArrayList<>();
    private List<Equipment> equipment = new ArrayList<>();

    @Override
    public String toString() {
        return "ServiceStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", workers=" + workers +
                ", equipment=" + equipment +
                '}';
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    @XmlElement
    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    @XmlElement
    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceStation)) return false;
        ServiceStation that = (ServiceStation) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(workers, that.workers) && Objects.equals(equipment, that.equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, workers, equipment);
    }
}
