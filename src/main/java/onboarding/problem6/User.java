package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String nickname;

    public User(List<String> userInfo) {
        this.email = userInfo.get(0);
        this.nickname = userInfo.get(1);
    }

    public String getEmail() {
        return email;
    }

    public List<String> getPartOfNicknameList() {
        List<String> partOfNicknameList = new ArrayList<>();
        for (int i = 0; i < this.nickname.length() - 1; i++) {
            partOfNicknameList.add(this.nickname.substring(i, i + 2));
        }
        return partOfNicknameList;
    }

    public boolean checkConfusing (List<String> partOfNicknameList) {
        for (String partOfNickname : partOfNicknameList) {
            if (this.nickname.contains(partOfNickname)) {
                return true;
            }
        }
        return false;
    }

}
