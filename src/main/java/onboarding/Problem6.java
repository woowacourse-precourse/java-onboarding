package onboarding;

import java.util.List;

public class Problem6 {
    private static final int formsMinSize = 1;
    private static final int formsMaxSize = 10000;
    private static final int emailMinLen = 11;
    private static final int emailMaxLen = 19;
    private static final int nickNameMinLen = 1;
    private static final int nickNameMaxLen = 19;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        validateForms(forms);
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            validateEmail(email);
            validateNickName(nickName);
        }
        return answer;
    }

    private static void validateForms(List<List<String>> forms) {
        if (forms.size() < formsMinSize || forms.size() > formsMaxSize) {
            throw new IllegalArgumentException("크루는 1명 이상 10000명 이하여야합니다.");
        }
    }

    private static void validateEmail(String email) {
        if (email.length() < emailMinLen || email.length() > emailMaxLen) {
            throw new IllegalArgumentException("이메일은 11자이상 20자 미만이어야합니다.");
        }

        if (!email.matches("^\\w+@email.com$")) {
            throw new IllegalArgumentException("이메일 형식에 부합해야하며, email.com 도메인이어야합니다.");
        }
    }

    private static void validateNickName(String nickName) {
        if (!nickName.matches("^[ㄱ-ㅎ|가-힣]+$")) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }
        if (nickName.length() < nickNameMinLen || nickName.length() > nickNameMaxLen) {
            throw new IllegalArgumentException("닉네임은 1자 이상 20자 미만이어야합니다.");
        }
    }
}
