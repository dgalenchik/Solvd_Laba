package service_station.dao.jdbcMySQLImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service_station.dao.ICompressorDAO;
import service_station.dao.connectionPool.ConnectionPool;
import service_station.models.Compressor;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class CompressorDAO implements ICompressorDAO {
    private static final Logger LOGGER = LogManager.getLogger(CompressorDAO.class);
    private static Properties p = new Properties();
    private Compressor compressor = new Compressor();
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
    public Compressor getEntityById(int id) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from compressors where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                compressor.setId(resultSet.getInt("id"));
                compressor.setManufacture(resultSet.getString("manufacture"));
                compressor.setPerformance(resultSet.getInt("perfomance"));
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
        return compressor;
    }

    @Override
    public void saveEntity(Compressor entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Insert into compressors (manufacture,perfomance) Values (?,?)");
            pr.setString(1, entity.getManufacture());
            pr.setInt(2, entity.getPerformance());
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
    public void updateEntity(Compressor entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Update compressors Set manufacture=?,`perfomance`=? where id=?");
            pr.setString(1, entity.getManufacture());
            pr.setInt(2, entity.getPerformance());
            pr.setInt(3,entity.getId());
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
    public void removeEntity(Compressor entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from compressors where id=?");
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
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from compressors");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                compressor.setId(resultSet.getInt("id"));
                compressor.setManufacture(resultSet.getString("manufacture"));
                compressor.setPerformance(resultSet.getInt("perfomance"));
                LOGGER.info(compressor);
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
    }
}

