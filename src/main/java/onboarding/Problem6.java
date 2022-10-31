package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem6 {

    /*
     * 입력이 유효한지 판별합니다.
     *
     * @param 입력으로 주어진 배열입니다.
     * @return 입력이 유효하다면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(List<List<String>> forms) {
        boolean valid = isValidForms(forms);

        for (List<String> form: forms) {
            valid &= isValidForm(form);
        }
        return valid;
    }

    private static boolean isValidForms(List<List<String>> forms) {
        return false;
    }

    private static boolean isValidForm(List<String> form) {
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
