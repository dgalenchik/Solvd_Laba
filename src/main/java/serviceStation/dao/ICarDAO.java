package serviceStation.dao;

import serviceStation.models.Car;

public interface ICarDAO extends IBaseDAO<Car>{
    void showAll();
}
