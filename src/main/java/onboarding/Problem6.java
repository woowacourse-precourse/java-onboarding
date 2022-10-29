package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Email;
import onboarding.problem6.Nickname;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (forms.size() < 1 || forms.size() > 10000) {
            return Collections.emptyList();
        }

        List<Crew> crews = forms.stream()
                .map(Crew::new)
                .collect(Collectors.toList());

        return answer;
    }
}
