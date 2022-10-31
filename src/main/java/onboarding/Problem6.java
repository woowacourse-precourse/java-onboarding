package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String str = forms.get(i).get(1);
            for (int j = 0; j < str.length() - 1; j++) {
                String s = str.substring(j, j + 2);
                if (find_nickname(forms, s, i) && !answer.contains(forms.get(i).get(0))) {
                    answer.add(forms.get(i).get(0));
                    break;
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    public static boolean find_nickname(List<List<String>> form, String s, int index) {
        for (int i = 0; i < form.size(); i++) {
            if (i == index) {
                continue;
            }
            if (form.get(i).get(1).contains(s)) {
                return true;
            }
        }
        return false;
    }


}
