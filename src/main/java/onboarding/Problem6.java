package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int length = forms.size();
        String[] emails = new String[length];
        String[] nicknames = new String[length];

        for (int i = 0; i < length; i++) {
            emails[i] = forms.get(i).get(0);
            nicknames[i] = forms.get(i).get(1);
        }

        Set<String> temp = new HashSet<>();

        for (int i = 0; i < length - 1; i++) {
            List<String> cut = new ArrayList<>();
            for (int j = 0; j < nicknames[i].length() - 2; j++) {
                cut.add(nicknames[i].substring(i, i + 2));
            }
            for (int j = i; j < length; j++) {
                for (String str : cut) {
                    if (nicknames[j].contains(str)) {
                        temp.add(emails[i]);
                        temp.add(emails[j]);
                    }
                }
            }

        }
        List<String> answer = new ArrayList<>(temp);
        Collections.sort(answer);
        return answer;
    }
}
