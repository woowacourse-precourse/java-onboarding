package onboarding.problem7;

import java.util.List;

public class Friend {

    private String name;
    private String friendName;

    protected Friend() {

    }

    public Friend(List<String> form) {
        validateFormSize(form);

        final String name = form.get(0);
        final String friendName = form.get(1);

        validateName(name);
        validateName(friendName);

        this.name = name;
        this.friendName = friendName;
    }

    private void validateName(String name) {
        validateNameLength(name);
        validateNameIsLowerCase(name);
    }

    private void validateNameIsLowerCase(String name) {
        if (!name.equals(name.toLowerCase())) {
            throw new IllegalArgumentException("아이디는 소문자이어야 합니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 30) {
            throw new IllegalArgumentException("아이디는 길이가 1 이상 30 이하인 문자열이어야 합니다.");
        }
    }

    private void validateFormSize(List<String> form) {
        if (form.size() != 2) {
            throw new IllegalArgumentException("입력받은 form의 길이가 2가 아닙니다.");
        }
    }

    public static Friend create(List<String> form) {
        return new Friend(form);
    }

    public String getName() {
        return name;
    }

    public String getFriendName() {
        return friendName;
    }
}
