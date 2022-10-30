package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 닉네임의 중복 체크 기능
     */
    public static Boolean isDuplicationNickName(List<String> forms){
        return false;
    }

    /**
     * 이메일 예외처리 기능
     */
    public static Boolean isEmail(String email){
        return email.length() >= 11 && email.length() < 20 && email.endsWith("email.com");
    }

    /**
     * 닉네임 예외처리 기능
     */
    public static Boolean isNickName(String nickName){
        return nickName.length() >= 1 && nickName.length() < 20 && nickName.matches("^[가-힣]*$");
    }

}
