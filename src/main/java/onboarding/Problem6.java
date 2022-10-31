package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem6 {

    /**
     * 입력이 유효한지 판별합니다.
     *
     * @param forms 입력으로 주어진 배열
     * @return 입력이 유효하다면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(List<List<String>> forms) {
        boolean valid = isValidForms(forms);

        for (List<String> form: forms) {
            valid &= isValidForm(form);
        }
        return valid;
    }

    /**
     * 숫자가 특정 범위 안의 숫자인지 알려줍니다.
     *
     * @param toCheck 확인할 숫자
     * @param leftBound 범위의 왼쪽 숫자
     * @param rightBound 범위의 오른쪽 숫자
     * @return 범위 안에 있으면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isInRange(int toCheck, int leftBound, int rightBound) {
        return leftBound <= toCheck && toCheck <= rightBound;
    }

    /**
     * 신청서 배열이 올바른지 확인합니다.
     *
     * @param forms 신청서 배열입니다.
     * @return 신청서 배열이 주어진 조건에 부합하면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidForms(List<List<String>> forms) {
        boolean valid = hasValidFormsLength(forms);
        return valid;
    }

    /**
     * 신청서 배열의 크기가 올바른지 확인합니다.
     *
     * @param forms 신청서 배열입니다.
     * @return 신청서 배열의 크기가 1~10000 사이라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidFormsLength(List<List<String>> forms) {
        boolean valid = isInRange(forms.size(), 1, 10000);
        return valid;
    }

    /**
     * 각 신청서가 올바른지 확인합니다.
     *
     * @param form 이메일과 닉네임이 담긴 신청서입니다.
     * @return 신청서의 정보가 올바르다면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidForm(List<String> form) {
        if (hasValidFormLength(form) == false) {
            return false;
        }
        String email = form.get(0);
        String nickname = form.get(1);

        boolean valid = hasValidEmail(email) &&
                hasValidNickname(nickname);
        return valid;
    }

    /**
     * 신청서가 포함한 정보가 2개인지 확인합니다.
     *
     * @param form 신청서 입니다.
     * @return 신청서가 2개의 정보를 가지고 있으면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidFormLength(List<String> form) {
        boolean valid = isInRange(form.size(), 2, 2);
        return valid;
    }

    /**
     * 신청서 첫 번째 정보가 이메일인지 확인합니다.
     *
     * @param email 신청서 첫 번째 정보입니다.
     * @return 해당 정보가 조건에 부합하는 이메일이면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidEmail(String email) {
        boolean valid = hasValidEmailLength(email) &&
                hasValidEmailForm(email) &&
                hasValidEmailDomain(email);
        return valid;
    }

    /**
     * 이메일의 길이가 조건에 부합하는지 확인합니다.
     *
     * @param email 신청서의 첫 번째 정보입니다.
     * @return 해당 정보의 길이가 11~19 사이의 값이라면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidEmailLength(String email) {
        boolean valid = isInRange(email.length(), 11, 19);
        return valid;
    }

    /**
     * 이메일이 형식에 부합하는지 확인합니다.
     *
     * @param email 신청서의 첫 번째 정보입니다.
     * @return 해당 정보가 이메일의 형식에 부합하면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidEmailForm(String email) {
        String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        boolean valid = email.matches(emailPattern);
        return valid;
    }

    /**
     * 이메일의 도메인이 "@email.com"인지 확인합니다.
     *
     * @param email 신청서의 첫 번째 정보입니다.
     * @return 해당 정보가 "@email.com"으로 끝난다면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidEmailDomain(String email) {
        boolean valid = email.endsWith("@email.com");
        return valid;
    }

    private static boolean hasValidNickname(String nickname) {
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
