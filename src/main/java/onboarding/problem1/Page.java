package onboarding.problem1;

public class Page {
    private final int content;
    Page(int content) {
        this.content = content;
    }

    public int getSum() {
        return Calculator.getDigitSum(content);
    }
    public int getMult() {
        return Calculator.getDigitMult(content);
    }
}
