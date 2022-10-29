package onboarding.problem1.verifiable;

import java.util.List;

@FunctionalInterface
public interface VerifiableRule {
    boolean validates(List<Integer> pageNumbers);
}
