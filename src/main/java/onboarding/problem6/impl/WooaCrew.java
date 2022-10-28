package onboarding.problem6.impl;

import onboarding.problem6.Crew;
import onboarding.problem6.CrewValidator;

import java.util.List;

public class WooaCrew implements Crew {

    private final List<String> data;

    public WooaCrew(List<String> data, CrewValidator validator) {
        if (validator.isValid(data)) {
            this.data = data;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    @Override
    public List<String> get() {
        return data;
    }
}
