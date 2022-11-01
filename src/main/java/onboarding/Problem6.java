package onboarding;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Problem6 {

    private static Map<String, Integer> duplicateCount = new ConcurrentHashMap<>();
    private static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        countToken(forms);

        return answer;
    }

    public static void countToken(List<List<String>> forms) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            extractDuplicate(nickname);
        }
    }
    public static void extractDuplicate(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String token = nickname.substring(i, i + 2);

            if (duplicateCount.containsKey(token)) {
                int count = duplicateCount.get(token);
                duplicateCount.put(token, count+1);
            } else {
                duplicateCount.put(token, 1);
            }
        }
    }
}


