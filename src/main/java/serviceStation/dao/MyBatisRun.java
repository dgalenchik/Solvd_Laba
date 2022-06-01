package serviceStation.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.myBatisImpl.*;

public class MyBatisRun {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisRun.class);

    public static void main(String[] args) {
        ICarDAO carDAO = new CarDAO();
//        LOGGER.info(carDAO.getEntityById(2));
//        LOGGER.info(carDAO.getEntityById(3));
//        Car car = new Car("TEST4000", 2040);
//        car.setId(23);
//        carDAO.getEntityById(5);
////        carDAO.saveEntity(car);
////        carDAO.updateEntity(car);
////        carDAO.removeEntity(car);
        carDAO.showAll();
        ICompressorDAO compressorDAO = new CompressorDAO();
////        LOGGER.info(compressorDAO.getEntityById(2));
////        Compressor compressor = new Compressor("TEST",4444);
////        compressorDAO.saveEntity(compressor);
////        compressor.setManufacture("Rename");
////        compressor.setId(10);
////        compressorDAO.updateEntity(compressor);
////        compressorDAO.removeEntity(compressor);
        compressorDAO.showAll();
        IOrderDAO orderDAO = new OrderDAO();
////        Order order = new Order(10,"Test",1,1,2,2);
////        orderDAO.saveEntity(order);
////        order.setPrice(2);
////        orderDAO.updateEntity(order);
////        orderDAO.removeEntity(order);
////        LOGGER.info(orderDAO.getEntityById(10));
        orderDAO.showAll();
////        User user = new User("Test","Test","Test");
        IUserDAO userDAO = new UserDAO();
////        LOGGER.info(userDAO.getEntityById(3));
////        userDAO.saveEntity(user);
////       user.setEmail("Renamed");
////        user.setId(121);
////        userDAO.updateEntity(user);
////        userDAO.removeEntity(user);
////        userDAO.generateUsers("test","test","test@test",10);
        userDAO.showAll();
////        Worker worker = new Worker(2, "Test", 15, 1);
        IWorkerDAO workerDAO = new WorkerDAO();
////        workerDAO.updateEntity(worker);
////        workerDAO.removeEntity(worker);
//        LOGGER.info(workerDAO.getEntityById(10));
        workerDAO.showAll();
    }
}
