package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> emailSet = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                emailSet.addAll(getOverlapCrewsEmail(forms.get(i), forms.get(j)));
            }
        }

        answer = new ArrayList<>(emailSet);
        Collections.sort(answer);

        return answer;
    }

    private static Set<String> getOverlapCrewsEmail(List<String> crew, List<String> comparisonCrew) {
        Set<String> emailSet = new HashSet<>();
        String nickname = crew.get(1);
        String comparisonNickname = comparisonCrew.get(1);

        for (int i = 1; i < nickname.length(); i++) {
            String tokenNickname = nickname.substring(i - 1, i + 1);
            if (comparisonNickname.contains(tokenNickname)) {
                emailSet.add(crew.get(0));
                emailSet.add(comparisonCrew.get(0));
                break;
            }
        }

        return emailSet;
    }
}
