package onboarding;

public class Problem4 {

    static StringBuilder answer;

    static void input() {
        answer = new StringBuilder();
    }

    private static void validateWord(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException("word는 길이가 1 이상 1,000 이하인 문자열입니다.");
        }
    }

    public static String solution(String word) {
        validateWord(word);
        return answer.toString();
    }


}
