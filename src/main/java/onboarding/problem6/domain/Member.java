package onboarding.problem6.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Member {

    private String email;
    private String nickname;
    private int duplicateStatus;

    public Member(String email, String nickname, int duplicateStatus) {
        this.email = email;
        this.nickname = nickname;
        this.duplicateStatus = duplicateStatus;
    }

    public void checkNickname(HashMap<String, Integer> duplicateNicknameCheckedMap) {
        List<String> twoCharacterList = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String substring = nickname.substring(i, i + 2);
            twoCharacterList.add(substring);
        }

        for (String twoCharacter : twoCharacterList) {
            duplicateNicknameCheckedMap.put(twoCharacter,
                    duplicateNicknameCheckedMap.getOrDefault(twoCharacter, 0) + 1);
        }
    }

    public void setDuplicateStatus(HashMap<String, Integer> duplicateNicknameCheckedMap) {
        for (String key : duplicateNicknameCheckedMap.keySet()) {
            if (nickname.contains(key) && duplicateNicknameCheckedMap.get(key) > 1) {
                duplicateStatus = 1;
                break;
            }
        }
    }

    public int getDuplicateStatus() {
        return duplicateStatus;
    }

    public String getEmail() {
        return email;
    }
}
