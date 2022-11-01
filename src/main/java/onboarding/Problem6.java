package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> resultSet = new HashSet<>();
        Map<String, String> subNicknameMap = new HashMap<>();

        for (List<String> form :
                forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String subNickname = nickname.substring(i, i + 2);
                if (subNicknameMap.containsKey(subNickname) && !email.equals(subNicknameMap.get(subNickname))) {
                    resultSet.add(email);
                    resultSet.add(subNicknameMap.get(subNickname));
                } else {
                    subNicknameMap.put(nickname.substring(i, i + 2), email);
                }
            }
        }

        return resultSet.stream().sorted().collect(Collectors.toList());
    }
}
