package serviceStation.dao.jdbcMySQLImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.IOrderDAO;
import serviceStation.dao.connectionPool.ConnectionPool;
import serviceStation.models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class OrderDAO implements IOrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);
    private static final Properties p = new Properties();
    private final Order order = new Order();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public Order getEntityById(int id) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from orders where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                order.setName(resultSet.getString("name"));
                order.setPrice(resultSet.getInt("price"));
                order.setWorkers_id(resultSet.getInt("workers_id"));
                order.setClients_id(resultSet.getInt("clients_id"));
                order.setCars_id(resultSet.getInt("cars_id"));
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
        return order;
    }

    @Override
    public void saveEntity(Order entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Insert into orders (name,price,workers_id,clients_id,cars_id) Values (?,?,?,?,?)");
            pr.setString(1, entity.getName());
            pr.setInt(2, entity.getPrice());
            pr.setInt(3, entity.getWorkers_id());
            pr.setInt(4, entity.getClients_id());
            pr.setInt(5, entity.getCars_id());
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
    public void updateEntity(Order entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Update orders Set name=?,`price`=?,workers_id=?,clients_id=?,cars_id=? where id=?");
            pr.setString(1, entity.getName());
            pr.setInt(2, entity.getPrice());
            pr.setInt(3, entity.getWorkers_id());
            pr.setInt(4, entity.getClients_id());
            pr.setInt(5, entity.getCars_id());
            pr.setInt(6, entity.getId());
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
    public void removeEntity(Order entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from orders where id=?");
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
            pr = connection.prepareStatement("Select * from orders");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                order.setName(resultSet.getString("name"));
                order.setPrice(resultSet.getInt("price"));
                order.setWorkers_id(resultSet.getInt("workers_id"));
                order.setClients_id(resultSet.getInt("clients_id"));
                order.setCars_id(resultSet.getInt("cars_id"));
                LOGGER.info(order);
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

