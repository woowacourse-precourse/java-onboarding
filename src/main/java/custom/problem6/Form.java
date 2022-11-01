package custom.problem6;

import java.util.List;
import java.util.regex.Pattern;

public class Form {

    private final String email;
    private final String nickname;

    public Form(String email, String nickname) {
        Validator.validateConstructor(email, nickname);
        this.email = email;
        this.nickname = nickname;
    }

    public static Form of(List<String> forms) {
        Validator.validateListInputSIze(forms);
        return new Form(forms.get(0), forms.get(1));
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    static class Validator {

        private static final String EMAIL_REGEX = "^\\w+@email\\.com$";
        private static final String NICKNAME_REGEX = "^[가-힣]+$";
        private static Pattern pattern;

        private static void validateConstructor(String email, String nickname) {
            validateEmailFormat(email);
            validateEmailSize(email);
            validateNicknameFormat(nickname);
            validateNicknameSize(nickname);
        }

        private static void validateListInputSIze(List<String> form) {
            if (form.size() == 2) {
                return;
            }
            throw new RuntimeException("form 사이즈는 2여야 합니다");
        }

        private static void validateEmailFormat(String email) {
            pattern = Pattern.compile(EMAIL_REGEX);
            if (pattern.matcher(email).matches()) {
                return;
            }
            throw new RuntimeException("email 형식이 맞지 않습니다");
        }

        private static void validateEmailSize(String email) {
            if (11 <= email.length() && email.length() < 20) {
                return;
            }
            throw new RuntimeException("email 사이즈는 11자 이상 20자 미만입니다");
        }

        private static void validateNicknameFormat(String nickname) {
            pattern = Pattern.compile(NICKNAME_REGEX);
            if (pattern.matcher(nickname).matches()) {
                return;
            }
            throw new RuntimeException("nickname 형식이 맞지 않습니다");
        }

        private static void validateNicknameSize(String nickname) {
            if (1 <= nickname.length() && nickname.length() < 20) {
                return;
            }
            throw new RuntimeException("nickname 사이즈는 1자 이상 20자 미만입니다");
        }
    }
}
