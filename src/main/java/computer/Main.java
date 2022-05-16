package computer;

import enums.ComputerCharacteristics;
import enums.MainCharacteristics;
import enums.Manufactures;
import exceptions.LogsQuantityException;
import interfaces.functional.*;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parsers.dom.DomParser;
import parsers.jaxb.JaxbRunner;
import parsers.models.Equipment;
import parsers.models.ServiceStation;
import service_station.dao.ICarDAO;
import service_station.dao.IUserDAO;
import service_station.dao.jdbcMySQLImpl.CarDAO;
import service_station.dao.jdbcMySQLImpl.UserDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    //Creating Instances
    AudioCard audioCard = new AudioCard("Beatbox", "TSMC");
    Cpu cpu = new Cpu("AMD", 2.222d);
    GraphicCard graphicCard = new GraphicCard("Nvidea", 2048, 1396);
    Memory memory = new Memory("Killsfire", 4096, "LLC");
    Client firstClient = new Client("Tom", "Vachovsky");
    Client secondClient = new Client("John", "Michailovich", "Koltyn");

    Macbook macbook = new Macbook("IBM", "JS412", "modern", "macbook",
            memory, graphicCard, audioCard, cpu, 2200f, 13.1f, new Authorization("1", "1"));
    Hp hp = new Hp("main.java.computer.Hp", "4530s", "modern", "laptop",
            memory, graphicCard, audioCard, cpu, 4800f, 15.3f);
    Lenovo lenovo = new Lenovo("main.java.computer.Lenovo", "k456", "modern", "laptop",
            memory, graphicCard, audioCard, cpu, 6800f, 14.3f, 58887);
    Letter letter = new Letter(macbook.computerInfo());

    private void runPreviousLessons() {
        //Send initial configuration
        LOGGER.info("Enter username and password for Macbook");
        letter.setLetterText("");
        macbook.send(letter, firstClient, secondClient);
        letter.setLetterText(macbook.computerInfo());
        macbook.send(letter, firstClient, secondClient);
        //Change configuration of main.java.computer.Computer
        macbook.setManufacture("Macbook");
        macbook.setModel("KRT45967");
        cpu.setCpuManufacture("Intel");
        memory.setCapacity(1024);
        audioCard.setManufacture("Alien Heath");
        //Change text of Letter
        letter.setLetterText(macbook.computerInfo());
        //Send return main.java.computer.Letter with necessary configuration
        macbook.send(letter, secondClient, firstClient);
        //Run Macbook methods
        LOGGER.info(macbook.toString());
        //Run Hp methods
        LOGGER.info(hp.toString());
        //Run Lenovo methods
        LOGGER.info(lenovo.toString());

        //Run methods from Interfaces
        macbook.makeScreenshot();
        hp.makeScreenshot();
        lenovo.makeScreenshot();
        macbook.playSound();
        hp.playSound();
        lenovo.playSound();
        macbook.recordSound();
        hp.recordSound();
        lenovo.recordSound();
        //Handling Exception with try-with resources
        try (Scanner input = new Scanner(System.in)) {
            LOGGER.info("Connect your devices? Y/N ");
            if (input.next().equals("Y")) {
                LOGGER.info("Enter the address to connect Macbook: ");
                macbook.connectTo(input.next());
                LOGGER.info("Enter the address to connect Hp: ");
                hp.connectTo(input.next());
                LOGGER.info("Enter the address to connect Lenovo: ");
                lenovo.connectTo(input.next());

            }
            LOGGER.info("-------------" + "\n" + "Root authorization: ");
            //Run root authorization with static fields
            Authorization.rootAuthorize(Authorization.readUserName(input), Authorization.readPassword(input));
            //Run authorization for Macbook
            LOGGER.info("-------------" + "\n" + "Authorization for Macbook: ");
            macbook.authorization.authorize(Authorization.readUserName(input), Authorization.readPassword(input));
        }
    }

    private void runLesson7() {
        //HomeTask 6
        LinkedList<Laptop> order = new LinkedList<>();
        order.add(macbook);
        order.add(hp);
        order.add(lenovo);
        Laptop.showOrder(order);

        Map<String, Client> clients = new HashMap();
        clients.put("1", firstClient);
        clients.put("2", secondClient);
        LOGGER.info(clients.get("2").toString());
        try {
            Computer.countLogs();
        } catch (LogsQuantityException e) {
            LOGGER.info(e);
        }

        Computer.removeLogs();
        Set<Client> uniqueClients = new HashSet();
        for (Map.Entry<String, Client> i : clients.entrySet()) {
            if (!uniqueClients.contains(i)) {
                uniqueClients.add(i.getValue());
            }
        }
        uniqueClients.stream().forEach(LOGGER::info);
        LOGGER.info(Lenovo.createLenovoOrder(5, ProductNumber.generateNumbers(5)).size());
        linkedList.LinkedList<String> linkedList = new linkedList.LinkedList<String>();
        linkedList.addLast("B");
        linkedList.addLast("C");
        linkedList.addLast("D");
        linkedList.addLast("E");
        LOGGER.info("LL: " + linkedList);
        linkedList.addFirst("A");
        LOGGER.info("LL: " + linkedList);
        LOGGER.info("Index of E " + linkedList.get("E"));
        LOGGER.info("Index of Z " + linkedList.get("Z"));
        linkedList.remove("C");
        LOGGER.info("LL: " + linkedList);
    }

    private static void countWords() {
        try {
            String s = StringUtils.lowerCase(FileUtils.readFileToString(new File("src/main/resources/text.txt"), StandardCharsets.UTF_8))
                    .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "");
            String[] arr = s.split(" ");
            Set<String> set = new HashSet(List.of(arr));
            List<String> lst = set.stream()
                    .map(x -> x + " " + StringUtils.countMatches(s, x))
                    .collect(Collectors.toList());
            FileUtils.writeLines(new File("src/main/resources/count.txt"), lst);
            LOGGER.info("The file 'count.txt' was created");
        } catch (IOException e) {
            LOGGER.info(e);
        }

    }

    private void runlambdaEnumExpressions() {
        Predicate<Computer> isMacbook = x -> x.equals(macbook);
        LOGGER.info(isMacbook.test(macbook));
        LOGGER.info(isMacbook.test(hp));
        MainCharacteristics r = MainCharacteristics.CPU;
        ComputerCharacteristics c = ComputerCharacteristics.MEMORY;
        LOGGER.info(r.getFrequency() + "\n" + c.getManufactures() +
                "\n" + c.getFrequency() + "\n" + Manufactures.GIGABYTE.getValue());
        ICountAverageFrequency avg = (firstDevice, secondDevice) -> (firstDevice + secondDevice) / 2;
        LOGGER.info(avg.count(cpu.getCpuFrequency(), cpu.getCpuFrequency()));
        Consumer<Macbook> sell = x -> LOGGER.info("Your " + x.getManufacture() + " was sold");
        sell.accept(macbook);
        IConvertDoubleToInt ic = value -> (int) value;
        LOGGER.info(ic.convert(cpu.getCpuFrequency()));
        IRename ren = value -> StringUtils.reverse(value);
        IAddTime a = () -> IAddTime.FORMATTER.format(Calendar.getInstance().getTime());
        LOGGER.info(ren.rename(firstClient.getFirstName()) + " " + a.addTime());
        IConvertMah conv = value -> String.valueOf(value / 200);
        LOGGER.info(conv.convert(macbook.getBatteryCapacity()));
    }

    private void useReflectionAPI() {
        Field[] fields = Memory.class.getDeclaredFields();
        Arrays.stream(fields).forEach(LOGGER::info);
        Constructor<?>[] constructors = Memory.class.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(LOGGER::info);
        Method[] methods = Memory.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(LOGGER::info);
        Memory mem = null;
        try {
            mem = (Memory) constructors[1].newInstance("arg1", 25, "arg2");
        } catch (InstantiationException e) {
            LOGGER.info(e);
        } catch (IllegalAccessException e) {
            LOGGER.info(e);
        } catch (InvocationTargetException e) {
            LOGGER.info(e);
        }
        Field fieldFirst = null;
        try {
            fieldFirst = mem.getClass().getDeclaredField("capacity");
        } catch (NoSuchFieldException e) {
            LOGGER.info(e);
        }
        fieldFirst.setAccessible(true);
        try {
            fieldFirst.set(mem, 2555);
        } catch (IllegalAccessException e) {
            LOGGER.info(e);
        }
        Method m = null;
        try {

            m = mem.getClass().getDeclaredMethod("get" + StringUtils.capitalize(fields[0].getName()));
        } catch (NoSuchMethodException e) {
            LOGGER.info(e);
        }
        try {
            LOGGER.info(m.invoke(mem).toString());
        } catch (IllegalAccessException e) {
            LOGGER.info(e);
        } catch (InvocationTargetException e) {
            LOGGER.info(e);
        }
        LOGGER.info(mem.getCapacity());
    }

    private void runDeadLock() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                LOGGER.info(Thread.currentThread().getName() + " Handle lock1");
                synchronized (lock2) {
                    LOGGER.info(Thread.currentThread().getName() + " Handle lock2");
                }
            }
        }, "Thread1");
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                LOGGER.info(Thread.currentThread().getName() + " Handle lock2");
                synchronized (lock1) {
                    LOGGER.info(Thread.currentThread().getName() + " Handle lock1");
                }
            }
        }, "Thread2");
        thread1.start();
        thread2.start();
    }

    public void runPool() {
        ICarDAO carDAO = new CarDAO();
        IUserDAO userDAO = new UserDAO();
        Thread thread1 = new Thread(() -> {
            LOGGER.info(carDAO.getEntityById(2));
            LOGGER.info(carDAO.getEntityById(1));
            LOGGER.info(carDAO.getEntityById(3));
        });
        Thread thread2 = new Thread(() -> {
            LOGGER.info(userDAO.getEntityById(1));
            LOGGER.info(userDAO.getEntityById(3));
            LOGGER.info(userDAO.getEntityById(50));
        });
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.runPreviousLessons();
//        main.runLesson7();
//        countWords();
//        main.runlambdaEnumExpressions();
//        main.useReflectionAPI()
//          main.runDeadLock();
//       IUserDAO u = new UserDAO();
//        User u1 = new User("Ivanov", "Ivan", "Ivann@mail.ru");
//        LOGGER.info(u.getEntityById(2));
//        u.saveEntity(u1);
//        u.generateUsers("Boris", "Moiseev", "bor@test", 10);
//        u1.setId(15);
//        LOGGER.info(u1.getId() + u1.getName() + u1.getSurname() + u1.getEmail());
//        u.updateEntity(u1);
//        u.removeEntity(u1);
//        main.runPool();
        DomParser domParser = new DomParser();
        try {
            domParser.parse();
        } catch (Exception e) {
            LOGGER.info(e);
        }
        ServiceStation ss = domParser.takeServiceStation();
JaxbRunner.marshal(ss);
        ServiceStation ssn = new ServiceStation();
        try {
             ssn = JaxbRunner.unmarhall();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        LOGGER.info(ssn);
        LOGGER.info(ssn.equals(ss));
    }
}
