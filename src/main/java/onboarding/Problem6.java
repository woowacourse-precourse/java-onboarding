package onboarding;

import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        forms = new ArrayList<>(forms);
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> countDuplication = new HashMap<>();

        for(List<String> form: forms){
            countChunk(countDuplication, form);
        }

        for (String chunk : countDuplication.keySet()) {
            if (countDuplication.get(chunk) > 1) {
                getEmailOfDuplicatedNickname(forms, answer, chunk);
            }
        }

        answer = getEmails(answer);

        return answer;
    }

    private static void countChunk(HashMap<String, Integer> countDuplication, List<String> form) {
        String nickname = form.get(1);

        for (int i = 0; i < nickname.length() - 1; i++) {
            String chunk = nickname.substring(i, i + 2);
            countDuplication.merge(chunk, 1, Integer::sum);
        }
    }

    private static void getEmailOfDuplicatedNickname(List<List<String>> forms, List<String> answer, String chunk) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (nickname.contains(chunk)) {
                answer.add(email);
            }
        }
    }

    private static List<String> getEmails(List<String> answer) {
        answer.sort(Comparator.naturalOrder());
        answer = answer.stream().distinct().collect(Collectors.toList());
        return answer;
    }
}
