package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Crews;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        final Crews crews = new Crews();
        forms.forEach(form -> {
            final Crew crew = Crew.create(form);
            crews.add(crew);
        });
        return crews.getEmails();
    }
}
