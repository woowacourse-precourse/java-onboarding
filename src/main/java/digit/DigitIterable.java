package digit;

import java.util.function.Consumer;

public class DigitIterable {
    public static void forEachDigit(int number, Consumer<Integer> something) {
        while (number > 0){
            int leastSignificantDigit = number % 10;
            number /= 10;
            something.accept(leastSignificantDigit);
        }
    }
}
