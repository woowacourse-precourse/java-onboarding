package onboarding.problem6.utils.validator;

import onboarding.problem6.utils.Constants;
import onboarding.problem6.utils.validator.exception.NotHangulNicknameException;
import java.util.List;
import java.util.regex.Pattern;

public class NotHangulNicknameValidator {
    private List<List<String>> form;

    public NotHangulNicknameValidator(List<List<String>> form) throws NotHangulNicknameException{
        this.form = form;
        validateAllCrewNickname();
    }

    private void validateAllCrewNickname() throws NotHangulNicknameException{
        for(List<String> crew: form){
            validateCrewNickname(crew);
        }
    }

    private void validateCrewNickname(List<String> crew) throws NotHangulNicknameException{
        String crewNickname = crew.get(Constants.CREW_NICNAME);
        if(!Pattern.matches(Constants.HANGUL_REGEX, crewNickname)){
            throw new NotHangulNicknameException("한글이 아닌 닉네임을 사용한 크루가 있음");
        }
    }
}
