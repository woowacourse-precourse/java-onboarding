package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<List<String>> makeSubstringWithTwoWords(List<List<String>> forms) {
        List<List<String>> substringList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> substrings = new ArrayList<>();
            String Nickname = forms.get(i).get(1);
            for (int j = 0; j < Nickname.length() - 1; j++) {
                String substring = Nickname.substring(j, j + 2);
                substrings.add(substring);
            }
            substringList.add(substrings);
        }

        return substringList;
    }

    private static Set<String> makeSubstringSet(List<List<String>> substringList) {
        Set<String> substringSet = new HashSet<>();

        for (int i = 0; i < substringList.size(); i++) {
            for (int j = 0; j < substringList.get(i).size(); j++) {
                substringSet.add(substringList.get(i).get(j));
            }
        }

        return substringSet;
    }
}
