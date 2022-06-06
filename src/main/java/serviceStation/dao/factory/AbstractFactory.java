package serviceStation.dao.factory;

public class AbstractFactory {
    public <T> T getFactory(String implementation) {
        switch (implementation) {
            case "mybatis":
                return (T) new MyBatisDAOFactory();
            case "jdbc":
                return (T) new JdbcDAOFactory();
            default:
                return null;
        }
    }
}
