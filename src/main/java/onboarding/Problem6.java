package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nick = forms.get(i).get(1);
            boolean duplicated = false;

            for (int j = i + 1; j < forms.size() - 1; j++) {
                if (isDuplicated(nick, forms.get(j).get(1))) {
                    if (!answer.contains(forms.get(j).get(0))) {
                        answer.add(forms.get(j).get(0));
                        duplicated = true;
                    }
                }
            }
            if (duplicated) {
                if (!answer.contains(email)) {
                    answer.add(email);
                }
            }
        }
        if (answer == null) {
            return Collections.emptyList();
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    public static boolean isDuplicated(String nick1, String nick2) {
        for (int i = 0; i < nick1.length() - 1; i++) {
            for (int j = 0; j < nick2.length() - 1; j++) {
                if (nick1.charAt(i) == nick2.charAt(j) && i < nick1.length() - 1) {
                    if (nick1.charAt(i + 1) == nick2.charAt(j + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
