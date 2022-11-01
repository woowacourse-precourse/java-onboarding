package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Crews;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Crews crews = new Crews();

        for (List<String> form : forms) {
            Crew crew = new Crew(form.get(0), form.get(1));
            crews.add(crew);
        }

        return crews.getEmailsByDuplicateNickname();
    }
}
