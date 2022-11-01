package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean checkSubstring(List<String> name1, List<String> name2) {
        boolean result = false;
        for (int i = 0; i < name1.get(1).length() - 1; i++) {
            if (name2.get(1).contains(name1.get(1).substring(i, i + 2))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static List<List<String>> checkDup(List<List<String>> forms) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.size(); j++) {
                if (i == j)
                    continue;
                if (checkSubstring(forms.get(i), forms.get(j)))
                    if (!result.contains(forms.get(j)))
                        result.add(forms.get(j));
            }
        }

        return result;
    }
}
