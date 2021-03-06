package serviceStation.dao.factory;

import serviceStation.dao.IBaseDAO;
import serviceStation.dao.jdbcMySQLImpl.*;

public class JdbcDAOFactory extends AbstractFactory {
    public static IBaseDAO createDAO(String dao) {
        switch (dao) {
            case "user": {
                return new UserDAO();
            }
            case "car": {
                return new CarDAO();
            }
            case "compressor": {
                return new CompressorDAO();
            }
            case "order": {
                return new OrderDAO();
            }
            case "worker": {
                return new WorkerDAO();
            }
        }
        return null;
    }

    @Override
    public IBaseDAO getFactory(String factory) {
        return createDAO(factory);
    }
}


