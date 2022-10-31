package onboarding.problem1;

import java.util.List;

class SumCalculator {
    private final List<Integer> division;

    public SumCalculator(List<Integer> division) {
        this.division = division;
    }

    public int getScore() {
        return division.stream().reduce(0, Integer::sum);
    }
}
