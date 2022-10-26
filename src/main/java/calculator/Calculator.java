package calculator;

import java.util.List;

public class Calculator {

    public static int getBiggerNumber(List<Integer> list) {
        int a = compareNumber(list.get(0));
        int b = compareNumber(list.get(1));
        return Math.max(a, b);
    }

    public static int compareNumber(int number) {
        int plus = 0;
        int multiply = 1;

        while (number != 0) {
            plus += number % 10;
            multiply *= number % 10;
            number /= 10;
        }

        return Math.max(plus, multiply);
    }

    public static int getResult(int a, int b) {
        if (a > b) {
            return 1;
        }
        if (a < b) {
            return 2;
        }
        return 0;
    }
}
