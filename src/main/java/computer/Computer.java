package computer;

import exceptions.EmptyLetterException;
import exceptions.LogsQuantityException;
import interfaces.ISend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public abstract class Computer implements ISend {
    private String manufacture;
    private String model;
    private String design;
    private String form;
    private Memory memory;
    private GraphicCard graphicCard;
    private AudioCard audioCard;
    private Cpu cpu;
    private static final Logger LOGGER = LogManager.getLogger(Computer.class);

    public Computer() {
    }

    public Computer(String manufacture, String model, String design, String form, Memory memory, GraphicCard graphicCard, AudioCard audioCard, Cpu cpu) {
        this.manufacture = manufacture;
        this.model = model;
        this.design = design;
        this.form = form;
        this.memory = memory;
        this.graphicCard = graphicCard;
        this.audioCard = audioCard;
        this.cpu = cpu;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }

    public AudioCard getAudioCard() {
        return audioCard;
    }

    public void setAudioCard(AudioCard audioCard) {
        this.audioCard = audioCard;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    //Show information about main.java.computer.Computer
    public abstract String computerInfo();

    public String turnOn() {
        return ("computer.Computer is turned on");
    }

    public abstract String checkOsVersion();

    public String power() {
        return ("Working via 220v");
    }

    //Add exception if the computer.Letter is empty
    @Override
    public void send(Letter letter, Client firstClient, Client secondClient) {
        try {
            LOGGER.info("Dear, " + firstClient.getFirstName() + " " + secondClient.getSurname() + ". The following configuration has sent from: " + firstClient.getFirstName() + " " + secondClient.getSurname());
            LOGGER.info(letter.getLetterText());
            if (letter.getLetterText().isEmpty()) throw new EmptyLetterException();
        } catch (EmptyLetterException except) {
            LOGGER.info("Handling exception");
            LOGGER.info("The computer.Letter is empty", except);
        }
    }

    //Handle exception with method signature
    public static void countLogs() throws LogsQuantityException {
        String src = "logs/";
        File dir = new File(src);
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        if (lst.size() > 20) throw new LogsQuantityException("Logs Quantity is more than 20");
        LOGGER.info("There are: " + lst.size() + " logs");
        for (File i : lst) {
            LOGGER.info(i);
        }
    }

    //Handle exception with try-catch
    public static void removeLogs() {
        try {
            File dir = new File("logs/");
            File[] arrFiles = dir.listFiles();
            List<File> lst = Arrays.asList(arrFiles);
            if (lst.size() > 2) {
                for (File myFile : new File("logs/").listFiles())
                    if (myFile.isFile()) myFile.delete();
                LOGGER.info("Logs were removed");
            } else throw new LogsQuantityException("Not enough logs");
        } catch (LogsQuantityException e) {
            LOGGER.error(e);
        }
    }

}

