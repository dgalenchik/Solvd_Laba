package serviceStation.models;

public class Order {
    private int id;
    private String name;
    private int price;
    private int workersId;
    private int clientsId;
    private int carsId;

    public Order() {
    }

    public Order(String name, int price, int workersId, int clientsId, int carsId) {
        this.name = name;
        this.price = price;
        this.workersId = workersId;
        this.clientsId = clientsId;
        this.carsId = carsId;
    }

    public Order(int id, String name, int price, int workersId, int clientsId, int carsId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.workersId = workersId;
        this.clientsId = clientsId;
        this.carsId = carsId;
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

    public int getWorkersId() {
        return workersId;
    }

    public void setWorkersId(int workersId) {
        this.workersId = workersId;
    }

    public int getClientsId() {
        return clientsId;
    }

    public void setClientsId(int clientsId) {
        this.clientsId = clientsId;
    }

    public int getCarsId() {
        return carsId;
    }

    public void setCarsId(int carsId) {
        this.carsId = carsId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", workersId=" + workersId +
                ", clientsId=" + clientsId +
                ", carsId=" + carsId +
                '}';
    }
}
