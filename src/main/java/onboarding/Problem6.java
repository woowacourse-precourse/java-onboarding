package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> result = new HashSet<>(); // 중복되는 이메일들 보관
        Map<String, String> subNameMap = new HashMap<>(); // 부분 닉네임과 그 주인의 이메일 보관

        for (int i = 0; i < forms.size(); i++) {
            String userEmail = forms.get(i).get(0);
            String userName = forms.get(i).get(1);

            // 닉네임에서 연속 두 글자씩 뽑아서 Map에 넣고, 이미 있다면 대신 중복되는 이메일들 목록에 양쪽을 보관한다.
            for (int j = 0; j < userName.length() - 1; j++) {
                String userSubName = userName.substring(j, j + 2);
                if (subNameMap.containsKey(userSubName)) {
                    result.add(subNameMap.get(userSubName));
                    result.add(userEmail);
                    continue;
                }

                subNameMap.put(userSubName, userEmail);
            }
        }
        answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }
}
