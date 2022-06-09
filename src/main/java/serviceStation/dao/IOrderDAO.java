package serviceStation.dao;

import serviceStation.models.Order;

import java.util.List;

public interface IOrderDAO extends IBaseDAO<Order> {
    void showAll();

    List<Order> getOrders();
}
