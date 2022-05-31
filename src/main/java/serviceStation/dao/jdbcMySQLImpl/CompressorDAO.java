package serviceStation.dao.jdbcMySQLImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.ICompressorDAO;
import serviceStation.dao.connectionPool.ConnectionPool;
import serviceStation.models.Compressor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CompressorDAO implements ICompressorDAO {
    private static final Logger LOGGER = LogManager.getLogger(CompressorDAO.class);
    private static final Properties p = new Properties();
    private final Compressor compressor = new Compressor();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

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

