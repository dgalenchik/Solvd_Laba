package computer;

import interfaces.IConnect;
import interfaces.IPlay;
import interfaces.IRecord;
import interfaces.IScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class Laptop extends Computer implements IScreenshot, IPlay, IRecord, IConnect {
    private float batteryCapacity;
    private float screenSize;
    private static final Logger LOGGER = LogManager.getLogger(Computer.class);


    public Laptop() {
    }

    public Laptop(String manufacture, String model, String design, String form, Memory memory,
                  GraphicCard graphicCard, AudioCard audioCard, Cpu cpu, float batteryCapacity, float screenSize) {
        super(manufacture, model, design, form, memory, graphicCard, audioCard, cpu);
        this.batteryCapacity = batteryCapacity;
        this.screenSize = screenSize;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    //Show information about main.java.computer.Laptop
    public float screenInfo() {
        return screenSize;
    }

    public abstract String batteryInfo();

    @Override
    public String power() {
        return ("Working via battery");
    }

    @Override
    public String computerInfo() {
        return ("main.java.computer.Computer: " +
                "Manufacture: " + getManufacture() + "; " + "\n" +
                "Model: " + getModel() + "; " + "\n" +
                "Design: " + getDesign() + "; " + "\n" +
                "Form: " + getForm() + "; " + "\n" +
                getMemory().toString() + "; " + "\n" +
                getGraphicCard().toString() + "; " + "\n" +
                getAudioCard().toString() + "; " + "\n" +
                getCpu().toString() + "; " + "\n" +
                "Battery capacity: " + getBatteryCapacity() + "w" + "; " + "\n" +
                "Screen size: " + getScreenSize());
    }

    public static <T> void showOrder(List<T> list) {
        for (T element : list) {
            LOGGER.info(element);
        }
    }

}








