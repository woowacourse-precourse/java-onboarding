package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> resultSet = new HashSet<>();

        boolean[] isSimilar = new boolean[forms.size()];

        for (int index = 0; index < forms.size(); index++) {
            if (!isSimilar[index]) {
                String nickname = forms.get(index).get(1);
                Set<String> patternsFromNickName = makePatternsFromNickName(nickname);

                for (int nextIndex = 0; nextIndex < forms.size(); nextIndex++) {

                    if (index == nextIndex || isSimilar[nextIndex])
                        continue;

                    String nextNickname = forms.get(nextIndex).get(1);
                    for (String pattern : patternsFromNickName) {
                        if (nextNickname.contains(pattern)) {
                            resultSet.add(forms.get(index).get(0));
                            resultSet.add(forms.get(nextIndex).get(0));
                            isSimilar[index] = true;
                            isSimilar[nextIndex] = true;
                        }
                    }
                }
            }
        }

        ArrayList<String> answer = new ArrayList<String>(resultSet);
        Collections.sort(answer);
        return answer;
    }

    public static Set<String> makePatternsFromNickName(String nickname) {
        Set<String> patterns = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String pattern = nickname.substring(i, i + 2);
            patterns.add(pattern);
        }
        patterns.add(nickname);

        return patterns;
    }
}
