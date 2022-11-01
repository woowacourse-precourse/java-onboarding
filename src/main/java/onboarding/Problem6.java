package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int n = forms.size();

        Set<String> emails = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            email = email.substring(0, email.indexOf("@"));

            for (int a = 0; a < name.length()-1; a++) {
                String check = name.substring(a, a+2);
                for (int j = i+1; j < n; j++) {
                    String email2 = forms.get(j).get(0);
                    if (forms.get(j).get(1).contains(check)) {
                        emails.add(email);
                        emails.add(email2.substring(0, email2.indexOf("@")));
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>(emails);
        for (int i = 0; i < answer.size(); i++) {
            answer.set(i, answer.get(i) + "@email.com");
        }

        return answer;
    }
}
