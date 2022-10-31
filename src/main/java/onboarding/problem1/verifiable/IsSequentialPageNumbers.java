package onboarding.problem1.verifiable;

import java.util.List;

public class IsSequentialPageNumbers implements VerifiableRule {
    private final int sequentialPageNumber;

    public IsSequentialPageNumbers(int sequentialPageNumber) {
        this.sequentialPageNumber = sequentialPageNumber;
    }

    @Override
    public boolean validates(List<Integer> pageNumbers) {
        return pageNumbers.get(1) - pageNumbers.get(0) == sequentialPageNumber;
    }
}
