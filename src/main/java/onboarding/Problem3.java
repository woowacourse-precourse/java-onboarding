package onboarding;

public class Problem3 {

    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 10000;
    private static final char THREE = '3';

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static boolean checkNumberValid(int number) {
        return NUMBER_MIN <= number && number <= NUMBER_MAX;
    }

    public static String intToString(int number) {
        return Integer.toString(number);
    }

    public static int countOfThree(int number) {
        int countOfThree = 0;
        for (char eachDigit : intToString(number).toCharArray()) {
            if (eachDigit == THREE) {
                countOfThree++;
            }
        }
        return countOfThree;
    }
}
