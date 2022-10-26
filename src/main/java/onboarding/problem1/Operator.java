package onboarding.problem1;

public class Operator {
    private static int sum(int number){
        return number / 100 + (number % 100) / 10 + number % 10;
    }
    private static int multiply(int number){
        if (number < 10){
            return number;
        } else if (number < 100){
            return (number / 10) * (number % 10);
        }
        return (number / 100) * ((number % 100) / 10) * (number % 10);
    }
}
