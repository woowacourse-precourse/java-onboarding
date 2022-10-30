package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        if (validation("user_length",user.length())){
            //닉네임 길이 예외처리
        }
        return answer;
    }


    private static <T>boolean validation(String err_type,T err_param){
        if (err_type.equals("user_length")&&err_param instanceof Integer){
            int user_length = (int) err_param;
            return 0< user_length&&user_length<31;
        }
        return false;
    }
}
