package enums;

public enum MainCharacteristics {
    CPU(1600d) {
        private double frequency;

        public double getFreq() {
            return frequency;
        }

        public String getValue() {
            return "Cpu";
        }
    },
    MEMORY(2500d) {
        public String getValue() {
            return "Memory";
        }
    },
    GRAPHIC_CARD(3800d) {
        public String getValue() {
            return "GRAPHIC_CARD";
        }
    },
    AUDIO_CARD(420d) {
        public String getValue() {
            return "AUDIO_CARD";
        }
    };
    private double frequency;

    MainCharacteristics(double freq) {
        this.frequency = freq;
    }

    public String getFrequency() {
        return String.valueOf(frequency);
    }

    private String value;

    public String getValue() {
        return value;
    }

}

