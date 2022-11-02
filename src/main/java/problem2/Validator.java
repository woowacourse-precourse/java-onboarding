package problem2;

public class Validator {
    private final String cryptogram;

    public Validator(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public void validate() {
        validateRange();
        validateLowerCase();
    }

    private void validateRange() {
        int length = cryptogram.length();
        if ((length < 1) || (length > 1000)) {
            throw new IllegalArgumentException("1~1000 길이의 문자열만 입력 가능합니다.");
        }
    }

    private void validateLowerCase() {
        if(!cryptogram.matches("^[a-z]*$")){
            throw new IllegalArgumentException("알파벳 소문자만 입력 가능합니다.");
        }
    }
}
