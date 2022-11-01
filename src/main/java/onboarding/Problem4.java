package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = AlphabetController.convertString(word);
        return answer;
    }
}

class AlphabetController {
    static final int UPPER_START_INDEX = 65;
    static final int UPPER_END_INDEX = 90;
    static final int LOWER_START_INDEX = 97;
    static final int LOWER_END_INDEX = 122;

    private static boolean isUpperAlpha(char alpha) {
        return ((int)alpha >= UPPER_START_INDEX && (int)alpha <= UPPER_END_INDEX);
    }

    private static boolean isLowerAlpha(char alpha) {
        return ((int)alpha >= LOWER_START_INDEX && (int)alpha <= LOWER_END_INDEX);
    }

    private static char convertUpperAlpha(char upperAlpha) {
        int index = (int)upperAlpha - UPPER_START_INDEX;

        return (char)(UPPER_END_INDEX- index);
    }

    private static char convertLowerAlpha(char lowerAlpha) {
        int index = (int)lowerAlpha - LOWER_START_INDEX;

        return (char)(LOWER_END_INDEX - index);
    }

    private static char checkAndConvert(char alpha) {
        if (isUpperAlpha(alpha)) {
            return convertUpperAlpha(alpha);
        }
        if (isLowerAlpha(alpha)) {
            return convertLowerAlpha(alpha);
        }
        return alpha;
    }

    static String convertString(String input) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < input.length(); i++) {
            result.append(checkAndConvert(input.charAt(i)));
        }
        return result.toString();
    }
}