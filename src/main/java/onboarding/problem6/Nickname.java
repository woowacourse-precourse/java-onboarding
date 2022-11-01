package onboarding.problem6;

import java.util.LinkedList;
import java.util.List;

public class Nickname {

    private final int MIN_NICKNAME_LENGTH = 1;
    private final int MAX_NICKNAME_LENGTH = 20;
    private final int KOREAN_TYPE = 5;

    private String nickname;

    public Nickname(String nickname) {
        validateNickname(nickname);
        this.nickname = nickname;
    }

    private void validateNickname(String nickname) {
        if (isOutOfBounds(nickname)) throw new IllegalArgumentException("Nickname is out of bounds");

        if (!isKorean(nickname)) throw new IllegalArgumentException("Nickname is not korean");
    }

    private boolean isOutOfBounds(String nickname) {
        return nickname.length() < MIN_NICKNAME_LENGTH || nickname.length() > MAX_NICKNAME_LENGTH;
    }

    private boolean isKorean(String nickname) {
        return nickname.codePoints()
                .map(i -> (char) i)
                .map(Character::getType)
                .filter(t -> t != KOREAN_TYPE)
                .findAny()
                .isEmpty();
    }

    public List<String> getPartOfNickname() {

        List<String> partOfNickname = new LinkedList<>();

        for (int i = 0; i < this.nickname.length() - 1; i++) {
            partOfNickname.add(nickname.substring(i, i + 2));
        }

        return partOfNickname;
    }
}
