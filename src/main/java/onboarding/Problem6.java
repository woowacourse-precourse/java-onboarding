package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // List<String> answer = List.of("");
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        // 이메일과 닉네임을 각각 받아온다
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);

            // 닉네임을 비교하기 위해 checkName을 만든다
            for (int j = 0; j < name.length() - 1; j++) {
                String checkName = name.substring(j, j + 2);

                // 중복되는 닉네임과 email 형식을 지켰는지 확인
                if (map.containsKey(checkName) && !map.get(checkName).equals(email)) {
                    answer.add(email);

                    if (!answer.contains(map.get(checkName))) {
                        answer.add(map.get(checkName));
                    }

                    break;
                }
                else {
                    map.put(checkName, email);
                }
            }
        }
        // 이메일 정렬
        Collections.sort(answer);
        return answer;
    }
}
