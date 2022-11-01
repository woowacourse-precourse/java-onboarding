package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> nicknamePartition = new HashMap<>();
        for (List<String> form : forms) {
            nicknamePartition.put(form.get(0), devideByTwo(form.get(1)));
        }

        Set<String> emails = new HashSet<>();
        Set<String> nickname = nicknamePartition.keySet();
        for (String n1 : nickname) {
            for (String n2 : nickname) {
                if (n1.equals(n2)) {
                    continue;
                }
                if (isDuplicate(nicknamePartition.get(n1), nicknamePartition.get(n2))) {
                    emails.add(n1);
                    emails.add(n2);
                }
            }
        }

        List<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);

        return answer;
    }

    private static List<String> devideByTwo(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            result.add(s.substring(i, i + 2));
        }
        return result;
    }

    private static boolean isDuplicate(List<String> s1, List<String> s2) {
        return s1.stream().anyMatch(s2::contains);
    }

}
