package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        try {
            isValidWord(word);
        } catch (IllegalStateException illegalStateException) {
            illegalStateException.printStackTrace();
        }

        answer = applyTreeFrogDict(word);

        return answer;
    }

    public static void isValidWord(String word) throws IllegalStateException {
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalStateException("word의 길이가 올바르지 않습니다.");
        }
    }

    public static String applyTreeFrogDict(String word) {
        StringBuilder result = new StringBuilder();
        word.chars().map(Problem4::treeFrogDict).forEach(chars -> result.append((char)chars));
        return result.toString();
    }

    public static int treeFrogDict(int c) {
        if (c == ' ')
            return c;
        if (c >= 'a') {
            return 'z' - (c - 'a');
        } else {
            return 'Z' - (c - 'A');
        }
    }
}
