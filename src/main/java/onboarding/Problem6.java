package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Set<String> patterns = new HashSet<>();
        Set<String> Emails = new HashSet<>();

        for (List form : forms) {
            String nick = (String) form.get(1);
            String email = (String) form.get(0);

            checkSub(nick, email, patterns, Emails);
        }

        checkSub(forms.get(0).get(1), forms.get(0).get(0), patterns, Emails);

        List<String> list = new ArrayList<>(Emails);
        list.sort(Comparator.naturalOrder());

        answer = list;

        return answer;
    }

    private static void checkSub(String nick, String email, Set patterns, Set Emails) {
        for (int i = 0; i < nick.length(); i++) {
            for (int j = i+2; j <= nick.length(); j++) {
                String sub = nick.substring(i,j);

                if (patterns.contains(sub)) {
                    Emails.add(email);
                } else {
                    patterns.add(sub);
                }
            }
        }
    }
}
