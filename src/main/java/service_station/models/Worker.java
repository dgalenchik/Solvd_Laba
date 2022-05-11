package service_station.models;

public class Worker {
    private int id;
    private String position;
    private int experience;
    private int users_id;

    public Worker() {
    }

    public Worker(int id, String position, int experience, int users_id) {
        this.id = id;
        this.position = position;
        this.experience = experience;
        this.users_id = users_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", experience=" + experience +
                ", users_id=" + users_id +
                '}';
    }
}
