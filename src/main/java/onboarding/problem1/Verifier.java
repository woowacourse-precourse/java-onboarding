package onboarding.problem1;

import onboarding.problem1.verifiable.VerifiableRule;

import java.util.ArrayList;
import java.util.List;

public class Verifier {
    private final List<VerifiableRule> rules = new ArrayList<>();

    public void addRule(VerifiableRule rule) {
        rules.add(rule);
    }

    public boolean validates(List<Integer> pageNumbers) {
        return rules.stream()
                .allMatch(rule -> rule.validates(pageNumbers));
    }
}
