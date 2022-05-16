package parsers.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return Objects.equals(engeneer, worker.engeneer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engeneer);
    }
}
