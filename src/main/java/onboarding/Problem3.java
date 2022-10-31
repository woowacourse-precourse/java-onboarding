package onboarding;

public class Problem3 {
    private static final String THREE = "3";
    private static final String SIX = "6";
    private static final String NINE = "9";

    public static int solution(int number) {
        int answer = 0;
        answer = runGame(number);
        return answer;
    }

    public static String toString(int number) {
        return String.valueOf(number);
    }

    public static int hasThreeSixNine(String number, int length) {
        int clapCount = 0;
        for (int i = 0; i < length; i++) {
            if (number.substring(i, i + 1).equals(THREE)) {
                clapCount += 1;
            }
            if (number.substring(i, i + 1).equals(SIX)) {
                clapCount += 1;
            }
            if (number.substring(i, i + 1).equals(NINE)) {
                clapCount += 1;
            }
        }
        return clapCount;
    }

    public static int getStringLength(String number) {
        return number.length();
    }

    public static int runGame(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            String stringNumber = toString(i);
            int length = getStringLength(stringNumber);
            result += hasThreeSixNine(stringNumber, length);
        }
        return result;
    }
}
