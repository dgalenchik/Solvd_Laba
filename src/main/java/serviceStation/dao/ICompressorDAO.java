package serviceStation.dao;

import serviceStation.models.Compressor;

public interface ICompressorDAO extends IBaseDAO<Compressor> {
    void showAll();
}
