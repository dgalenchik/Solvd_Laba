package service_station.dao.jdbcMySQLImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service_station.dao.IWorkerDAO;
import service_station.models.Order;
import service_station.models.Worker;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class WorkerDAO implements IWorkerDAO {
    private static final Logger LOGGER = LogManager.getLogger(WorkerDAO.class);
    private static Properties p = new Properties();
    private Worker worker = new Worker();
    private Connection connection = null;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;
    private static String userName;
    private static String url;
    private static String password;

    static {
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            p.load(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = p.getProperty("db.url");
        userName = p.getProperty("db.username");
        password = p.getProperty("db.password");
    }
    @Override
    public Worker getEntityById(int id) {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            pr = connection.prepareStatement("Select * from workers where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                worker.setId(resultSet.getInt("id"));
                worker.setPosition(resultSet.getString("position"));
                worker.setExperience(resultSet.getInt("experience"));
                worker.setUsers_id(resultSet.getInt("users_id"));
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (resultSet != null) resultSet.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return worker;
    }

    @Override
    public void saveEntity(Worker entity) {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            pr = connection.prepareStatement
                    ("Insert into workers (position,experience,users_id) Values (?,?,?)");
            pr.setString(1, entity.getPosition());
            pr.setInt(2, entity.getExperience());
            pr.setInt(3,entity.getUsers_id());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateEntity(Worker entity) {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            pr = connection.prepareStatement
                    ("Update workers Set position=?,`experience`=?,users_id=? where id=?");
            pr.setString(1, entity.getPosition());
            pr.setInt(2, entity.getExperience());
            pr.setInt(3, entity.getUsers_id());
            pr.setInt(4,entity.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void removeEntity(Worker entity) {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            pr = connection.prepareStatement("Delete from workers where id=?");
            pr.setInt(1, entity.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void showAll() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            pr = connection.prepareStatement("Select * from workers");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                worker.setId(resultSet.getInt("id"));
                worker.setPosition(resultSet.getString("position"));
                worker.setExperience(resultSet.getInt("experience"));
                worker.setUsers_id(resultSet.getInt("users_id"));
                LOGGER.info(worker);
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (resultSet != null) resultSet.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }
}


