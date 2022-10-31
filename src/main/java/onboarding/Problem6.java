package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
1. 문자열 토큰 얻기
2. 중복이라면 이메일 추가하기
3. 정렬하기
 */

public class Problem6 {

    private static Map<String, Integer> getNameTokenMap(List<List<String>> forms) {
        Map<String, Integer> nameTokenMap = new HashMap<>();
        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i ++) {
                String token = form.get(1).substring(i, i + 2);
                nameTokenMap.put(token, nameTokenMap.getOrDefault(token, 0) + 1);
            }
        }
        nameTokenMap.entrySet().removeIf(entry -> entry.getValue() == 1);
        return nameTokenMap;
    }

    private static List<String> getDuplicationEmails(List<List<String>> forms, Map<String, Integer> nameTokenMap) {
        List<String> duplicationEmails = new ArrayList<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);
            for (String token : nameTokenMap.keySet()) {
                if (name.contains(token)) {
                    duplicationEmails.add(email);
                }
            }
        }
        return duplicationEmails;
    }

    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> nameTokenMap = getNameTokenMap(forms);
        List<String> duplicationEmails = getDuplicationEmails(forms, nameTokenMap);
        List<String> answer = duplicationEmails.stream()
                .sorted()
                .collect(Collectors.toList());
        return answer;
    }
}
