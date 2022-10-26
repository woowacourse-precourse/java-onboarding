package onboarding.problem1;

public class Comparator {
    private static int compareSumAndMultiplication(int number){
        return Operator.max(Operator.sum(number),Operator.multiply(number));
    }
}
