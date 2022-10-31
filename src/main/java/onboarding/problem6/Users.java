package onboarding.problem6;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<UserInfo> userInfos;

    public Users(List<List<String>> forms) {
        this.userInfos = forms.stream().map(UserInfo::new).filter(UserInfo::isValid).collect(Collectors.toList());
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }
}
