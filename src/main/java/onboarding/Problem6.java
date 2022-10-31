package onboarding;

import java.util.List;

public class Problem6 {
    public static boolean containsSameLetterConsecutively(String name1, String name2) {
        for (int i = 0; i + 1 < name1.length(); i++) {
            for (int j = 0; j  + 1 < name2.length(); j++) {
                if (name1.charAt(i) != name2.charAt(j)) continue;
                if (name1.charAt(i + 1) != name2.charAt(j + 1)) continue;
                return true;
            }
        }

        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        boolean addToAnswer[] = new boolean[forms.size()];

        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                String name1 = forms.get(i).get(1);
                String name2 = forms.get(j).get(1);
                if (containsSameLetterConsecutively(name1, name2)) {
                    addToAnswer[i] = true;
                    addToAnswer[j] = true;
                }
            }
        }

        List<String> answer = List.of("answer");
        return answer;
    }
}
