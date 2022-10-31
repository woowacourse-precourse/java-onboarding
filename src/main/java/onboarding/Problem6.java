package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	HashSet<String> overlapEmail = new HashSet<>();
        HashMap<String, Integer> everyName = new HashMap<>();
        List<String> answer = null;

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            if (name.length() == 1) continue;

            for (int j = 0; j < name.length() - 1; j++) {
                String twoLetter = name.substring(j, j + 2);

                if (everyName.containsKey(twoLetter)) {
                    String email1 = forms.get(i).get(0);
                    String email2 = forms.get(everyName.get(twoLetter)).get(0);
                    overlapEmail.add(email1);
                    overlapEmail.add(email2);
                    continue;
                }

                everyName.put(twoLetter, i);
            }

            answer = new ArrayList<>(overlapEmail);
            Collections.sort(answer);


        }
        return answer;
    }
}
