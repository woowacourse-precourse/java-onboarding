package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> words = getEmailsByWord(forms);

        return answer;
    }

    private static List<String> getEmailsByWord(List<List<String>> forms) {

        List<String> list = new ArrayList<>();
        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                String word = form.get(1).substring(i, i + 2);
                list.add(word);
            }
        }
        return list;
    }
}
