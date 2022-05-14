package service_station.dao.jdbcMySQLImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service_station.dao.ICarDAO;
import service_station.dao.connectionPool.ConnectionPool;
import service_station.models.Car;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class CarDAO implements ICarDAO{
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static Properties p = new Properties();
    private Car car = new Car();
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
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
    public Car getEntityById(int id) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from cars where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                car.setId(resultSet.getInt("id"));
                car.setManufacture(resultSet.getString("manufacture"));
                car.setYear(resultSet.getInt("year"));
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (resultSet != null) resultSet.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return car;
    }
    @Override
    public void saveEntity(Car entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Insert into cars (manufacture,year) Values (?,?)");
            pr.setString(1, entity.getManufacture());
            pr.setInt(2, entity.getYear());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateEntity (Car entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Update cars Set manufacture=?,`year`=? where id=?");
            pr.setString(1, entity.getManufacture());
            pr.setInt(2, entity.getYear());
            pr.setInt(3, entity.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void removeEntity(Car entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from cars where id=?");
            pr.setInt(1, entity.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
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
            pr = connection.prepareStatement("Select * from cars");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                car.setId(resultSet.getInt("id"));
                car.setManufacture(resultSet.getString("manufacture"));
                car.setYear(resultSet.getInt("year"));
                LOGGER.info(car);
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
