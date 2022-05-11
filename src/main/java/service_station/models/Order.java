package service_station.models;

public class Order {
    private int id;
    private String name;
    private int price;
    private int workers_id;
    private int clients_id;
    private int cars_id;

    public Order() {
    }

    public Order(String name, int price, int workers_id, int clients_id, int cars_id) {
        this.name = name;
        this.price = price;
        this.workers_id = workers_id;
        this.clients_id = clients_id;
        this.cars_id = cars_id;
    }

    public Order(int id, String name, int price, int workers_id, int clients_id, int cars_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.workers_id = workers_id;
        this.clients_id = clients_id;
        this.cars_id = cars_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWorkers_id() {
        return workers_id;
    }

    public void setWorkers_id(int workers_id) {
        this.workers_id = workers_id;
    }

    public int getClients_id() {
        return clients_id;
    }

    public void setClients_id(int clients_id) {
        this.clients_id = clients_id;
    }

    public int getCars_id() {
        return cars_id;
    }

    public void setCars_id(int cars_id) {
        this.cars_id = cars_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", workers_id=" + workers_id +
                ", clients_id=" + clients_id +
                ", cars_id=" + cars_id +
                '}';
    }
}
