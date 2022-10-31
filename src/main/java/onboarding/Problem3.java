package onboarding;

public class Problem3 {

    private static final int RULE_NUM = 3;

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String numberWords = intToString(i);

            answer += count369(numberWords);
        }

        return answer;
    }

    private static int count369(String number) {
        int count = 0;
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char currentDigitNum = number.charAt(i);
            int checkingNum = charToInt(currentDigitNum);

            count = check(checkingNum) ? count+1 : count;
        }
        return count;
    }

    private static boolean check(int checkingNum) {
        return (checkingNum % RULE_NUM == 0) && (checkingNum > 0);
    }

    private static String intToString(int num) {
        return String.valueOf(num);
    }

    private static int charToInt(char c) {
        return Character.getNumericValue(c);
    }
}
