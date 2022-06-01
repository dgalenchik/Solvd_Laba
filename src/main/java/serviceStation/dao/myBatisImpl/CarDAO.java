package serviceStation.dao.myBatisImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.ICarDAO;
import serviceStation.models.Car;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CarDAO implements ICarDAO {
    private static final Logger LOGGER = LogManager.getLogger(CarDAO.class);
    private static ICarDAO carMapper;
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
    public Car getEntityById(int id) {
        carMapper = sqlSessionFactory.openSession().getMapper(ICarDAO.class);
        Car car = carMapper.getEntityById(id);
        return car;
    }

    @Override
    public void saveEntity(Car entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Car entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void removeEntity(Car entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeEntity", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


    @Override
    public void showAll() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Car> cars = sqlSession.selectList("showAll");
            cars.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars;
        try{
            sqlSession =sqlSessionFactory.openSession();
             cars = sqlSession.selectList("showAll");
        } finally {
            sqlSession.close();
        }
        return cars;
    }
}




