package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능 목록
 * 1. forms를 순회하는 기능
 * 2. 닉네임을 2개식 자르는 기능
 * 3. 자른 닉네임이 다른 크루의 닉네임에 포함되면 anwer에 추가하는 기능
 * 4. answer(이메일)의 중복을 제거하는 기능
 * 5. answer(이메일)을 정렬하는 기능
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);
            String nickname = form.get(1);
        }
        return answer;
    }
}
