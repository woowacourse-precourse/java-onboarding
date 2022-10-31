package onboarding.problem1;

import java.util.List;

public class Operator {

    public static int add(int number) {
        return number / 100 + (number % 100) / 10 + number % 10;
    }

    public static int multiply(int number) {
        if (number < 10){
            return number;
        } else if (number < 100){
            return (number / 10) * (number % 10);
        }
        return (number / 100) * ((number % 100) / 10) * (number % 10);
    }

    public static int max(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static int compare(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int leftResult = max(add(leftPage), multiply(leftPage));
        int rightResult = max(add(rightPage), multiply(rightPage));

        return max(leftResult,rightResult);
    }
}
