package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        Set<String> emails = new HashSet<>();
        for(int i = 0; i < forms.size() - 1; i++) {
            List<String> form = forms.get(i);
            for(int j = i+1; j < forms.size(); j++) {
                List<String> compareWithForm = forms.get(j);
                String name1 = form.get(1);
                String name2 = compareWithForm.get(1);

                if(isDuplicated(name1, name2)) {
                    emails.add(form.get(0));
                    emails.add(compareWithForm.get(0));
                }
            }
        }
        answer = new ArrayList<>(emails);
        return answer;
    }

    public static boolean isDuplicated(String name1, String name2) {
        for(int i = 0; i < name1.length() - 1; i++) {
            String tmp = name1.substring(i, i+2);
            if(name2.contains(tmp)) return true;
        }
        return false;
    }
}
