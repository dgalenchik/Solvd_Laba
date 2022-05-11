package service_station.dao;

import service_station.models.Compressor;

public interface ICompressorDAO extends IBaseDAO<Compressor> {
    void showAll();
}
