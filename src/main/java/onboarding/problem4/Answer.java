package onboarding.problem4;

public class Answer {
    private static final int LOWER_A = 97;
    private static final int LOWER_Z = 122;
    private static final int UPPER_A = 65;
    private static final int UPPER_Z = 90;

    public static String sayTheOpposite(String word) {
        String answer = "";
        for (int idx = 0; idx < word.length(); idx++) {
            char message = word.charAt(idx);
            answer += getOppositeChar(message);
        }
        return answer;
    }

    private static char getOppositeChar(char message) {
        char oppositeChar = message;
        if (isLowerCase(message)) {
            oppositeChar = getOppositeLowerCase(message);
        } else if (isUpperCase(message)) {
            oppositeChar = getOppositeUpperCase(message);
        }
        return oppositeChar;
    }

    private static char getOppositeLowerCase(char message) {
        return (char) (LOWER_Z - ((int) message - LOWER_A));
    }

    private static char getOppositeUpperCase(char message) {
        return (char) (UPPER_Z - ((int) message - UPPER_A));
    }

    private static boolean isLowerCase(char message) {
        return ((int) message >= LOWER_A) && ((int) message <= LOWER_Z);
    }

    private static boolean isUpperCase(char message) {
        return ((int) message >= UPPER_A) && ((int) message <= UPPER_Z);
    }
}
