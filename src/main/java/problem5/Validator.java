package problem5;

public class Validator {
    private final int money;

    public Validator(int money) {
        this.money = money;
    }

    public void validate() {
        validateNaturalNumber();
        validateRange();
    }

    private void validateNaturalNumber() {
        String money = String.valueOf(this.money);
        if(!money.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("입력값은 자연수이어야 합니다.");
        }
    }

    private void validateRange() {
        if((money < 1) || (money > 1000000)) {
            throw new IllegalArgumentException("입력값은 1 이상 1000000 이하이어야 합니다.");
        }
    }
}
