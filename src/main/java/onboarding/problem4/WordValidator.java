package onboarding.problem4;

public class WordValidator {

    private static final Integer WORD_MINIMUM_LENGTH = 1;
    private static final Integer WORD_MAXIMUM_LENGTH = 1000;

    public static void validateWord(String word) {
        if (word.length() < WORD_MINIMUM_LENGTH || word.length() > WORD_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("word는 길이가 1 이상 1,000 이하인 문자열입니다.");
        }
    }
}
