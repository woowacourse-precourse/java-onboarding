package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> set = new HashSet<>();

        HashMap<String, Integer> hm = new HashMap<>();

        List<String> answer = null;
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            if (name.length() == 1) continue;

            for (int j = 0; j < name.length() - 1; j++) {
                String two_letter = name.substring(j, j + 2);

                if (hm.containsKey(two_letter)) {
                    String email1 = forms.get(i).get(0);
                    String email2 = forms.get(hm.get(two_letter)).get(0);
                    set.add(email1);
                    set.add(email2);
                    continue;
                }

                hm.put(two_letter, i);
            }

            answer = new ArrayList<>(set);
            Collections.sort(answer);


        }
        return answer;
    }
}
