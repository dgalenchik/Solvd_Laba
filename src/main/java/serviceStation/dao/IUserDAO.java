package serviceStation.dao;

import serviceStation.models.User;

public interface IUserDAO extends IBaseDAO<User> {
    void generateUsers(String name, String surname, String email, int quantity);

    void showAll();
}
