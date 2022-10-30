package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).size(); j++) {
                System.out.println(forms.get(i).get(j));
            }
        }
        return answer;
    }
}
