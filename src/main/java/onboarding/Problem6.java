package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        test(forms);
        return answer;
    }

    private static void test(List<List<String>> forms) {
        String[] nicknames = new String[forms.size()];
        int idx = 0;
        for (List<String> i : forms) {
            nicknames[idx] = i.get(1);
            idx++;
        }
    }
}
