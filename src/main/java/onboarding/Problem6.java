package onboarding;

import java.util.*;

public class Problem6 {

    private static final int EMAIL_IDX = 0;
    private static final int NICKNAME_IDX = 1;

    public static List<String> solution(List<List<String>> forms) {
        Set<String> resultSet = new HashSet<>();

        boolean[] isSimilar = new boolean[forms.size()];

        for (int index = 0; index < forms.size(); index++) {
            if (!isSimilar[index]) {
                String nickname = getNickname(forms, index);
                Set<String> patternsFromNickName = makePatternsFromNickName(nickname);

                for (int nextIndex = 0; nextIndex < forms.size(); nextIndex++) {

                    if (index == nextIndex || isSimilar[nextIndex])
                        continue;

                    String nextNickname = getNickname(forms, nextIndex);
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

    public static String getNickname(List<List<String>> forms, Integer index) {
        return forms.get(index).get(NICKNAME_IDX);
    }
}
