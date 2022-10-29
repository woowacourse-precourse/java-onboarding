package onboarding.problem1.verifiable;

import java.util.List;

public class IsOddNumberWithFirstPage implements VerifiableRule {
    @Override
    public boolean validates(List<Integer> pageNumbers) {
        return pageNumbers.get(0) % 2 == 1;
    }
}
