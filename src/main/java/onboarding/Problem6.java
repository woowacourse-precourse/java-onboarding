package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Map<String, String> checkDuplicateNicknameMap = new HashMap<>();
        Set<String> resultEmailSet = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (int i = 1; i < nickname.length(); i++) {
                String s = nickname.substring(i - 1, i + 1);

                if (checkDuplicateNicknameMap.containsKey(s)) {
                    resultEmailSet.add(email);
                    resultEmailSet.add(checkDuplicateNicknameMap.get(s));
                }
                checkDuplicateNicknameMap.put(s, email);

            }
        }

        answer.addAll(resultEmailSet);
        Collections.sort(answer);
        return answer;
    }



}
