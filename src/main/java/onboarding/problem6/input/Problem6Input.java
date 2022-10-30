package onboarding.problem6.input;

import onboarding.problem.ProblemInput;
import onboarding.problem6.domain.Crew;
import onboarding.problem6.domain.Email;
import onboarding.problem6.domain.Nickname;

import java.util.ArrayList;
import java.util.List;

public class Problem6Input implements ProblemInput {

    private final List<Crew> crews = new ArrayList<>();

    public Problem6Input(List<List<String>> forms) {
        for (List<String> form : forms) {
            Email email = new Email(form.get(0));
            Nickname nickname = new Nickname(form.get(1));
            crews.add(new Crew(email, nickname));
        }
    }

    public List<Crew> crews() {
        return crews;
    }

    @Override
    public boolean hasError() {
        return false;
    }
}
