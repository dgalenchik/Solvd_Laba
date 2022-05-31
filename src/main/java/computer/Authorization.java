package computer;

import exceptions.InvalidAuthorizationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

public class Authorization {
    private final String userName;
    private final String password;
    private static String rootUsername = "root";
    private static String rootPassword = "root";
    public static final String MESSAGE;
    private static final Logger LOGGER = LogManager.getLogger(Authorization.class);

    static {
        MESSAGE = "Authorization: Enter your login and password";
    }

    public static void rootInitialization() {
        try (Scanner in = new Scanner(System.in)) {
            LOGGER.info("You need to enter root Username and Password");
            LOGGER.info("Enter the root username: ");
            rootUsername = in.next();
            LOGGER.info("Enter the root password: ");
            rootPassword = in.next();
        }

    }

    public Authorization(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
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

    //Authorization
    public static void rootAuthorize(String user, String pass) {
        try {
            if (user.equals(rootUsername) && pass.equals(rootPassword))
                LOGGER.info("Authorization successful!");
            else
                LOGGER.info("Username or password is wrong");
            throw new InvalidAuthorizationException("Username or password is wrong");
        } catch (InvalidAuthorizationException e) {
            LOGGER.debug(e);
            LOGGER.info("Username: " + user + " " + "Password: " + pass);
        }
    }

    //Authorization for devices
    public void authorize(String user, String pass) {
        try {
            if (user.equals(this.userName) && pass.equals(this.password))
                LOGGER.info("Authorization successful!");
            else
                throw new InvalidAuthorizationException("Username or password is wrong");
        } catch (InvalidAuthorizationException e) {
            LOGGER.debug(e);
            LOGGER.info("Username: " + user + " " + "Password: " + pass);
        }
    }
}


