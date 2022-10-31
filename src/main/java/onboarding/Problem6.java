package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> twoWords = getTwoWords(forms);
        Set<String> duplicatedWords = findDuplicatedWords(twoWords);

        return answer;
    }

    public static List<String> getTwoWords(List<List<String>> forms) {
        List<String> twoWords = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);

            if (nickname.length() == 1) continue;

            for (int j = 0; j < nickname.length() - 1; j++) {
                twoWords.add(nickname.substring(j, j + 2));
            }
        }

        return twoWords;
    }

    public static Set<String> findDuplicatedWords(List<String> twoWords) {
        Set<String> duplicatedWords = new HashSet<>();

        for (String str : twoWords) {
            if (twoWords.indexOf(str) != twoWords.lastIndexOf(str)) duplicatedWords.add(str);
        }

        return duplicatedWords;
    }
}
