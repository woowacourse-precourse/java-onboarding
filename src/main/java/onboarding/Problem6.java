package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    private static final String EMAIL_DOMAIN = "@email.com";
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, ArrayList<String>> consecutiveLettersMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (isValidForm(email, nickname)){
            }
        }

        return answer;
    }

    private static boolean isValidForm(String email, String nickname) {
        boolean isValidEmail = email.endsWith(EMAIL_DOMAIN);
        boolean isValidNickname = isHangulNickname(nickname);
        return (isValidEmail && isValidNickname);
    }

    private static boolean isHangulNickname(String nickname){
        for(char letter : nickname.toCharArray()){
            if(!String.valueOf(letter).matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
                return false;
            }
        }
        return true;
    }
}