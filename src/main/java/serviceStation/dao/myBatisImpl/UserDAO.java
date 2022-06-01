package serviceStation.dao.myBatisImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.IUserDAO;
import serviceStation.models.User;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private static IUserDAO userMapper;
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
    public User getEntityById(int id) {
        userMapper = sqlSessionFactory.openSession().getMapper(IUserDAO.class);
        User user = userMapper.getEntityById(id);
        return user;
    }

    @Override
    public void saveEntity(User entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveUser", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(User entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateUser", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void removeEntity(User entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeUser", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


    @Override
    public void generateUsers(String name, String surname, String email, int quantity) {
        try {
            for (int i = 0; i < quantity; i++) {
                User user = new User();
                user.setName(name + "_" + i);
                user.setSurname(surname + "_" + i);
                user.setEmail(email + "_" + i);
                sqlSession = sqlSessionFactory.openSession();
                sqlSession.insert("saveUser", user);
                sqlSession.commit();
            }
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void showAll() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<User> cars = sqlSession.selectList("showAllUsers");
            cars.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
    }
}
