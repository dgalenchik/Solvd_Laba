package service_station.dao;

import service_station.models.User;

public interface IUserDAO extends IBaseDAO<User> {
    void generateUsers(String name, String surname, String email, int quantity);
    void showAll();
}
