package onboarding.problem6.utils.validator;

import onboarding.problem6.utils.Constants;
import onboarding.problem6.utils.validator.exception.NicknameLengthException;

import java.util.List;

public class NicknameLengthValidator {
    private List<List<String>> form;

    public NicknameLengthValidator(List<List<String>> form) throws NicknameLengthException {
        this.form = form;
        validateAllCrewNicknameLength();
    }

    private void validateAllCrewNicknameLength() throws NicknameLengthException {
        for(List<String> crew : form){
            validateCrewNicknameLength(crew);
        }
    }

    private void validateCrewNicknameLength(List<String> crew) throws NicknameLengthException {
        int nicknameLength = crew.get(Constants.CREW_NICNAME).length();
        if(nicknameLength < Constants.MIN_NICKNAME_LENGTH || nicknameLength > Constants.MAX_NICKNAME_LENGTH){
            throw new NicknameLengthException("닉네임 길이를 초과한 크루가 있음");
        }
    }
}
