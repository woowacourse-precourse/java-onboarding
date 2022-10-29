package onboarding.feature6;

import java.util.ArrayList;
import java.util.List;

import static onboarding.feature6.Constants.*;

public class UserInfo {
    private List<String> emails = new ArrayList<>();
    private List<String> nicknames = new ArrayList<>();

    public UserInfo(List<List<String>> forms) {
        for (List<String> info : forms) {
            emails.add(info.get(EMAIL_INDEX));
            nicknames.add(info.get(NICKNAME_INDEX));
        }
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getNicknames() {
        return nicknames;
    }
}
