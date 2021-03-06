package serviceStation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceStation.dao.ICarDAO;
import serviceStation.dao.IOrderDAO;
import serviceStation.dao.factory.FactoryGenerator;
import serviceStation.models.Car;
import serviceStation.models.Listener;
import serviceStation.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Discount {
    private static final Logger LOGGER = LogManager.getLogger(Discount.class);
    private static List<Listener> listeners = new ArrayList<>();

    public static List<Listener> getListeners() {
        return listeners;
    }

    public static void setListeners(List<Listener> listeners) {
        Discount.listeners = listeners;
    }

    public static void makeDiscount(String manufacture, double discount) {
        if (discount <= 0) throw new IllegalArgumentException("The value of discount must be positive: " + discount);

        ICarDAO carDAO = (ICarDAO) FactoryGenerator.createFactory("mybatis").getFactory("car");
        IOrderDAO orderDAO = (IOrderDAO) FactoryGenerator.createFactory("mybatis").getFactory("order");

        List<Order> discountedOrders = new ArrayList<>();
        List<Car> cars = carDAO.getCars().stream().filter(c -> c.getManufacture() != null && c.getManufacture().equals(manufacture)).collect(Collectors.toList());
        List<Order> orders = orderDAO.getOrders();
        if (!cars.isEmpty()) {
            for (int i = 0; i < cars.size(); i++) {
                for (Order o : orders) {
                    if (o.getCarsId() == cars.get(i).getId()) {
                        o.setPrice((int) Math.round(o.getPrice() - (o.getPrice() * (discount / 100))));
                        discountedOrders.add(o);
                    }
                }
            }
        }
        for (int i = 0; i < discountedOrders.size(); i++) {
            LOGGER.info(discountedOrders.get(i));
            orderDAO.updateEntity(discountedOrders.get(i));
        }
    }

    public static void changePriceById(int id, int price) {
        IOrderDAO orderDAO = (IOrderDAO) FactoryGenerator.createFactory("mybatis").getFactory("order");
        ICarDAO carDAO = (ICarDAO) FactoryGenerator.createFactory("mybatis").getFactory("car");
        Order order = orderDAO.getEntityById(1);
        Car car = carDAO.getEntityById(order.getCarsId());
        listeners.add(car);
        listeners.add(order);
        order.setPrice(price);
        FactoryGenerator.createFactory("mybatis").getFactory("order").updateEntity(order);
        for (Listener l : listeners) {
            l.notifyListener();
        }
    }

    public static void main(String[] args) {
        makeDiscount("Volvo", 1);
        changePriceById(1, 6000);
    }
}
