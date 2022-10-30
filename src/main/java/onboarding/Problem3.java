package onboarding;

public class Problem3 {
    private static final char THREE = '3';
    private static final char SIX = '6';
    private static final char NINE = '9';

    public static int solution(int number) {
        int answer = getAnswer(number);
        return answer;
    }

    public static int getAnswer(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            String numberStr = makeStringNumber(i);
            count += getClapCountByStrNumber(numberStr);
        }
        return count;
    }

    public static int getClapCountByStrNumber(String numberStr) {
        int count = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            char numTypeOfChar = numberStr.charAt(i);
            if (isClapTiming(numTypeOfChar))
                count++;
        }
        return count;
    }

    public static boolean isClapTiming(char numTypeOfChar) {
        boolean isClapTiming = false;
        if (numTypeOfChar == THREE || numTypeOfChar == SIX || numTypeOfChar == NINE)
            isClapTiming = true;
        return isClapTiming;
    }

    public static String makeStringNumber(int number) {
        return String.valueOf(number);
    }
}
