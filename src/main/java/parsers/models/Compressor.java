package parsers.models;

public class Compressor {
    private String manufacture;
    private int performance;
    private int year;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Compressor{" +
                "manufacture='" + manufacture + '\'' +
                ", performance=" + performance +
                ", year=" + year +
                '}';
    }
}
