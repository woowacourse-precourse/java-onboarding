package onboarding.problem1.gradable;

import java.util.List;

@FunctionalInterface
public interface Gradable {
    int grade(List<Integer> pageNumbers);
}
