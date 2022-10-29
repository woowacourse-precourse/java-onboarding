package onboarding.problem1;

import onboarding.problem1.gradable.Gradable;

import java.util.ArrayList;
import java.util.List;

public class Grader {
    private final List<Gradable> rules = new ArrayList<>();

    public void addRule(Gradable rule) {
        rules.add(rule);
    }

    public int grade(List<Integer> pageNumbers) {
        return rules.stream()
                .mapToInt(rule -> rule.grade(pageNumbers))
                .max()
                .orElse(0);
    }
}
