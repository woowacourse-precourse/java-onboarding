package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> name = new ArrayList<>(forms.size());

        for (int i = 0; i < name.size(); i++) {
            name.add(i, forms.get(i).get(1));
        }
        return answer;
    }
}
