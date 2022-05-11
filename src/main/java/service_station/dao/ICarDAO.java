package service_station.dao;

import service_station.models.Car;

public interface ICarDAO extends IBaseDAO<Car>{
    void showAll();
}
