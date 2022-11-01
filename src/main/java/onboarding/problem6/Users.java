package onboarding.problem6;

import java.util.List;
import java.util.stream.Collectors;

import static onboarding.problem6.ConstantsP6.MAX_CREW_NUMBER;
import static onboarding.problem6.ConstantsP6.MIN_CREW_NUMBER;

public class Users {
    private final List<UserInfo> userInfos;

    public Users(List<List<String>> forms) {
        isValid(forms);
        this.userInfos = forms.stream().map(UserInfo::new).filter(UserInfo::isValid).collect(Collectors.toList());
    }

    private void isValid(List<List<String>> forms) {
        if (MIN_CREW_NUMBER > forms.size()) {
            throw new IllegalArgumentException();
        }
        if (MAX_CREW_NUMBER < forms.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }
}
