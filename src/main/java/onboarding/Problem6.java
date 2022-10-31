package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean isDuplicated(String n1, String n2) {
        for (int i = 0; i < n1.length() - 1; i++) {
            for (int j = 0; j < n2.length() - 1; j++) {
                if (n1.charAt(i) != n2.charAt(j)) {
                    continue;
                }
                if (n1.charAt(i + 1) == n2.charAt(j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean[] checkDuplicated(List<List<String>> forms) {
        boolean[] flags = new boolean[forms.size()];
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                String nickname1 = forms.get(i).get(1);
                String nickname2 = forms.get(j).get(1);

                if (isDuplicated(nickname1, nickname2)) {
                    flags[i] = true;
                    flags[j] = true;
                }
            }
        }
        return flags;
    }
}