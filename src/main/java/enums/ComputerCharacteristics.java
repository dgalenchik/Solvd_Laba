package enums;

public enum ComputerCharacteristics {

    CPU(Manufactures.ACER, MainCharacteristics.CPU.getFrequency()),
    MEMORY(Manufactures.ALIENWARE, MainCharacteristics.MEMORY.getFrequency()),
    GRAPHIC_CARD(Manufactures.DELL, MainCharacteristics.GRAPHIC_CARD.getFrequency()),
    AUDIO_CARD(Manufactures.ALIENWARE, MainCharacteristics.AUDIO_CARD.getFrequency());

    public Manufactures getManufactures() {
        return manufactures;
    }

    public String getFrequency() {

        return frequency;
    }

    private Manufactures manufactures;
    private String frequency;

    ComputerCharacteristics(Manufactures manufactures, String freq) {
        this.manufactures = manufactures;
        this.frequency = freq;
    }
}
