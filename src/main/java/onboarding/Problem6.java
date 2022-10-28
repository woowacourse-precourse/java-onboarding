package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = compareAllCrews(forms);
        return answer;
    }

    private static List<String> compareAllCrews(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                emailSet.addAll(getOverlapCrewsEmail(forms.get(i), forms.get(j)));
            }
        }

        List<String> emailList = new ArrayList<>(emailSet);
        Collections.sort(emailList);

        return emailList;
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
