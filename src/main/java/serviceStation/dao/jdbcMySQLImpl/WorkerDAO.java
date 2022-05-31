package serviceStation.dao.jdbcMySQLImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.IWorkerDAO;
import serviceStation.dao.connectionPool.ConnectionPool;
import serviceStation.models.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class WorkerDAO implements IWorkerDAO {
    private static final Logger LOGGER = LogManager.getLogger(WorkerDAO.class);
    private static final Properties p = new Properties();
    private final Worker worker = new Worker();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public Worker getEntityById(int id) {
        try {
            connection = connectionPool.retrieve();
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
                if (connection != null) connectionPool.putback(connection);
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
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Insert into workers (position,experience,users_id) Values (?,?,?)");
            pr.setString(1, entity.getPosition());
            pr.setInt(2, entity.getExperience());
            pr.setInt(3, entity.getUsers_id());
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
    public void updateEntity(Worker entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Update workers Set position=?,`experience`=?,users_id=? where id=?");
            pr.setString(1, entity.getPosition());
            pr.setInt(2, entity.getExperience());
            pr.setInt(3, entity.getUsers_id());
            pr.setInt(4, entity.getId());
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
    public void removeEntity(Worker entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from workers where id=?");
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
                if (connection != null) connectionPool.putback(connection);
                if (resultSet != null) resultSet.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }
}


