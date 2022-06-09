package serviceStation.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car implements Listener {
    private static final Logger LOGGER = LogManager.getLogger(Car.class);
    private int id;
    private String manufacture;
    private int year;

    public Car() {
    }

    public Car(String manufacture, int year) {
        this.manufacture = manufacture;
        this.year = year;
    }

    public Car(int id, String manufacture, int year) {
        this.id = id;
        this.manufacture = manufacture;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacture='" + manufacture + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public void notifyListener() {
        LOGGER.info("The order with car: " + this + "\n" + "has changed the price");
    }
}
