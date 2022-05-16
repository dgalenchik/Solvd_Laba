package parsers.models;

import java.util.ArrayList;
import java.util.List;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

}
