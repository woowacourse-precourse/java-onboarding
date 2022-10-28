package onboarding.problem3.objects;

public class Validation {

    private int number;

    public Validation(int number) {
        this.number = number;
        if (!isNumberRangeValid()) {
            throw new IllegalArgumentException("유요하지 않는 숫자입니다.");
        }
    }

    private boolean isNumberRangeValid() {
        return this.number >= 1 && this.number <= 10000;
    }
}
