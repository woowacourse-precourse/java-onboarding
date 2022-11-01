package ExceptionValidation;

//- 이메일이 @email.com 이 포함 되어 있는지 확인
//- 이메일의 길이가 11~20 인지 판단
//- 닉네임이 한글인지 판단
//- 닉네임의 길이가 1~20인지 판단

import java.util.List;

public class P6ExceptionValidation {

    private static final String EMAIL_FORMAT = "@email.com";

    public static boolean p6ExceptionValidation(String email, String userName){

        return isEmailFormat(email)
                && isEmailLengthBetween11and20(email)
                && isUserNameLengthBetween1and20(userName)
                && UserNameValidation(userName);
    }


    private static boolean isEmailFormat(String email) {
        return email.endsWith(EMAIL_FORMAT);
    }

    private static boolean isEmailLengthBetween11and20(String email) {
        if (email.length() < 11 || email.length() > 20) {
            return false;
        }
        return true;
    }

    private static boolean isUserNameLengthBetween1and20(String userName) {
        if (userName.length() < 1 || userName.length() > 20) {
            return false;
        }
        return true;
    }

    private static boolean UserNameValidation(String userName) {
        return userName.chars()
                .filter(c -> Character.getType(c) == Character.OTHER_LETTER)
                .count() == userName.length();
    }

}