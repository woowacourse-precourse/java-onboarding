package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static List<String> confirm;
    private static List<String> duplicatedNicknames;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        initSystem(forms);
        return answer;
    }

    private static void initSystem(List<List<String>> forms) {
        confirm = new ArrayList<>();
        confirm.add(forms.get(0).get(1));
        duplicatedNicknames = new ArrayList<>();
    }
}
