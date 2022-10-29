package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
1. 형식 체크하기
2. 문자열 토큰 얻기
3. 중복 확인하기
4. 중복이라면 이메일 추가하기
5. 정렬하기
 */

public class Problem6 {

    private static boolean isValidEmail(String email) {
        if (email.matches(".*@email.com") && 10 < email.length() && email.length() < 20)
            return true;
        return false;
    }

    private static boolean isValidName(String name) {
        if (name.matches("^[가-힣]*$") && 0 < name.length() && name.length() < 20)
            return true;
        return false;
    }

    private static Map<String, String> getInvaliFormdMap(List<List<String>> forms) {
        Map<String, String> invalidFormMap = new HashMap<>();
        for (List<String> form : forms) {
            if (!isValidEmail(form.get(0)) && !isValidName(form.get(1))) {
                invalidFormMap.put(form.get(0), form.get(1));
            }
        }
        return invalidFormMap;
    }

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
        List<String> answer = new ArrayList();
        Map<String, String> invalidFormMap = getInvaliFormdMap(forms);
        Map<String, Integer> nameTokenMap = getNameTokenMap(forms);
        List<String> duplicationEmails = getDuplicationEmails(forms, nameTokenMap);
        System.out.println(duplicationEmails);
        answer = duplicationEmails.stream()
                .sorted()
                .collect(Collectors.toList());
        return answer;
    }
}
