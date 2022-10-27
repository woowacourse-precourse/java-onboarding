package onboarding.problem1;


import java.util.List;

public class Page {
    public static int getBiggerPage(List<Integer> pages) {
        int leftPage = pages.get(0);
        int leftResult = Math.max(sumNumberOfDigits(leftPage), multiNumberOfDigits(leftPage));
        int rightPage = pages.get(1);
        int rightResult = Math.max(sumNumberOfDigits(rightPage), multiNumberOfDigits(rightPage));
        return Math.max(leftResult, rightResult);
    }

    private static int sumNumberOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static int multiNumberOfDigits(int number) {
        int sum = 1;
        while (number > 0) {
            sum *= (number % 10);
            number /= 10;
        }
        return sum;
    }
}
