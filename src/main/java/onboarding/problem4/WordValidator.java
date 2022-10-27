package onboarding.problem4;

public class WordValidator {

    public static void validateWord(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException("word는 길이가 1 이상 1,000 이하인 문자열입니다.");
        }
    }
}
