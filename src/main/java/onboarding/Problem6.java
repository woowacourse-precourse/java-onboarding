package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        ArrayList<String> word = new ArrayList<>();

        for (List<String> form : forms) {
            for (int i = 1; i < form.get(1).length(); i++) {
                word.add(form.get(1).substring(i - 1, i + 1));
            }
        }

        return answer;
    }
}
