package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> repeatCheckMap = new HashMap<>();

        // 사용자 닉네임 확인
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            // 중복 확인을 위해 HashMap 에 저장
            for (int i = 0; i < nickname.length() - 1; i++) {
                String part = nickname.substring(i, i + 2);
                if (!repeatCheckMap.containsKey(part)) {
                    repeatCheckMap.put(part, new ArrayList<>());
                }
                repeatCheckMap.get(part).add(email);
            }
        }

        // 닉네임 일부가 중복 되는 사용자 이메일 확인
        Set<String> wrongUserEmail = new HashSet<>();
        for (List<String> repeat : repeatCheckMap.values()) {
            if (repeat.size() > 1) {
                for (String email : repeat) {
                    wrongUserEmail.add(email);
                }
            }
        }

        // 원하는 형식에 맞춰 반환
        return wrongUserEmail.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
