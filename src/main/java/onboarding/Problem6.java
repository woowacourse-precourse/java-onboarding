package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    static Map<String, String> map;
    static Set<String> overLapNickNameEmail;

    // 이메일 중 email.com이 아닌것을 찾는 함수
    public static boolean checkEmail(String email){
        String[] emailArr = email.split("@");
        if(!emailArr[1].equals("email.com")) return false;
        return true;
    }

    // 유저의 이메일의 도메인이 유효하지 않거나 닉네임이 1자라 중복이 발생할 수 없는 경우 체크
    public static boolean exceptionCheck(List<String> user){
        if(user.get(1).length() == 1 || !checkEmail(user.get(0))){
            return true;
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
