package problem3;

import static problem3.DigitIterable.forEachDigit;

public class Counter369 {
    private static int totalCount = 0;

    private static int count369(int number) {
        forEachDigit(number, digit->{
            if(is369(digit)) totalCount++;
        });
        return totalCount;
    }

    private static boolean is369(int digit) {
        return digit == 3 || digit == 6 || digit == 9;
    }
}
