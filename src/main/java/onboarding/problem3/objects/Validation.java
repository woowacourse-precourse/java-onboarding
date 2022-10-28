package onboarding.problem3.objects;

public class Validation {

    private int number;

    public Validation(int number) {
        this.number = number;
    }

    public boolean isValid() {
        if (isNumberRangeValid()) {
            return true;
        }
        return false;
    }

    private boolean isNumberRangeValid() {
        return this.number >= 1 && this.number <= 10000;
    }
}
