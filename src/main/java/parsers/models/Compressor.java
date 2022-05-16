package parsers.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compressor)) return false;
        Compressor that = (Compressor) o;
        return performance == that.performance && year == that.year && Objects.equals(manufacture, that.manufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacture, performance, year);
    }
}
