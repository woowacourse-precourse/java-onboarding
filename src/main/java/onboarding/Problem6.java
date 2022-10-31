package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    /**
     * 유사한 닉네임을 등록한 유저의 이메일 반환하는 함수
     * @param forms
     * @return array(email)
     */
    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        // 연속으로 2글자 이상 동일하면 유사한 닉네임이므로 2글자씩 저장
        for (List<String> form: forms) {
            // 한 닉네임에 대해 동일한 2글자의 중복 제거를 위해 HashSet 사용 (ex. "이이이이이")
            HashSet<String> tempSet = new HashSet<String>();
            String nickname = form.get(1);
            for (int i=0; i < nickname.length()-2; i++) {
                tempSet.add(nickname.substring(i, i+2));
            }
            temp.addAll(tempSet);
        }
        HashSet<String> answerSet = new HashSet<String>();
        // 2글자씩 저장한 데이터 중 동일한게 2개 이상인 경우 중복
        // 해당 글자를 포함한 유저의 이메일 저장
        for (String val: temp) {
            int cnt = Collections.frequency(temp, val);
            if (cnt > 1) {
                for (List<String> form: forms) {
                    String nn = form.get(1);
                    if (nn.contains(val)) {
                        answerSet.add(form.get(0));
                    }
                }
            }
        }
        answer.addAll(answerSet);

        return answer;
    }
}
