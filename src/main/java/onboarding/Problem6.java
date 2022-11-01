package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 두 개의 닉네임에 중복되는 문자열이 있는지 확인하기 (20^2)
 * 2. 중복되는 닉네임을 찾아 이메일이 중복되지 않도록 리스트에 저장하기 (1e4^2)
 * 3. 이메일을 오름차순으로 정렬하여 답 반환하기
 *
 * 설계한 1e4 * 1e4 * 20 * 20 = 4e10
 */
public class Problem6 {
    static Boolean isDuplName(String a, String b) {
        for (int i = 0; i < a.length() - 1; i++) {
            if (b.contains(a.subSequence(i, i+2))) {
                return true;
            }
        }
        return false;
    }

    static List<String> findDuplEmail(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                List<String> cur = forms.get(i), nxt = forms.get(j);
                if (emails.contains(nxt.get(0)))
                    continue;
                if (!isDuplName(cur.get(1), nxt.get(1)))
                    continue;

                emails.add(cur.get(0));
                emails.add(nxt.get(0));
            }
        }
        return new ArrayList<>(emails);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = findDuplEmail(forms);
        Collections.sort(answer);
        return answer;
    }
}
