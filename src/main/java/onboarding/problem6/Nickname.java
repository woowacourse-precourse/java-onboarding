package onboarding.problem6;

public class Nickname {

    private final int MIN_NICKNAME_LENGTH = 1;
    private final int MAX_NICKNAME_LENGTH = 20;

    private String nickname;

    public Nickname(String nickname) {
        validateNickname(nickname);
        this.nickname = nickname;
    }

    private void validateNickname(String nickname) {
        if (isOutOfBounds(nickname)) throw new IllegalArgumentException("Nickname is out of bounds");
    }

    private boolean isOutOfBounds(String nickname) {
        return nickname.length() < MIN_NICKNAME_LENGTH || nickname.length() > MAX_NICKNAME_LENGTH;
    }
}
