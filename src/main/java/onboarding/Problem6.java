package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static final int MIN_CREW_NUMBER = 1;
    private static final int MAX_CREW_NUMBER = 10000;
    private static final int MIN_NICK_NAME_LENGTH = 1;
    private static final int MAX_NICK_NAME_LENGTH = 20;
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 20;
    private static final String DOMAIN_FORMAT = "email.com";
    public static List<String> solution(List<List<String>> forms) {
        validityChecker(forms);
        List<String> answer = List.of("answer");
        return answer;
    }
    private static void validityChecker(List<List<String>> forms) {
        isValidateCrew(forms);
        isValidateNickname(forms);
        isValidateEmail(forms);
    }
    private static void isValidateCrew(List<List<String>> forms) {
        if (forms.size() < MIN_CREW_NUMBER || MAX_CREW_NUMBER < forms.size()) {
            throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하이어야 합니다.");
        }
    }
    private static void isValidateNickname(List<List<String>> forms) {
//    길이가 유효한가
//    닉네임이 숫자만 들어갔는가
        for (List<String> form : forms) {
            String nickName = form.get(1);
            if (nickName.length() < MIN_NICK_NAME_LENGTH || MAX_NICK_NAME_LENGTH < nickName.length()) {
                throw new IllegalArgumentException("올바른 길이가 아닙니다");
            }
            if (!Pattern.matches("[ㄱ-힣]*$", nickName)) {

                throw new IllegalArgumentException("닉네임이 한글로 구성되지 않았습니다.");
            }
        }
    }
    private static void isValidateEmail(List<List<String>> forms) {
        isValidateForm(forms);
        isValidateDomain(forms);
    }
    private static void isValidateForm(List<List<String>> forms) {
//    길이가 유효한가
//    @앞으로 A-z|0-9._- 로 구성되어 있는가
        String[] splitEmail;
        for (List<String> form : forms) {
            String email = form.get(0);
            if (email.length() < MIN_EMAIL_LENGTH || MAX_EMAIL_LENGTH <= email.length()) {
                throw new IllegalArgumentException("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.");
            }
            splitEmail = email.split("@");
            if (!Pattern.matches("^[A-z0-9._-]*", splitEmail[0])) {
                throw new IllegalArgumentException("이메일 형식에 부합하지 않습니다.");
            }
        }
    }
    private static void isValidateDomain(List<List<String>> forms) {
        String[] splitEmail;
        for (List<String> form : forms) {
            String email = form.get(0);
            splitEmail = email.split("@");
            if (splitEmail.length != 2 || !splitEmail[1].equals(DOMAIN_FORMAT)) {
                throw new IllegalArgumentException("올바른 도메인 형식이 아닙니다.");
            }
        }
    }
}
