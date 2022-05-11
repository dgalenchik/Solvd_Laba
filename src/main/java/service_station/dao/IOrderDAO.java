package service_station.dao;

import service_station.models.Order;

public interface IOrderDAO extends IBaseDAO<Order> {
    void showAll();
}
