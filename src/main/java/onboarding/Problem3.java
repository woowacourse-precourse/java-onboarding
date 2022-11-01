package onboarding;

public class Problem3 {

    private final static int START = 3;
    private final static int MAX = 10000;
    private final static int MIN = 1;

    public static int solution(int number) {
        int answer = 0;
        checkValidateNumber(number);
        answer = totalClapCount(number);
        return answer;
    }

    private static void checkValidateNumber(int number) {
        if(number < MIN || number > MAX) {
            throw new RuntimeException("숫자가 범위를 벗어났습니다.");
        }
    }

    private static int totalClapCount(int number) {
        int result = 0;
        for(int i = START; i <= number; i++) {
            result += countClap(i);
        }
        return result;
    }

    private static int countClap(int number) {
        int count = 0;
        String stringNum = Integer.toString(number);
        int len = stringNum.length();
        for(int i = 0; i < len; i++) {
            if(isMultiplesOfThree(stringNum.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    private static boolean isMultiplesOfThree(char charNum) {
        int number = charNum - '0';
        if(number != 0 && number % 3 == 0) {
            return true;
        }
        return false;
    }
}
