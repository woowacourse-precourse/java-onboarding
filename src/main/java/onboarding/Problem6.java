package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Set<String> mails = new HashSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                String name1 = forms.get(i).get(1);
                String name2 = forms.get(j).get(1);
                if (isDuplicate(name1, name2)) {
                    mails.add(forms.get(i).get(0));
                    mails.add(forms.get(j).get(0));
                }
            }
        }

        List<String> answer = new ArrayList<>(mails);
        return answer;
    }

    public static boolean isDuplicate(String name1, String name2) {

        for (int s = 0; s < name1.length() - 1; s++) {
            for (int e = s + 2; e <= name1.length(); e++) {
                String subStr = name1.substring(s, e);
                if (name2.contains(subStr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
