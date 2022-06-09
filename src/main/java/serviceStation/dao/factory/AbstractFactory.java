package serviceStation.dao.factory;

import serviceStation.dao.IBaseDAO;

public abstract class AbstractFactory {
    public abstract IBaseDAO getFactory(String factory);
}
