package serviceStation.dao.factory;

public class FactoryGenerator {
    public static AbstractFactory createFactory(String implementation) {
        switch (implementation) {
            case "mybatis":
                return new MyBatisDAOFactory();
            case "jdbc":
                return new JdbcDAOFactory();
            default:
                throw new IllegalArgumentException("Incorrect value of implementation: " + implementation);
        }
    }
}
