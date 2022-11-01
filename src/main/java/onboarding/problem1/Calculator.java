package onboarding.problem1;

import java.util.List;

public class Calculator {

    private static int add(int number) {
        return number / 100 + (number % 100) / 10 + number % 10;
    }

    private static int multiply(int number) {
        int result = 1;
        while(number>0) {
            int temp = number % 10;
            result *= temp;
            number = number / 10;
        }

        return result;
    }

    private static int max(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static int getScore(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int leftResult = max(add(leftPage), multiply(leftPage));
        int rightResult = max(add(rightPage), multiply(rightPage));

        return max(leftResult,rightResult);
    }
}
