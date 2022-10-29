package onboarding;

import java.util.ArrayList;
import java.util.List;

/* 기능 목록
 * 두 이름이 중복인지 검사하는 기능
 * 중복되지 않은 것 끼리 검사하는 기능
 * */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Problem6 problem6 = new Problem6();
        answer = new ArrayList<>();
        int len = forms.size();

        for (int i = 0; i < len - 1; i++) {
            String email1 = forms.get(i).get(0);
            String name1 = forms.get(i).get(1);

            for (int j = i + 1; j < len; j++) {
                String email2 = forms.get(j).get(0);
                String name2 = forms.get(j).get(1);

                if (answer.contains(name1) && answer.contains(name2)) {
                    continue;
                } else if (problem6.isDuplicate(name1, name2)) {
                    if (!answer.contains(email1)) {
                        answer.add(email1);
                    }
                    if (!answer.contains(email2)) {
                        answer.add(email2);
                    }
                }
            }
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
    boolean isDuplicate(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            for (int j = 0; j < name2.length() - 1; j++) {
                if (name1.substring(i, i + 2).equals(name2.substring(j, j + 2))) {
                    return true;
                }
            }
        }
        return false;
    }
}
