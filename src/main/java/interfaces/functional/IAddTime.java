package interfaces.functional;

import java.text.SimpleDateFormat;

@FunctionalInterface
public interface IAddTime {
    SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String addTime();
}
