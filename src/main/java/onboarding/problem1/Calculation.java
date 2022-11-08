package onboarding.problem1;

public class Calculation {
    public static Integer calculate(Integer integer) {
        int sum = 0;
        int product = 1;

        while (integer > 0) {
            int quotient = integer % 10;

            sum += quotient;
            product *= quotient;

            integer /= 10;
        }

        return Math.max(sum, product);
    }
}
