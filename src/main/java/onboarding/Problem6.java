package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Set<String> patterns = new HashSet<>();
        Set<String> Emails = new HashSet<>();
        Map<String, Integer> AllPatterns = new HashMap<>();

        for (List form : forms) {
            String nick = (String) form.get(1);

            PickPatterns(nick, patterns, AllPatterns);
        }

        Iterator<Map.Entry<String, Integer>> itr = AllPatterns.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            if (entry.getValue() > 1) {
                patterns.add(entry.getKey());
            }
        }

        for (List form : forms) {
            String nick = (String) form.get(1);
            String email = (String) form.get(0);

            checkSub(nick, email ,patterns, Emails);
        }

        List<String> list = new ArrayList<>(Emails);
        list.sort(Comparator.naturalOrder());

        answer = list;

        return answer;
    }

    private static void PickPatterns(String nick, Set patterns, Map<String, Integer> AllPatterns) {
        for (int i = 0; i < nick.length(); i++) {
            for (int j = i+2; j <= nick.length(); j++) {
                String sub = nick.substring(i,j);

                AllPatterns.computeIfPresent(sub, (k,v) -> v + 1);
                AllPatterns.computeIfAbsent(sub, v -> 1);
            }
        }
    }

    private static void checkSub(String nick, String email, Set patterns, Set Emails) {
        for (int i = 0; i < nick.length(); i++) {
            for (int j = i+2; j <= nick.length(); j++) {
                String sub = nick.substring(i,j);

                if (patterns.contains(sub)) {
                    Emails.add(email);
                }
            }
        }
    }
}
