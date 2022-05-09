package service_station.dao;

import service_station.models.User;

public interface IUserDAO extends IBaseDAO<User> {
    @Override
    User getEntityById(int id);
}
