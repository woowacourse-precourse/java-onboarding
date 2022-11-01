package onboarding;

public class Problem3 {

    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 10000;
    private static final char THREE = '3';
    private static final char SIX = '6';
    private static final char NINE = '9';

    public static int solution(int number) {
        if (!checkNumberValid(number)) {
            throw new IllegalArgumentException("[error] 잘못된 숫자가 입력되었습니다.");
        }
        int answer = 0;
        for (int i = 0; i <= number; i++) {
            answer += countOfClap(i);
        }
        return answer;
    }

    public static boolean checkNumberValid(int number) {
        return NUMBER_MIN <= number && number <= NUMBER_MAX;
    }

    public static String intToString(int number) {
        return Integer.toString(number);
    }

    public static int countOfClap(int number) {
        int clap = 0;
        for (char eachDigit : intToString(number).toCharArray()) {
            if (eachDigit == THREE || eachDigit == SIX || eachDigit == NINE) {
                clap++;
            }
        }
        return clap;
    }
}
