package parsers.models;

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
}
