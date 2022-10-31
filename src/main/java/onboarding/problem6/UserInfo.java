package onboarding.problem6;

import java.util.List;
import java.util.regex.Pattern;

public class UserInfo {
    private static final Pattern KOREAN = Pattern.compile("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$");
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
        return 11 <= email.length() && 20 > email.length();
    }

    private boolean isNicknameValid() {
        String nickname = emailAndNickname.get(1);
        if (!KOREAN.matcher(nickname).matches()) {
            return false;
        }
        return 1 <= nickname.length() && nickname.length() < 20;
    }
}
