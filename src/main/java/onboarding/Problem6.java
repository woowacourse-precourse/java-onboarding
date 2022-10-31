package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList();

        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> list : forms) {
            String email = list.get(0);
            String nickname = list.get(1);

            // 닉네임중 2글자를 추려낸 후, 해당 글자가 누구로부터 나왔는지 기록한다.
            for (int i = 0; i < nickname.length() - 1; i++) {
                String substrName = nickname.substring(i, i + 2);
                map.computeIfAbsent(substrName, k -> new HashSet()).add(email);
            }
        }

        /**
         * 어떤 글자(2개로 구성된)에 기록된 사용자가 2명 이상이면 이들은 해당 단어로 인해 비슷한 닉네임을 사용하는 크루이다.
         * 단, 한명의 사용자가 어떤 글자(2개로 구성된)를 2번 이상 사용하는 경우는 아니다.
         * 예) 제이제이, 자바자바
         */
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            Set<String> set = entry.getValue();
            if (set.size() >= 2) {
                answer.addAll(set);
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
