package enums;

public enum ComputerCharacteristics {

    CPU(Manufactures.ACER, MainCharacteristics.CPU.getFrequency()),
    MEMORY(Manufactures.ALIENWARE, MainCharacteristics.MEMORY.getFrequency()),
    GRAPHIC_CARD(Manufactures.DELL, MainCharacteristics.GRAPHIC_CARD.getFrequency()),
    AUDIO_CARD(Manufactures.ALIENWARE, MainCharacteristics.AUDIO_CARD.getFrequency());

    private final Manufactures manufactures;
    private final String frequency;

    ComputerCharacteristics(Manufactures manufactures, String freq) {
        this.manufactures = manufactures;
        this.frequency = freq;
    }

    public Manufactures getManufactures() {
        return manufactures;
    }

    public String getFrequency() {

        return frequency;
    }


}
