package onboarding.problem1;

import java.util.Arrays;
import java.util.function.Function;

public class Page {
    private static int sumNumberOfDigits(String stringNumber){
        int number = Integer.parseInt(stringNumber);
        int sum = 0;
        while (number >0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
