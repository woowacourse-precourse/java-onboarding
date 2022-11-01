package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 기능 목록
 * 1. forms를 순회하는 기능
 * 2. 닉네임을 2개씩 자르는 기능
 * 3. 자른 닉네임이 다른 크루의 닉네임에 포함되면 answer에 추가하는 기능
 * 4. answer(이메일)의 중복을 제거하는 기능
 * 5. answer(이메일)을 정렬하는 기능
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);
            String nickname = form.get(1);
            addContainNickname(forms, answer, i, nickname);
        }

        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);

        return answer;
    }

    private static void addContainNickname(List<List<String>> forms, List<String> answer, int index, String nickname) {
        for (int j = 0; j < nickname.length() - 1; j++) {
            String subNickname = nickname.substring(j, j + 2);

            for (int k = index + 1; k < forms.size(); k++) {
                if (forms.get(k).get(1).contains(subNickname)) {
                    answer.add(forms.get(k).get(0)); //이메일 저장
                    answer.add(forms.get(index).get(0));
                }
            }
        }
    }
}
