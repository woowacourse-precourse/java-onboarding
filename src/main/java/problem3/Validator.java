package problem3;

public class Validator {
    private final int number;

    public Validator(int number) {
        this.number = number;
    }

    public void validate() {
        validateNaturalNumber();
        validateRange();
    }

    private void validateNaturalNumber() {
        String number = String.valueOf(this.number);
        if(!number.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("입력값은 자연수이어야 합니다.");
        }
    }

    private void validateRange() {
        if((number < 1) || (number > 10000)) {
            throw new IllegalArgumentException("입력값은 1 이상 10000 이하이어야 합니다.");
        }
    }
}
