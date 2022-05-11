package service_station.dao;

import service_station.models.Worker;

public interface IWorkerDAO extends IBaseDAO<Worker> {
void showAll();
}
