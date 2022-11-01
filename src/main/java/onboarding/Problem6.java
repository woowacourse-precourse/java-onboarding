package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(List.of());

        // 크루 리스트 순차 탐색
        for (int idx1 = 0; idx1 < forms.size(); idx1++) {
            String email = forms.get(idx1).get(0);
            String nickname = forms.get(idx1).get(1);
            List<String> substrings = getSubstrFromNickname(nickname);

            // 비교하지 않은 크루 탐색
            for (int idx2 = idx1 + 1; idx2 < forms.size(); idx2++) {
                String otherEmail = forms.get(idx2).get(0);
                String otherNickname = forms.get(idx2).get(1);

                // 닉네임의 서브스트링 탐색
                for (String substring : substrings) {
                    // 다른 크루의 닉네임이 자신의 서브스트링을 포함할 경우
                    if (otherNickname.contains(substring)) {
                        answer.add(email);
                        answer.add(otherEmail);
                    }
                }
            }
        }

        // 결과 중복 제거
        answer = new ArrayList<>(new HashSet<>(answer));

        // 이메일 오름차순 정렬
        Collections.sort(answer);

        return answer;
    }

    public static List<String> getSubstrFromNickname(String nickname) {
        List<String> substrings = new ArrayList<>(List.of());
        for (int idx = 0; idx < nickname.length() - 1; idx++) {
            substrings.add(nickname.substring(idx, idx + 2));
        }
        return substrings;
    }
}
