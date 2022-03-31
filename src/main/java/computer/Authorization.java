package computer;

import main.java.exceptions.InvalidAuthorizationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

public final class Authorization {
    public static String ROOT_USERNAME = "root";
    public static String ROOT_PASSWORD = "root";
    public static final String MESSAGE;
    private final String userName;
    private final String password;
    private static Logger LOGGER = LogManager.getLogger(Authorization.class);

    public Authorization(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    static {
        MESSAGE = "main.java.computer.Authorization: Enter your login and password";
    }

    public static void rootInitialization() {
        Scanner in = new Scanner(System.in);
        LOGGER.info("You need to enter root Username and Password");
        LOGGER.info("Enter the root username: ");
        ROOT_USERNAME = in.next();
        LOGGER.info("Enter the root password: ");
        ROOT_PASSWORD = in.next();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorization that = (Authorization) o;
        return Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    public static String readUserName(Scanner in) {
        LOGGER.info("Enter username: ");
        return in.next();
    }

    public static String readPassword(Scanner in) {
        LOGGER.info("Enter password: ");
        return in.next();
    }

    //root main.java.computer.Authorization
    public static void rootAuthorize(String user, String pass) {
        try {
            if (user.equals(ROOT_USERNAME) && pass.equals(ROOT_PASSWORD))
                LOGGER.info("main.java.computer.Authorization successful!");
            else
                LOGGER.info("Username or password is wrong");
            throw new InvalidAuthorizationException("Username or password is wrong");
        } catch (InvalidAuthorizationException e) {
            LOGGER.debug(e);
            LOGGER.info("Username: " + user + " " + "Password: " + pass);
        }
    }

    //main.java.computer.Authorization for devices
    public void authorize(String user, String pass) {
        try {
            if (user.equals(this.userName) && pass.equals(this.password))
                LOGGER.info("main.java.computer.Authorization successful!");
            else
                throw new InvalidAuthorizationException("Username or password is wrong");
        } catch (InvalidAuthorizationException e) {
            LOGGER.debug(e);
            LOGGER.info("Username: " + user + " " + "Password: " + pass);
        }
    }
}


