package onboarding.problem6.impl;

import onboarding.problem6.CrewValidator;

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
        if(20 <= nickname.length() || nickname.length() < 1){
            return false;
        }
        // 닉네임 길이 검사
        String[] spellings = nickname.split("");
        for (String spelling : spellings) {
            if (isKorean(spelling) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param spelling 한 글자 짜리 String
     * @return 한글 여부 판정
     */
    private boolean isKorean(String spelling) {
        return spelling.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^.+@email[.]com$");
    }


}
