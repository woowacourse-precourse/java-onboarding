package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
1. 연속하는 문자열을 뽑아 내어, 자신을 제외한 사람과 중복이 있는지 찾는다.
2. 문자열에 중복이 있고, 아직 리스트에 추가되지 않았으면 추가
3. 오름차순으로 정렬
 */
public class Problem6 {

        public static List<String> solution(List<List<String>> forms) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < forms.size(); ++i) {
                String nickName = forms.get(i).get(1);
                for (int n = 2; n < nickName.length(); ++n) {
                    for (int m = 0; m < nickName.length() - n; ++m) {
                        String subStr = nickName.substring(m, m + n);
                        answer = findDuplicateMember(forms, i, subStr, answer);
                    }
                }
            }
            Collections.sort(answer);
            return answer;
        }
        private static List<String> findDuplicateMember(List<List<String>> forms, int index, String subStr, List<String> answer) {
            for (int i = 0; i < forms.size(); ++i) {
                if (i == index)
                    continue;
                String email = forms.get(i).get(0);
                String nickName = forms.get(i).get(1);
                if (nickName.contains(subStr) && !answer.contains(email)) {
                    answer.add(email);
                }
            }
            return answer;
        }
}
