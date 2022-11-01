package onboarding.problem6;

import onboarding.exception.InputException;
import onboarding.problem6.exception.Problem6ExceptionMessage;

import java.util.regex.Pattern;

public class Nickname {

    private static final String IS_KOREAN_REGULAR_EXPRESSION =  "^[가-힣]+$";
    private String nickname;

    public Nickname(String nickname){
        this.nickname = nickname;
        if (!isKorean() || !isNumberOfCharacterFrom1to20())
            throw new InputException(Problem6ExceptionMessage.NOT_NICKNAME_ALLOWED);
    }

    private boolean isKorean(){
        return Pattern.compile(IS_KOREAN_REGULAR_EXPRESSION).matcher(nickname).matches();
    }

    private boolean isNumberOfCharacterFrom1to20(){
        return 1 <= nickname.length() && nickname.length() <= 20;
    }

    public String getNickname() {
        return nickname;
    }
}
