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

    /*
     * 숫자가 특정 범위 안의 숫자인지 알려줍니다.
     *
     * @param 확인할 숫자, 범위의 왼쪽 숫자, 범위의 오른쪽 숫자입니다.
     * @return 범위 안에 있으면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isInRange(int toCheck, int leftBound, int rightBound) {
        return leftBound <= toCheck && toCheck <= rightBound;
    }

    /*
     * 신청서 배열이 올바른지 확인합니다.
     *
     * @param 신청서 배열입니다.
     * @return 신청서 배열이 주어진 조건에 부합하면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidForms(List<List<String>> forms) {
        boolean valid = hasValidFormsLength(forms);
        return valid;
    }

    /*
     * 신청서 배열의 크기가 올바른지 확인합니다.
     *
     * @param 신청서 배열입니다.
     * @return 신청서 배열의 크기가 1~10000 사이라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidFormsLength(List<List<String>> forms) {
        boolean valid = isInRange(forms.size(), 1, 10000);
        return valid;
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
