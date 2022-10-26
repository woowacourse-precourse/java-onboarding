package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkDouble(forms);
        return answer;
    }
    public static List<String> checkDouble(List<List<String>> forms) {
        System.out.println(forms.get(0).get(1));
        /**
         * 이미 회원은 다 받아져 있는 상태
         * 그러니 for문을 돌면서 fomrms 내에 있는 닉네임을 나눈것을 비교해보아야한다.
         */
        List<String> result = List.of("answer");
        return result;
    }

}
