package onboarding.problem3;

public enum ClapNumber {
    THREE('3'),
    SIX('6'),
    NINE('9');

    private char number;

    ClapNumber(char number) {
        this.number = number;
    }

    public boolean isEqual(char number) {
        return this.number == number;
    }
}
