package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            emails.add(form.get(0));
            nicknames.add(form.get(1));
        }

        return answer;
    }
}
