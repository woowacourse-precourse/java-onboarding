package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = fillerEmail(forms);
        return result;
    }

    public static List<String> fillerEmail(List<List<String>> forms) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            if (forms.get(i).get(1).length() == 1)
                continue;
            for (int j = i + 1; j < forms.size(); j++) {
                if (compareNicknames(forms.get(i).get(1).toCharArray(), forms.get(j).get(1).toCharArray())) {
                    result.add(forms.get(i).get(0));
                    result.add(forms.get(j).get(0));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static boolean compareNicknames(char[] nick1, char[] nick2) {
        for (int i = 1; i < nick1.length; i++) {
            for (int j = 1; j < nick2.length; j++)
                if (nick1[i - 1] == nick2[j - 1] && nick1[i] == nick2[j])
                    return true;
        }
        return false;
    }
}
