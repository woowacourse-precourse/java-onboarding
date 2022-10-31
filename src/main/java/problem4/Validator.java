package problem4;

public class Validator {
    private final String word;

    public Validator(String word) {
        this.word = word;
    }

    public void validate() {
        validateRange();
    }

    private void validateRange() {
        int length = word.length();
        if((length < 1) || (length > 1000)) {
            throw new IllegalArgumentException("1~1000 길이의 문자열만 입력 가능합니다.");
        }
    }
}
