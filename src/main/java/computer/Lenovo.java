package computer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Lenovo extends Laptop {
    private static final Logger LOGGER = LogManager.getLogger(Computer.class);
    private int productNumber;

    public Lenovo() {
    }

    public Lenovo(String manufacture, String model, String design, String form, Memory memory, GraphicCard graphicCard, AudioCard audioCard, Cpu cpu, float batteryCapacity, float screenSize, int productNumber) {
        super(manufacture, model, design, form, memory, graphicCard, audioCard, cpu, batteryCapacity, screenSize);
        this.productNumber = productNumber;
    }

    @Override
    public String checkOsVersion() {
        return ("Windows is installed");
    }

    //Add exception
    @Override
    public String batteryInfo() {
        try {
            throw new Exception();
        } catch (Exception exception) {
            LOGGER.info("Battery information request");
        } finally {
            return ("main.java.computer.Lenovo Battery capacity: " + getBatteryCapacity() + " mah");
        }
    }


    @Override
    public String toString() {
        return turnOn() + "\n" + batteryInfo() + "\n" + checkOsVersion();
    }

    @Override
    public void makeScreenshot() {
        LOGGER.info("Making screenshot with resolution " + (int) getScreenSize() * 110 + " x " + (int) getScreenSize() * 100);
    }

    @Override
    public void playSound() {
        LOGGER.info("Playing sound via: " + getAudioCard().toString());
    }

    @Override
    public void recordSound() {
        LOGGER.info("Recording audio using: " + getAudioCard().getAudioChipManufacture());
    }

    @Override
    public void connectTo(String str) {
        LOGGER.info("Your main.java.computer.Lenovo connected to: " + str);
    }

    public static Map createLenovoOrder(int Quantity, List ProductNumber) {
        Map<Integer, Lenovo> lenovoOrder = new HashMap<>();
        for (int i = 0; i < Quantity; i++) {
            lenovoOrder.put((Integer) ProductNumber.get(i), new Lenovo());
        }
        return lenovoOrder;
    }
}
