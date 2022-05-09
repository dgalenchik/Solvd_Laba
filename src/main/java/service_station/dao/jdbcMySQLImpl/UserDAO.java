package service_station.dao.jdbcMySQLImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service_station.dao.IBaseDAO;
import service_station.models.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserDAO implements IBaseDAO<User> {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    Properties p = new Properties();


    @Override
    public User getEntityById(int id) {
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            p.load(f);
        } catch (IOException e) {
            LOGGER.info(e);
            String password = p.getProperty("db.password");
            String userName = p.getProperty("db.username");
            String url = p.getProperty("db.url");
            try (Connection conn = DriverManager.getConnection(url, userName, password)) {
                PreparedStatement pr = conn.prepareStatement("Select * from users where id=?");
                pr.setInt(1,3);
                pr.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

        @Override
        public void saveEntity (User entity){

        }

        @Override
        public void updateEntity (User entity){

        }

        @Override
        public void removeEntity (User entity){

        }
    }
