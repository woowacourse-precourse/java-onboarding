package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Email;
import onboarding.problem6.NicknameDuplicateFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        validate(forms);

        Map<String, Crew> userStore = new HashMap<>();
        List<Crew> crewList = new ArrayList<>();
        for (List<String> form : forms) {
            Crew crew = new Crew(form);
            if (userStore.containsKey(crew.getEmail().getValue())) {
                System.out.println("이메일이 중복되었습니다");
            }
            userStore.put(crew.getEmail().getValue(), crew);
            crewList.add(crew);
        }
        List<Email> emailsDuplicated = NicknameDuplicateFinder.find(crewList);
        List<String> answer = emailsDuplicated.stream().map(email -> (String) email.format()).sorted().collect(Collectors.toList());
        return answer;
    }

    private static void validate(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10_000) {
            System.out.println("크루들의 숫자는 1이상 10000이하만 가능합니다");
        }

    }
}
