package onboarding;

import onboarding.Prombem6.Crew;
import onboarding.Prombem6.Email;
import onboarding.Prombem6.NicknameDuplicateFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) throws Exception {
        validate(forms);

        Map<String, Crew> userStore = new HashMap<>();
        List<Crew> crewList = new ArrayList<>();
        for (List<String> form : forms) {
            Crew crew = new Crew(form);
            if (userStore.containsKey(crew.getEmail().getValue())) {
                throw new Exception("이메일이 중복되었습니다");
            }
            userStore.put(crew.getEmail().getValue(), crew);
            crewList.add(crew);
        }
        List<Email> emailsDuplicated = NicknameDuplicateFinder.find(crewList);
        List<String> answer = emailsDuplicated.stream().map(email -> (String) email.format()).sorted().collect(Collectors.toList());
        return answer;
    }

    private static void validate(List<List<String>> forms) throws Exception {
        if (forms.size() < 1 || forms.size() > 10_000) {
            throw new Exception("크루들의 숫자는 1이상 10000이하만 가능합니다");
        }

    }
}
