package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String duplicateNick = nickname.substring(i, i + 2);
                if (map.containsKey(duplicateNick)) { // 중복닉네임이 포함된
                    answer.add(email);
                    if (!answer.contains(map.get(duplicateNick))) { // answer에서 email 중복됐던 이메일이 없다면
                        answer.add(map.get(duplicateNick)); // email 추가!
                    }
                    break;
                }
                map.put(duplicateNick, email);
            }

        }
        return answer;

    }
}
