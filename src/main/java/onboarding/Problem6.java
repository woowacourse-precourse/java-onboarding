package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Set<String> email = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length()-1; j++) {
                if (!map.containsKey(forms.get(i).get(1).substring(j, j + 2))) {
                    map.put(forms.get(i).get(1).substring(j, j + 2), forms.get(i).get(0));
                } else {
                    for (String overlap: map.keySet()
                    ) {
                        if (overlap.equals(forms.get(i).get(1).substring(j, j + 2))) {
                            email.add(map.get(overlap));
                            email.add(forms.get(i).get(0));
                        }
                    } // inner for
                } // else
            } //inner for
        } //outer for

        for (String mail : email){
            answer.add(mail);
        }
        Collections.sort(answer);
        return answer;
    }
}
