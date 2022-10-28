package onboarding;

import java.util.ArrayList;
import java.util.List;

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
}
