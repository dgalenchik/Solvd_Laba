package parsers.models;

public class Worker {
    private Engeneer engeneer;

    public Engeneer getEngeneer() {
        return engeneer;
    }

    public void setEngeneer(Engeneer engeneer) {
        this.engeneer = engeneer;
    }

    @Override
    public String toString() {
        return "Worker{" +
                engeneer +
                '}';
    }
}
