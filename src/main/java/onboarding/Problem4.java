package onboarding;

public class Problem4 {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;

    public static String solution(String word) {
        if (!isValidRangeString(word)) {
            throw new IllegalArgumentException("유효한 문자열의 길이를 입력해주세요. (1~1000자)");
        }
        String answer = getAnswer(word);
        return answer;
    }

    public static boolean isValidRangeString(String word) {
        int length = word.length();
        return length >= MIN_LENGTH && length <= MAX_LENGTH;
    }

    public static String getAnswer(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(getFrogWord(c));
        }
        return sb.toString();
    }

    public static char getFrogWord(char alphabet) {
        if (!Character.isAlphabetic(alphabet))
            return alphabet;
        if (Character.isUpperCase(alphabet)) {
            return (char) ('A' + ('Z' - alphabet));
        } else {
            return (char) ('a' + ('z' - alphabet));
        }
    }
}
