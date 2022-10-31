package onboarding.problem6;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    public static boolean check(List<List<String>> forms) {
        if (inputValidation(forms) && contentValidation(forms)) {
            return true;
        }
        return false;
    }
    public static boolean inputValidation(List<List<String>> forms) {
        if (forms.size() < Constant.INPUT_MIN_SIZE || forms.size() > Constant.INPUT_MAX_SIZE) {
            return false;
        }
        return true;
    }
    public static boolean contentValidation(List<List<String>> forms) {
        if (emailValidation(forms) && nameValidation(forms)) {
            return true;
        }
        return false;
    }
    public static boolean nameValidation(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            int nameLength = name.length();
            if (nameLength < Constant.NAME_MIN_LENGTH || nameLength > Constant.NAME_MAX_LENGTH) {
                return false;
            } else if (!Pattern.matches(Constant.KOREAN_REGEX, name)) {
                return false;
            }
        }
        return true;
    }
    public static boolean emailValidation(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            int emailLength = email.length();
            if (emailLength < Constant.EMAIL_MIN_LENGTH || emailLength > Constant.EMAIL_MAX_LENGTH) {
                return false;
            }
            else if (!Pattern.matches(Constant.EMAIL_REGEX, email)) {
                return false;
            }
            else if (!email.contains(Constant.EMAIL_DOMAIN)) {
                return false;
            }
        }
        return true;
    }
}
