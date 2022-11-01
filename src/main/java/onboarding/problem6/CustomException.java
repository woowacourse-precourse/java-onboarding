package onboarding.problem6;

import java.util.List;

public class CustomException {

    public static void checkException(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000) {
            throw new RuntimeException();
        }

        for (List<String> crew : forms) {
            checkEmailException(crew.get(0));
            checkNickNameException(crew.get(1));
        }
    }

    private static void checkEmailException(String email) {
        if(!email.matches("\\w+@\\w+\\.[a-zA-Z]{3}$")) {
            throw new RuntimeException();
        }
        if (!email.split("@")[1].equals("email.com")) {
            throw new RuntimeException();
        }
        if (email.length() < 11 || email.length() >= 20) {
            throw new RuntimeException();
        }

    }

    private static void checkNickNameException(String nickName) {
        if (!nickName.matches("^[가-힣]{1,19}$")) {
            throw new RuntimeException();
        }
    }
}
