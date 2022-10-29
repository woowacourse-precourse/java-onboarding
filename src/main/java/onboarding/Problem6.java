package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(!checkValidation(forms)){
            return null;
        }
        return answer;
    }

    private static boolean checkValidation(List<List<String>> forms){
        if(dataAmountValidation(forms) && nicknameValidation(forms) && emailValidation(forms)){
            return true;
        }
        return false;
    }

    private static boolean dataAmountValidation(List<List<String>> forms){
        if(1<=forms.size() && forms.size()<=10000){
            return true;
        }
        return false;
    }

    private static boolean nicknameValidation(List<List<String>> forms){
        final int MAX_LENGTH = 20;
        final String NICKNAME_REGEX = "[가-힣]+$";
        return forms.stream()
                .allMatch((List a) -> (Pattern.matches(NICKNAME_REGEX,(String)a.get(1))) && ((String) a.get(1)).length()<=MAX_LENGTH);
    }

    private static boolean emailValidation(List<List<String>> forms){
        final int MIN_LENGTH = 11;
        final int MAX_LENGTH = 20;
        final String EMAIL_REGEX  = "^\\w+@email\\.com";
        return forms.stream().allMatch((List a)-> Pattern.matches(EMAIL_REGEX, (String)a.get(0))
                && ((String) a.get(0)).length()<=MAX_LENGTH
                && (MIN_LENGTH<=((String) a.get(0)).length()));
    }



}
