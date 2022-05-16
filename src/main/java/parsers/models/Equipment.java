package parsers.models;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;
import java.util.Objects;

public class Equipment {
    private List<Compressor> compressors;
    private Cutter cutter;

    public List<Compressor> getCompressors() {
        return compressors;
    }
@XmlElement(name= "compressor")
    public void setCompressors(List<Compressor> compressors) {
        this.compressors = compressors;
    }

    public Cutter getCutter() {
        return cutter;
    }

    public void setCutter(Cutter cutter) {
        this.cutter = cutter;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "compressors=" + compressors +
                ", cutter=" + cutter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(compressors, equipment.compressors) && Objects.equals(cutter, equipment.cutter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compressors, cutter);
    }
}