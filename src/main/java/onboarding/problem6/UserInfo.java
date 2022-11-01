package onboarding.problem6;

import java.util.List;

import static onboarding.problem6.ConstantsP6.KOREAN;
import static onboarding.problem6.ConstantsP6.MAX_EMAIL_LENGTH;
import static onboarding.problem6.ConstantsP6.MAX_NICKNAME_LENGTH;
import static onboarding.problem6.ConstantsP6.MIN_EMAIL_LENGTH;
import static onboarding.problem6.ConstantsP6.MIN_NICKNAME_LENGTH;

public class UserInfo {
    private final List<String> emailAndNickname;

    public UserInfo(List<String> oneInfo) {
        this.emailAndNickname = oneInfo;
    }

    public String getEmail() {
        return emailAndNickname.get(0);
    }

    public String getNickname() {
        return emailAndNickname.get(1);
    }

    public boolean isValid() {
        if (!isProperLength()) {
            return false;
        }
        if (!isEmailValid()) {
            return false;
        }
        return isNicknameValid();
    }

    private boolean isProperLength() {
        if (emailAndNickname == null) {
            return false;
        }
        if (emailAndNickname.size() != 2) {
            return false;
        }
        if (emailAndNickname.get(0) == null) {
            return false;
        }
        return emailAndNickname.get(1) != null;
    }

    private boolean isEmailValid() {
        String email = emailAndNickname.get(0);
        if (!email.endsWith("email.com")) {
            return false;
        }
        return MIN_EMAIL_LENGTH <= email.length() && email.length() <= MAX_EMAIL_LENGTH;
    }

    private boolean isNicknameValid() {
        String nickname = emailAndNickname.get(1);
        if (!KOREAN.matcher(nickname).matches()) {
            return false;
        }
        return MIN_NICKNAME_LENGTH <= nickname.length() && nickname.length() <= MAX_NICKNAME_LENGTH;
    }
}
