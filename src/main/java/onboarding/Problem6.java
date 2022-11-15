package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Problem6 {

    private static Map<String, Integer> duplicateCount = new ConcurrentHashMap<>();
    private static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        countToken(forms);
        removeNotDuplicateTokens();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            makeAnswer(email, nickname);
        }

        Collections.sort(answer);
        return answer;
    }

    public static void countToken(List<List<String>> forms) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            extractDuplicate(nickname);
        }
    }

    public static void extractDuplicate(String nickname) {
        for (int index = 0; index < nickname.length() - 1; index++) {
            String token = nickname.substring(index, index + 2);

            if (duplicateCount.containsKey(token)) {
                int count = duplicateCount.get(token);
                duplicateCount.put(token, count+1);
                continue;
            }

            duplicateCount.put(token, 1);
        }
    }

    public static void removeNotDuplicateTokens() {
        duplicateCount.forEach((token, count) -> {
            if (isNotDuplicate(count)) {
                duplicateCount.remove(token);
            }
        });
    }

    public static boolean isNotDuplicate(int count) {
        return (count == 1);
    }

    public static void makeAnswer(String email, String nickname) {
        duplicateCount.forEach((token, count) -> {
            if (isContainsToken(nickname, token) && !isAnswerContainsEmail(email)) {
                answer.add(email);
            }
        });
    }

    public static boolean isContainsToken(String nickname, String token) {
        return nickname.contains(token);
    }

    public static boolean isAnswerContainsEmail(String email) {
        return answer.contains(email);
    }
}


