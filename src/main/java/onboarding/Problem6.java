package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 기능 목록
 * 1. 중복될 수 있는 2글자 단어들 모으기
 * 2. 1번으로 해당 닉네임이 중복인지 검사
 * 3. result에서 이메일 오름차순으로 정렬
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Boolean> duplications = new HashMap<>();

        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                duplications.put(form.get(1).substring(i, i + 2), Boolean.TRUE);
            }
        }

        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                if (duplications.containsKey(form.get(1).substring(i, i + 2))) {
                    answer.add(form.get(0));
                }
            }
        }

        return answer;
    }
}
