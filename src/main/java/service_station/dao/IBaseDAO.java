package service_station.dao;

public interface IBaseDAO <T>{
    T getEntityById(int id);
    void saveEntity(T entity);
    void updateEntity (T entity);
    void removeEntity (T entity);
}
