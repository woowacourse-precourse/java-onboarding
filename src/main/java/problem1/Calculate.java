package problem1;

import static digit.DigitIterable.*;

public class Calculate {
    private static int result;

    public static int digitCalculate(Integer integer, final int operand) {
        result = operand; // SUM -> result = 0      MUL -> result = 1
        forEachDigit(integer, digit -> result = operand == 0 ? result + digit : result * digit);
        return result;
    }
}
