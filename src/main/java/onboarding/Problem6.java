package onboarding;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> emails = new HashSet<>();
        /*두 글자 이상 문자 분리, 중복 있을 시 중복된 닉네임의 이메일 저장*/
        for (List<String> form : forms) {
            divideTwoWord(map, form);
        }
        /*이메일 중복 제거*/
        for (Set<String> tmpEmails : map.values()) {
            overlapEmailRemove(emails, tmpEmails);
        }

        answer = Lists.newArrayList(emails);
        answer = answer.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        return answer;
    }

    private static void overlapEmailRemove(Set<String> emails, Set<String> tmpEmails) {
        if (tmpEmails.size() <= 1)
            return;
        for (String email : tmpEmails) {
            emails.add(email);
        }
    }

    private static void divideTwoWord(Map<String, Set<String>> map, List<String> form) {
        String email = form.get(0);
        String nickname = form.get(1);
        for (int i = 0; i < nickname.length() - 1; ++i) {
            String twoWord = nickname.substring(i, i+2);
            if (map.containsKey(twoWord)) {
                map.get(twoWord).add(email);
                continue;
            }
            map.put(twoWord, new HashSet<>());
            map.get(twoWord).add(email);
        }
    }
}
