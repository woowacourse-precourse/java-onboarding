package onboarding;

public class Problem4 {
    public static String solution(String word) {
        checkList(word);

    }

    public static void checkList(String word) throws IllegalArgumentException{
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException("word는 길이가 1 미만 1,000 초과 입니다.");
        }
    }
}

