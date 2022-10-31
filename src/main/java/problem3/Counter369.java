package problem3;

import static digit.DigitIterable.forEachDigit;

public class Counter369 {
    private int totalCount = 0;

    public void count369(int number) {
        forEachDigit(number, digit->{
            if(is369(digit)) totalCount++;
        });
    }

    public int getTotalCount() {
        return totalCount;
    }

    private static boolean is369(int digit) {
        return digit == 3 || digit == 6 || digit == 9;
    }
}
