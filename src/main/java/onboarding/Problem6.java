package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static List<String> getNickNameList(List<List<String>> forms) {
        List<String> nicknames = new ArrayList<>();
        List<String> form;

        for (int i = 0; i < forms.size(); i++) {
            form = forms.get(i);
            nicknames.add(form.get(1));
        }

        return nicknames;
    }
}
