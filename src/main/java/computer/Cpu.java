package computer;

public class Cpu {
    private String cpuManufacture;
    private double cpuFrequency;

    public Cpu() {
    }

    public Cpu(String cpuManufacture, double cpuFrequency) {
        this.cpuManufacture = cpuManufacture;
        this.cpuFrequency = cpuFrequency;
    }

    public String getCpuManufacture() {
        return cpuManufacture;
    }

    public void setCpuManufacture(String cpuManufacture) {
        this.cpuManufacture = cpuManufacture;
    }

    public double getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(double cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }

    //Show information about main.java.computer.Cpu

    @Override
    public String toString() {
        return ("Cpu: " + "Cpu manufacture: " +
                getCpuManufacture() + "; " +
                "Cpu frequency: " +
                getCpuFrequency());
    }

}
