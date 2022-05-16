package parsers.models;

import java.util.Objects;

public class Cutter {
    private String manufacture;
    private int steelHardness;

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getSteelHardness() {
        return steelHardness;
    }

    public void setSteelHardness(int steelHardness) {
        this.steelHardness = steelHardness;
    }

    @Override
    public String toString() {
        return "Cutter{" +
                "manufacture='" + manufacture + '\'' +
                ", steelHardness=" + steelHardness +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cutter)) return false;
        Cutter cutter = (Cutter) o;
        return steelHardness == cutter.steelHardness && Objects.equals(manufacture, cutter.manufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacture, steelHardness);
    }
}
