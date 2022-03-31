package computer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hp extends Laptop {
    private static final Logger LOGGER = LogManager.getLogger(Computer.class);

    public Hp() {
    }

    public Hp(String manufacture, String model, String design, String form, Memory memory, GraphicCard graphicCard, AudioCard audioCard, Cpu cpu, float batteryCapacity, float screenSize) {
        super(manufacture, model, design, form, memory, graphicCard, audioCard, cpu, batteryCapacity, screenSize);
    }


    @Override
    public String checkOsVersion() {
        return ("Linux is installed");
    }

    @Override
    public String batteryInfo() {
        return ("main.java.computer.Hp Battery capacity: " + getBatteryCapacity() + " mah");
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
        LOGGER.info("Your main.java.computer.Hp connected to: " + str);
    }
}
