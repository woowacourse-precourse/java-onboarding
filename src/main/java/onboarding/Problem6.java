package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    /**
     * 정규식을 통해 @email.com을 만족하는지 확인
     * @param input
     * @return
     */
    private static boolean inspectEmailCondition(String input) {
        return input.matches("/^.*@email.com$/");
    }

    /**
     * 정규식을 통해 한글로만 이루어져 있는지 확인
     * @param input
     * @return
     */
    private static boolean inspectNicknameCondition(String input) {
        return input.matches("/^[ㄱ-ㅎ|가-힣]+$/");
    }

    /**
     * 주어진 이메일 목록 중 조건을 만족하는 항목을 선별한다.
     * @param forms
     * @return
     */
    private List<List<String>> collectValidInputs(List<List<String>> forms) {
        List<List<String>> result = new ArrayList<>();

        for (List<String> next : forms) {
            if (!inspectEmailCondition(next.get(0)) || !inspectNicknameCondition(next.get(1))) {
                continue;
            }
            List<String> temp = new ArrayList<>();
            temp.add(getEmailUsername(next.get(0)));
            temp.add(next.get(1));
            result.add(temp);
        }

        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
