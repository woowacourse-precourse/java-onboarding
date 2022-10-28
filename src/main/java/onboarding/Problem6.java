package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<Integer> idx = new HashSet<>();

        // 연속된 중복 문자 체크
        for (int i = 0; i < forms.size() - 1; i++) {
            String nickname = forms.get(i).get(1);
            // 닉네임 1자인 경우 (예외)
            if (nickname.length() <= 1) {
                continue;
            }

            // 닉네임 2자 이상인 경우
            StringBuilder sb = new StringBuilder(nickname);
            for (int j = 0; j < sb.length() - 1; j++) {
                String subStr = sb.substring(j, j + 2);
                for (int k = i + 1; k < forms.size(); k++) {
                    String checkName = forms.get(k).get(1);
                    if (checkName.contains(subStr)) {
                        idx.add(i);
                        idx.add(k);
                    }
                }
            }

        }

        List<String> answer = new ArrayList<>();
        for (Integer index : idx) {
            String email = forms.get(index).get(0);
            answer.add(email);
        }
        Collections.sort(answer);
        return answer;
    }
}
