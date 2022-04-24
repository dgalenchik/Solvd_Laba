package enums;

public enum Manufactures {
    APPLE("Apple"),
    SAMSUNG("Samsung"),
    HP("Hp"), ASUS("Asus"),
    ACER("Acer"),
    INTEL("Intel"),
    DELL("Dell"),
    LENOVO("Lenovo"),
    ALIENWARE("Alienware"),
    MSI("Msi"),
    GIGABYTE("Gigabyte"),
    HYPERPC("Hyperpc");
    private final String value;

    Manufactures(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
