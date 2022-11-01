package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new HashSet<>();

        for (int start = 0; start < forms.size() - 1; start++) {
            for (int i = 2; i < forms.get(start).get(1).length(); i++) {
                for (int k = 0; k < forms.get(start).get(1).length(); k++) {
                    if ((k + i) < forms.get(start).get(1).length()) {
                        String checkName = forms.get(start).get(1).substring(k, k + i);
                        for (int confirm = start + 1; confirm < forms.size(); confirm++) {
                            if (checkName.length() <= forms.get(confirm).get(1).length()) {
                                if (forms.get(confirm).get(1).contains(checkName)) {
                                    result.add(forms.get(confirm).get(0));
                                    result.add(forms.get(start).get(0));
                                }
                            }
                        }
                    } else {
                        break;
                    }

                }
            }
        }
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }
}
