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

        NameValidator.validateName(name);
        NameValidator.validateName(friendName);

        this.name = name;
        this.friendName = friendName;
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
