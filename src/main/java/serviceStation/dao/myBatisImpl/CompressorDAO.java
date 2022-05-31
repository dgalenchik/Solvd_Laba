package serviceStation.dao.myBatisImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.ICompressorDAO;
import serviceStation.models.Compressor;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CompressorDAO implements ICompressorDAO {
    private static final Logger LOGGER = LogManager.getLogger(CompressorDAO.class);
    private static ICompressorDAO compressorDAO;
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
    public Compressor getEntityById(int id) {
        compressorDAO = sqlSessionFactory.openSession().getMapper(ICompressorDAO.class);
        Compressor compressor = compressorDAO.getEntityById(id);
        return compressor;
    }

    @Override
    public void saveEntity(Compressor entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("saveCompressor", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateEntity(Compressor entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("updateCompressor", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Override
    public void removeEntity(Compressor entity) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("removeCompressor", entity);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        sqlSession.close();
    }


    @Override
    public void showAll() {
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Compressor> compressors = sqlSession.selectList("showAllCompressors");
            compressors.stream().forEach(LOGGER::info);
        } finally {
            sqlSession.close();
        }
    }
}

