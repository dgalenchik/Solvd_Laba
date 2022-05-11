package service_station.models;

public class Compressor {
    private int id;
    private String manufacture;
    private int performance;

    public Compressor() {
    }

    public Compressor(String manufacture, int performance) {
        this.manufacture = manufacture;
        this.performance = performance;
    }

    public Compressor(int id, String manufacture, int performance) {
        this.id = id;
        this.manufacture = manufacture;
        this.performance = performance;
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

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Compressor{" +
                "id=" + id +
                ", manufacture='" + manufacture + '\'' +
                ", performance=" + performance +
                '}';
    }
}
