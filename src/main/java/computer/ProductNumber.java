package computer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductNumber {
    public static List generateNumbers(int productQuantity) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < productQuantity; i++) {
            numbers.add((int) (Math.random() * 800 * 1300 * Math.PI));
        }
        Collections.sort(numbers);
        return numbers;
    }
}
