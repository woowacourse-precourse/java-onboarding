package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        if (CheckInput(user,friends,visitors)){

        }throw new IllegalArgumentException("잘못된 입력값");
    }

    /* 기능1 : input 확인 */
    private static boolean CheckInput(String user, List<List<String>> friends, List<String> visitors){
        if(isUserInRange(user) && isFriendsInRange(friends) && isVisitorInRange(visitors))return true;
        return false;
    }
    private static boolean isUserInRange(String user){
        if(user.length() >=1 && user.length()<=30)return true;
        return false;
    }
    private static boolean isFriendsInRange(List<List<String>> friends){
        if(friends.size() >=1 && friends.size()<=10000)return true;
        return false;
    }
    private static boolean isVisitorInRange(List<String> visitors){
        if(visitors.size() >=0 && visitors.size()<=10000)return true;
        return false;
    }

    




}
