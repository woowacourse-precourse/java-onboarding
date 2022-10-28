package onboarding;

public class Problem3 {
    private static final String THREE = "3";
    private static final String SIX = "6";
    private static final String NINE = "9";

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static String toString(int number) {
        return String.valueOf(number);
    }

    private static int hasThreeSixNine(String number, int length) {
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
}
