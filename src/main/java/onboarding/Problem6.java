package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;


public class Problem6 {
    static final int INPUT_MIN_SIZE = 1;
    static final int INPUT_MAX_SIZE = 10000;
    static final int NAME_MIN_LENGTH = 1;
    static final int NAME_MAX_LENGTH = 19;
    static final int EMAIL_MIN_LENGTH = 11;
    static final int EMAIL_MAX_LENGTH = 19;
    static final String KOREAN_REGEX = "^[가-힇]$";
    static final String EMAIL_REGEX = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
    static final String EMAIL_DOMAIN = "email.com";
    static final List<String> EXCEPTION = Collections.emptyList();


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static List<String> getSolution(List<List<String>> forms) {
        if (validationCheck(forms)) {

        }
        return EXCEPTION;
    }
    public static boolean validationCheck(List<List<String>> forms) {
        if (inputValidation(forms) && contentValidation(forms)) {
            return true;
        }
        return false;
    }
    public static boolean inputValidation(List<List<String>> forms) {
        if (forms.size() < INPUT_MIN_SIZE || forms.size() > INPUT_MAX_SIZE) {
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
            String name = forms.get(i).get(0);
            int nameLength = name.length();
            if (nameLength < NAME_MIN_LENGTH || nameLength > NAME_MAX_LENGTH) {
                return false;
            } else if (!Pattern.matches(KOREAN_REGEX, name)) {
                return false;
            }
        }
        return true;
    }
    public static boolean emailValidation(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(1);
            int emailLength = email.length();
            if (emailLength < EMAIL_MIN_LENGTH || emailLength > EMAIL_MAX_LENGTH) {
                return false;
            }
            else if (!Pattern.matches(EMAIL_REGEX, email)) {
                return false;
            }
            else if (!email.contains(EMAIL_DOMAIN)) {
                return false;
            }
        }
        return true;
    }

    public static void splitLexim(List<String> repository, String name) {
        for (int j = 0; j < name.length()-1; j++) {
            repository.add(name.substring(j, j+2));
        }
    }
    public static boolean appearMoreThanTwice(List<String> repository, String lexim) {
        if (Collections.frequency(repository, lexim) >= 2) {
            return true;
        }
        return false;
    }
}
