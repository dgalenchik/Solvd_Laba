package computer;

import exceptions.InvalidConnectionException;
import exceptions.InvalidConnectionNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Macbook extends Laptop {
    private static final int QUANTITY = 0;
    public Authorization authorization;
    private static final Logger LOGGER = LogManager.getLogger(Macbook.class);

    public Macbook(String manufacture, String model, String design, String form, Memory memory, GraphicCard graphicCard, AudioCard audioCard, Cpu cpu, float batteryCapacity, float screenSize, Authorization authorization) {
        super(manufacture, model, design, form, memory, graphicCard, audioCard, cpu, batteryCapacity, screenSize);
        this.authorization = authorization;
    }

//    public Macbook(String manufacture, String model, String design, String form, Memory memory, GraphicCard graphicCard, AudioCard audioCard, Cpu cpu, float batteryCapacity, float screenSize) {
//        super(manufacture, model, design, form, memory, graphicCard, audioCard, cpu, batteryCapacity, screenSize);
//        try(Scanner in = new Scanner(System.in)){
//        authorization = new Authorization(Authorization.readUserName(in), Authorization.readPassword(in));
//        QUANTITY++;}
//    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Macbook macbook = (Macbook) o;
        if (macbook.getManufacture() != getManufacture()) return false;
        if (macbook.getAudioCard() != getAudioCard()) return false;
        if (macbook.getScreenSize() != getScreenSize()) return false;
        if (macbook.getBatteryCapacity() != getBatteryCapacity()) return false;
        if (macbook.getGraphicCard() != getGraphicCard()) return false;
        if (macbook.getCpu() != getCpu()) return false;
        if (macbook.getMemory() != getMemory()) return false;
        if (macbook.getDesign() != getDesign()) return false;
        return Objects.equals(getForm(), macbook.getForm());
    }

    @Override
    public int hashCode() {
        int result = getManufacture() == null ? 0 : getManufacture().hashCode();
        result = 29 * result * getAudioCard().hashCode();
        result = 29 * result * Objects.hashCode(getScreenSize());
        result = 29 * result * Objects.hashCode(getBatteryCapacity());
        result = 29 * result * getGraphicCard().hashCode();
        result = 29 * result * getCpu().hashCode();
        result = 29 * result * getMemory().hashCode();
        result = 29 * result * getDesign().hashCode();
        result = 29 * result * getForm().hashCode();
        return result;
    }

    @Override
    public String checkOsVersion() {
        return ("Mac OS is installed");
    }

    @Override
    public String batteryInfo() {
        return ("main.java.computer.Macbook Battery capacity: " + getBatteryCapacity() + " mah");
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
        try {
            if (str.equals("host")) {

                throw new InvalidConnectionException("Attempt to connect to host");
            }
            LOGGER.info("Your main.java.computer.Macbook connected to: " + str);
            LOGGER.debug("Logger connection");
        } catch (InvalidConnectionException exception) {
            try {
                throw new InvalidConnectionNameException("Incorrect address to connect", exception);
            } catch (InvalidConnectionNameException e) {
                LOGGER.info(e);
            }
            LOGGER.debug(exception);
        }
    }
}
