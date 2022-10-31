package problem2;

public class Validator {
    private final String cryptogram;

    public Validator(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public void validate() {
        validateRange();
    }

    private void validateRange() {
        int length = cryptogram.length();
        if (length < 1 || length > 1000) {
            throw new IllegalArgumentException("1~1000 크기의 문자열만 입력 가능합니다.");
        }
    }
}
