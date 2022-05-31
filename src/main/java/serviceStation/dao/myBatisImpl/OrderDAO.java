package serviceStation.dao.myBatisImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.IOrderDAO;
import serviceStation.models.Order;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);
    private static IOrderDAO orderDAO;
    private static SqlSession sqlSession;
    private static final SqlSessionFactory sqlSessionFactory;
    private static Reader reader = null;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis.config.xml");
        } catch (IOException e) {
            LOGGER.info(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }


    @Override
    public Order getEntityById(int id) {
        orderDAO = sqlSessionFactory.openSession().getMapper(IOrderDAO.class);
        Order order = orderDAO.getEntityById(id);
        return order;
    }

    @Override
    public void saveEntity(Order entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveOrder", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Order entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateOrder", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(Order entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeOrder", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void showAll() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Order> orders = sqlSession.selectList("showAllOrders");
            orders.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
    }
}
