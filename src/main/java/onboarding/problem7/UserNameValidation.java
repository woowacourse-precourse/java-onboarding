package onboarding.problem7;

public class UserNameValidation {


    public void checkValid(String name) {
        if (!isLength(name)) {
            throw new IllegalArgumentException("user 는 길이가 1 이상 30 이하인 문자열이여야 합니다.");
        }

        for (int index = 0; index < name.length(); index++) {
            if (!isAlphabetOrLowerCase(name, index)) {
                throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로만 구성 되어야 합니다.");
            }
        }
    }

    private boolean isAlphabetOrLowerCase(String name, int index) {
        return Character.isAlphabetic(name.charAt(index)) || Character.isLowerCase(name.charAt(index));
    }

    private boolean isLength(String name) {
        return name.length() >= 1 && name.length() <= 30;
    }

}
