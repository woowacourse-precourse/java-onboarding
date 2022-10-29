package onboarding.problem4;

public class Validation {

    private String word;

    public Validation(String word) {
        if (!isValid(word)) {
            throw new IllegalArgumentException("유효하지 않은 문자열입니다.");
        }
        this.word = word;
    }

    // 문자 검증 && 문자열 길이 검증
    private boolean isValid(String word) {
        // 1 부터 1000 이하
        if (isLengthValid(word)) {
            return true;
        }
        return false;
    }


    // 문자열 길이 검증
    private boolean isLengthValid(String word) {
        return word.length() >= 1 && word.length() <= 1000;
    }
}
