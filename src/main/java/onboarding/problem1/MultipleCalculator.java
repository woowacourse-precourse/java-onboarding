package onboarding.problem1;

import java.util.List;

class MultipleCalculator implements CalculatorInt {
    private final List<Integer> division;

    public MultipleCalculator(List<Integer> division) {
        this.division = division;
    }

    public int getScore() {
        return division.stream().reduce(1, (total, number) -> total * number);
    }
}
