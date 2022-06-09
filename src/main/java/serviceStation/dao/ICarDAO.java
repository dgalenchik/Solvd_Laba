package serviceStation.dao;

import serviceStation.models.Car;

import java.util.List;

public interface ICarDAO extends IBaseDAO<Car> {
    void showAll();

    List<Car> getCars();
}
