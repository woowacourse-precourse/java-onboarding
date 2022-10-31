package onboarding.problem1;

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
}
