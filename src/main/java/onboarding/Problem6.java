package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        ArrayList<String> word = new ArrayList<>();
        Set<String> duplicateWord = new HashSet<>();

        for (List<String> form : forms) {
            for (int i = 1; i < form.get(1).length(); i++) {
                word.add(form.get(1).substring(i - 1, i + 1));
            }
        }

        for (String str : word) {
            if (word.indexOf(str) != word.lastIndexOf(str)) {
                duplicateWord.add(str);
            }
        }

        return answer;
    }
}
