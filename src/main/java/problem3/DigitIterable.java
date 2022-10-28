package problem3;

import java.util.function.Consumer;
import java.util.function.IntFunction;

public class DigitIterable {
    public static void forEachDigit(int number, Consumer<Integer> something) {
        while (number > 0){
            int leastSignificantDigit = number % 10;
            number /= 10;
            something.accept(leastSignificantDigit);
        }
    }
}
