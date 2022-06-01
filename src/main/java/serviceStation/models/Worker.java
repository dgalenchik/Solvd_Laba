package serviceStation.models;

public class Worker {
    private int id;
    private String position;
    private int experience;
    private int usersId;

    public Worker() {
    }

    public Worker(int id, String position, int experience, int usersId) {
        this.id = id;
        this.position = position;
        this.experience = experience;
        this.usersId = usersId;
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

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", experience=" + experience +
                ", usersId=" + usersId +
                '}';
    }
}
