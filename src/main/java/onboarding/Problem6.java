package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem6 {

    private static boolean isValidInput(List<List<String>> forms) {
        return false;
    }

    private static List<String> getDuplicateNicknameUsers(List<List<String>> forms) {
        return Collections.emptyList();
    }

    /*
     * Problem5의 솔루션 코드입니다.
     *
     * @param 중복 닉네임 검사를 진행할 크루원 배열입니다.
     * @return 중복 닉네임을 가진 크루원들의 이메일 배열입니다.
     *  */    public static List<String> solution(List<List<String>> forms) {
        if (isValidInput(forms) == false) {
            return Collections.emptyList();
        }
        List<String> answer = getDuplicateNicknameUsers(forms);
        return answer;
    }
}
