/*----------------------------------------------------------------------------------------
 * Author: 조형준
 * Date: 2022/11/01
 * Objective:
 *   1. 문제의 특성상 다중 반복문이 쓰일 수밖에 없음
 *   2. 다중반복문 속에서 최대한 시행된 비교가 다시 시행되지 않도록 신경 써서 작성
 *      (a == b, b == a 가 한 번씩 이뤄지는 꼴 등)
 *   3. 정렬의 경우 Collections의 sort 메서드를 활용
 *---------------------------------------------------------------------------------------*/
package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        String comp, name, target, email_str;
        List<String> searched = new ArrayList<>();
        List<String> email = new ArrayList<>();
        int size = forms.size();
        int len, pred;
        boolean dup_bool = false;

        for (int i = 0; i < size; i++) {
            name = forms.get(i).get(1);
            len = name.length();
            if (len >= 2) {
                for (int j = 0; j < len - 1; j++) {
                    comp = String.valueOf(name.charAt(j)) + String.valueOf(name.charAt(j + 1));
                    for (int k = i + 1; k < size; k++) {
                        target = forms.get(k).get(1);
                        if (!searched.contains(comp) && target.contains(comp)) {
                            dup_bool = true;
                            email_str = forms.get(k).get(0);
                            if (!email.contains(forms.get(k).get(0))) {
                                email.add(email_str);
                            }
                        }
                    }
                    if (dup_bool && !email.contains(forms.get(i).get(0))) {
                        email.add(forms.get(i).get(0));
                        dup_bool = false;
                    }
                    searched.add(comp);
                }
            }
        }
        Collections.sort(email);
        List<String> answer = email;
        return answer;
    }
}
