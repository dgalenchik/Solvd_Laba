package computer;

public class Memory {
    private String manufacture;
    private int capacity;
    private String memoryType;

    public Memory() {
    }

    public Memory(String manufacture, int capacity, String memoryType) {
        this.manufacture = manufacture;
        this.capacity = capacity;
        this.memoryType = memoryType;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }


    @Override
    public String toString() {
        return ("Memory: " +
                "Memory manufacture: " + getManufacture() + "; " +
                "Capacity: " + getCapacity() + "; " +
                "Memory Type: " + getMemoryType());
    }

}
