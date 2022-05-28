package serviceStation.dao;

import serviceStation.models.Order;

public interface IOrderDAO extends IBaseDAO<Order> {
    void showAll();
}
