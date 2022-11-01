package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final String EMAIL_REGEXP = "^[a-zA-Z0-9+-_.]+@email.com+$";
    private static final String KOREAN_REGEXP = "^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$";

    /*
   검증 로직
   - 비정상적인 데이터가 입력된 경우
   - 크루는 1명 이상 10,000명 이하이다.
   - 이메일은 이메일 형식에 부합
   - 이메일 전체 길이는 11자 이상 20자 미만이다.
   - 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
   - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
*/
    public static void validate(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();
        int crewTotalNumber = forms.size();
        for (List<String> form: forms) {
            emails.add(form.get(0));
            nicknames.add(form.get(1));
        }
        emails.forEach(Validator::validateEmail);
        nicknames.forEach(Validator::validateNickName);
        validateCrew(crewTotalNumber);
    }

    private static void validateCrew(int crewTotalNumber) {
        isCrewInRange(crewTotalNumber);
    }

    private static void validateEmail(String email) {
        isEmailLengthInRange(email);
        isEmailDomainInRange(email);
        isEmailFormat(email);
    }

    private static void validateNickName(String nickName) {
        isNickNameInRange(nickName);
        isNickNameKorean(nickName);
    }

    private static void isCrewInRange(int crewTotalNumber) {
        if (crewTotalNumber < 1 || crewTotalNumber > 10000) {
            throw new IllegalArgumentException("크루 정원 범위 에러(1~10,000)");
        }
    }

    private static void isEmailLengthInRange(String email) {
        int emailLength = email.length();
        if ((emailLength < 11) || (emailLength > 20)) {
            throw new IllegalArgumentException("이메일 길이 에러(11~20)");
        }
    }

    private static void isEmailDomainInRange(String email) {
        if (!email.contains("email.com")) {
            throw new IllegalArgumentException("email.com 도메인으로만 신청할 수 있음");
        }
    }

    private static void isEmailFormat(String email) {
        if (!email.matches(EMAIL_REGEXP)) {
            throw new IllegalArgumentException("이메일 형식이 아닙니다.");
        }
    }

    private static void isNickNameInRange(String nickName) {
        int nickNameLength = nickName.length();
        if ((nickNameLength < 1) || (nickNameLength > 20)) {
            throw new IllegalArgumentException("닉네임 길이는 1자 이상 20자 미만");
        }
    }

    private static void isNickNameKorean(String nickName) {
        if (!nickName.matches(KOREAN_REGEXP)) {
            throw new IllegalArgumentException("닉네임은 한글만 가능");
        }
    }
}
