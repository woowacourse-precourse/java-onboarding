package onboarding.problem1.verifiable;

import java.util.List;

public class IsEvenNumberWithSecondPage implements VerifiableRule {
    @Override
    public boolean validates(List<Integer> pageNumbers) {
        return pageNumbers.get(pageNumbers.size() - 1) % 2 == 0;
    }
}
