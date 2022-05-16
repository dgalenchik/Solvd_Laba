package parsers.models;

public class Equipment {
    private Compressor compressor;
    private Cutter cutter;

    public Compressor getCompressor() {
        return compressor;
    }

    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
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
                "compressor=" + compressor +
                ", cutter=" + cutter +
                '}';
    }
}
