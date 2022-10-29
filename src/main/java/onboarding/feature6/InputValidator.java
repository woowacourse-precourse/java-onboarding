package onboarding.feature6;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    // A hyphen (-) can be included in the middle or at the end of an email address, but not at the beginning
    private final String regx = "^\\w+[-\\w]@email.com$";
    private String email;
    private String nickname;

    public InputValidator(List<String> userInfo) {
        email = userInfo.get(0);
        nickname = userInfo.get(1);
    }

    public boolean emailChecker() {
        return isValidLength(email, 11, 20) && isValidEmailAddress(email);
    }

    public boolean nicknameChecker() {
        return  isValidLength(nickname, 1, 20) && isValidNickname(nickname);
    }

    public boolean isValidLength(String input, int minLength, int maxLength) {
        int inputLength = input.length();
        return inputLength >= minLength && inputLength < maxLength;
    }

    public boolean isValidEmailAddress(String email) {
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidNickname(String nickname) {
        for (int i = 0; i < nickname.length(); i++) {
            int unicodeDecimal = nickname.charAt(i);
            if ((unicodeDecimal < 44032 || unicodeDecimal > 55203) && (unicodeDecimal < 12593 || unicodeDecimal > 12643)) {
                return false;
            }
        }
        return true;
    }
}
