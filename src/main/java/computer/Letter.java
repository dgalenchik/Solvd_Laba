package computer;

import java.util.Objects;

public class Letter {
    private String letterText;

    public Letter() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return Objects.equals(letterText, letter.letterText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letterText);
    }

    public Letter(String message) {
        this.letterText = message;
    }


    public String getLetterText() {
        return letterText;
    }

    public void setLetterText(String letterText) {
        this.letterText = letterText;
    }


}
