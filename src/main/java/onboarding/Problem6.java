package onboarding;

import java.util.ArrayList;
import java.util.List;

/* 기능 목록
 * 두 이름이 중복인지 검사하는 기능
 * 중복된 사용자의 이메일을 업데이트 기능
 * */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            updateAnswer(answer, forms, i);
        }

        answer.sort(String.CASE_INSENSITIVE_ORDER);

        return answer;
    }

    /**
     * 두 이름을 비교하여 중복이 있을 경우 true를 반환합니다.
     *
     * @param name1 비교할 이름1
     * @param name2 비교할 이름2
     * @return 두 이름이 두 글자 이상 연속일 경우 true, 그렇지 않을 경우 false 반환
     */
    static boolean isDuplicate(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            for (int j = 0; j < name2.length() - 1; j++) {
                if (name1.substring(i, i + 2).equals(name2.substring(j, j + 2))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * idx번째 크루원과 중복되는 크루원의 email을 answer에 업데이트합니다.
     *
     * @param answer 업데이트될 리스트
     * @param forms  전체 크루원 정보
     * @param idx    검사할 크루원 인덱스
     */
    static void updateAnswer(List<String> answer, List<List<String>> forms, int idx) {
        String email = forms.get(idx).get(0);
        String name = forms.get(idx).get(1);

        for (int i = idx + 1; i < forms.size(); i++) {
            String compareEmail = forms.get(i).get(0);
            String compareName = forms.get(i).get(1);

            if (answer.contains(email) && answer.contains(compareEmail)) {
                continue;
            } else if (!isDuplicate(name, compareName)) {
                continue;
            }

            if (!answer.contains(email)) {
                answer.add(email);
            }
            if (!answer.contains(compareEmail)) {
                answer.add(compareEmail);
            }
        }
    }
}
