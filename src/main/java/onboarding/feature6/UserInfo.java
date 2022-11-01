package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.ArrayList;
import java.util.List;

import onboarding.feature6.InputValidator;

public class UserInfo {
    private List<List<String>> forms;
    private List<String> nicknames;

    public UserInfo(List<List<String>> forms) {
        this.forms = forms;
        this.nicknames = new ArrayList<>();
        for (List<String> userData : forms) {
            String email = userData.get(EMAIL_INDEX);
            String nickname = userData.get(NICKNAME_INDEX);
            checkEmailAndNickname(email, nickname);
        }
    }

    public void checkEmailAndNickname(String email, String nickname) {
        if (InputValidator.isValidEmailAddress(email) && InputValidator.isValidNickname(nickname)) {
            nicknames.add(nickname);
        }
    }

    public List<List<String>> getForms() {
        return forms;
    }

    public List<String> getNicknames() {
        return nicknames;
    }
}
