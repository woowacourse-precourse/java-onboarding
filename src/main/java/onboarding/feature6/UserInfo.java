package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.ArrayList;
import java.util.List;

import onboarding.feature6.InputValidator;

public class UserInfo {
    private List<String> emails = new ArrayList<>();
    private List<String> nicknames = new ArrayList<>();

    public UserInfo(List<List<String>> forms) {
        for (List<String> userInfo : forms) {
            String email = userInfo.get(EMAIL_INDEX);
            String nickname = userInfo.get(NICKNAME_INDEX);
            checkEmailAndNickname(email, nickname);
        }
    }

    public void checkEmailAndNickname(String email, String nickname) {
        if (InputValidator.isValidEmailAddress(email) && InputValidator.isValidNickname(nickname)) {
            emails.add(email);
            nicknames.add(nickname);
        }
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getNicknames() {
        return nicknames;
    }
}
