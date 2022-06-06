package parsers.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceStationBuilder {
    private static final Logger LOGGER = LogManager.getLogger(ServiceStationBuilder.class);
    public static ServiceStation buildServiceStation() {
        ServiceStation serviceStation = new ServiceStation();
        List<Worker> workersList = new ArrayList<>();
        List<Equipment> equipmentList = new ArrayList<>();
        Equipment equipment = new Equipment();
        Cutter cutter = new Cutter();
        Compressor compressor = new Compressor();
        List<Compressor> compressorList = new ArrayList<>();
        compressorList.add(compressor);
        equipment.setCutter(cutter);
        equipment.setCompressors(compressorList);
        equipmentList.add(equipment);
        Engeneer engeneer = new Engeneer();
        Worker worker = new Worker();
        worker.setEngeneer(engeneer);
        workersList.add(worker);
        try {
            engeneer.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("15/12/1985"));
        } catch (ParseException e) {
            LOGGER.info(e);
        }

        serviceStation.setId((int) (Math.random() * 100));
        serviceStation.setName("Test service station");
        serviceStation.setAddress("Test address");
        serviceStation.setEquipment(equipmentList);
        serviceStation.setWorkers(workersList);
        return serviceStation;
    }

    public static void main(String[] args) {
        LOGGER.info(ServiceStationBuilder.buildServiceStation());
    }
}
