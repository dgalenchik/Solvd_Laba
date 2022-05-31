package serviceStation.dao.myBatisImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.IWorkerDAO;
import serviceStation.models.Worker;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class WorkerDAO implements IWorkerDAO {
    private static final Logger LOGGER = LogManager.getLogger(WorkerDAO.class);
    private static IWorkerDAO workerMapper;
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
    public Worker getEntityById(int id) {
        workerMapper = sqlSessionFactory.openSession().getMapper(IWorkerDAO.class);
        Worker worker = workerMapper.getEntityById(id);
        return worker;
    }

    @Override
    public void saveEntity(Worker entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveWorker", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Worker entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateWorker", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntity(Worker entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeWorker", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void showAll() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Worker> workers = sqlSession.selectList("showAllWorkers");
            workers.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
    }
}
