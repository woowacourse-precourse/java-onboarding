package onboarding.problem1.verifiable;

import java.util.List;

public class HasInRangePageNumbers implements VerifiableRule {
    private final int lowerLimit;
    private final int upperLimit;

    public HasInRangePageNumbers(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    @Override
    public boolean validates(List<Integer> pageNumbers) {
        return pageNumbers.stream()
                .allMatch(pageNumber -> (lowerLimit <=pageNumber) && (pageNumber <= upperLimit));
    }
}
