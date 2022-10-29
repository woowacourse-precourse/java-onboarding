package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        try {
            isValidWord(word);
        } catch (IllegalStateException illegalStateException) {
            illegalStateException.printStackTrace();
        }

        return answer;
    }

    public static void isValidWord(String word) throws IllegalStateException {
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalStateException("word의 길이가 올바르지 않습니다.");
        }
    }
}
