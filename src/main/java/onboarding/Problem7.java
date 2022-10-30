package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        if (validation("user_length",user.length())&&validation("friends_size",friends.size())&&validation("visitors_size",visitors.size())){
            //닉네임 길이 예외처리&&친구 리스트 배열길이 예외처리
            for (List<String> friend:friends){
                if(validation("friends_e_length",friend.size())){
                    String own = friend.get(0);
                    String fri = friend.get(1);
                    if (validation("user_valid",own)&&validation("user_valid",fri)){
                    }
                }
            }
        }
        return answer;
    }

    private static <T>boolean validation(String err_type,T err_param){
        if (err_type.equals("user_length")&&err_param instanceof Integer){
            int user_length = (int) err_param;
            return 0< user_length&&user_length<31;
        }
        else if (err_type.equals("friends_size")&&err_param instanceof Integer){
            int friends_size = (int) err_param;
            return 0<friends_size&&friends_size<10001;
        }
        else if (err_type.equals("visitors_size")&&err_param instanceof Integer){
            int visitors_size = (int) err_param;
            return 0<visitors_size&&visitors_size<10001;
        }
        else if(err_type.equals("friends_e_length")&&err_param instanceof Integer){
            int elements_length = (int) err_param;
            return elements_length==2;
        }
        else if (err_type.equals("user_valid")&&err_param instanceof String){
            String user_id_regex = (String) err_param;
            if (!user_id_regex.matches("^[a-z]*$")) return false;
            return 0<user_id_regex.length()&&user_id_regex.length()<31;
        }
        return false;
    }
}
