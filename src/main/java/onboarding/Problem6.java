package onboarding;

import java.util.List;

public class Problem6 {

    private static final String VALIDDOMAIN = "@email.com";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        try{
            isValidForms(forms);
        } catch (IllegalStateException formErrorExceptions) {
            formErrorExceptions.printStackTrace();
        }

        return answer;
    }

    public static void isValidForms(List<List<String>> forms) throws IllegalStateException{
        if(forms.size() < 1 || forms.size() > 10000)
            throw new IllegalStateException("크루원의 숫자가 올바르지 않습니다.");
        if(!forms.stream().allMatch(form -> isValidEmailLength(form.get(0))))
            throw new IllegalStateException("크루원의 이메일의 길이가 올바르지 않습니다");
        if(!forms.stream().allMatch(form -> isValidEmailDomain(form.get(0))))
            throw new IllegalStateException("크루원의 이메일 도메인이 올바르지 않습니다.");
        if(forms.stream().anyMatch(form -> isNicknameContainsEnglish(form.get(1))))
            throw new IllegalStateException("크루원의 닉네임에 영어가 포함되어있습니다.");
        if(forms.stream().allMatch(form -> isValidNicknameLength(form.get(1))))
            throw new IllegalStateException("크루원의 닉네임의 길이가 올바르지 않습니다.");
    }

    public static boolean isValidEmailLength(String email) {
        if(email.length() >= 11 && email.length() <= 19)
            return true;
        return false;
    }

    public static boolean isValidEmailDomain(String email) {
        if(email.contains(VALIDDOMAIN))
            return true;
        return false;
    }

    public static boolean isNicknameContainsEnglish(String nickname) {
        if(nickname.chars().anyMatch(Character::isAlphabetic))
            return true;
        return false;
    }

    public static boolean isValidNicknameLength(String nickname) {
        if(nickname.length() >0 && nickname.length() <20)
            return true;
        return false;
    }
}
