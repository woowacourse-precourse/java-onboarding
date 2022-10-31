package onboarding.problem6.crew.validator;

import java.util.List;

public class CrewValidatorV1 implements CrewValidator {
    @Override
    public boolean isValid(List<String> data) {
        if (data == null || data.size() != 2) {
            return false;
        }
        return isValidNickname(data.get(1)) && isValidEmail(data.get(0));
    }

    private boolean isValidNickname(String nickname) {
        // 닉네임 길이 검사
        if (20 <= nickname.length() || nickname.length() < 1) {
            return false;
        }
        // 한국어인지 검사
        return isOnlyKorean(nickname);
    }

    /**
     * @return 문자열이 한글로만 이루어져 있는지 여부 판정
     */
    private boolean isOnlyKorean(String nickname) {
        String[] spellings = nickname.split("");
        for (String spelling : spellings) {
            if (!spelling.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        if (20 <= email.length() || email.length() < 1) {
            return false;
        }
        return isEmailFormat(email);
    }

    private boolean isEmailFormat(String email) {
        return email.matches("^.+@email[.]com$");
    }


}
