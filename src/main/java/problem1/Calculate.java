package problem1;

public class Calculate {
    public static int digitCalculate(Integer integer, final int operand) {
        int result = operand; // SUM -> result = 0      MUL -> result = 1
        while (integer > 0) {
            int temp = integer % 10;
            result = operand == 0 ? result + temp : result * temp;
            integer /= 10;
        }
        return result;
    }
}
