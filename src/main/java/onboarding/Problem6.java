package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> m = new HashMap<String, Integer>();

        for (List<String> s : forms) {
            String curName = s.get(1);
            registerName(curName, m);
        }

        m.forEach((key, value) -> {
            System.out.println("name : " + key + " , " + "count + " + value);
        });

        for (List<String> s : forms) {
            String curEmail = s.get(0);
            String curName = s.get(1);
            registerEmail(curEmail, curName, m, answer);
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    private static void registerEmail(String curEmail, String curName, HashMap<String, Integer> m, List<String> answer) {
        for (int i = 0; i + 1 < curName.length(); i++) {
            String tmp = curName.substring(i, i + 2);
            if (m.containsKey(tmp) && m.get(tmp) >= 2) {
                answer.add(curEmail);
                return;
            }
        }
    }

    private static void registerName(String curName, HashMap<String, Integer> m) {
        for (int i = 0; i + 1< curName.length(); i++) {
            String tmp = curName.substring(i, i + 2);
            if (!m.containsKey(tmp)) {
                m.put(tmp, 1);
            }
            else {
                int curCount = m.get(tmp);
                m.put(tmp, curCount + 1);
            }
        }

    }
}
