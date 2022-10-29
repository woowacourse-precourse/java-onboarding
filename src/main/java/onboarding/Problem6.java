package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean check(List<List<String>> forms, int idx) {
        for (int i = 0; i < forms.size(); i++) {
            if (idx == i) {
                continue;
            }

            String fivotName = forms.get(idx).get(1);
            String name = forms.get(i).get(1);

            for (int j = 0; j < fivotName.length() - 1; j++) {
                for (int k = 0; k < name.length() - 1; k++) {
                    if ((fivotName.charAt(j) == name.charAt(k)) && (fivotName.charAt(j + 1) == name.charAt(k + 1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
