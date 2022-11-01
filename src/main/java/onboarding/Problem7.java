package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        if (CheckInput(user,friends,visitors)){
            Map<String, Integer> Friends = new HashMap<>();
            List<String> userFriends = MakeFriendsList(user,friends);
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

    /* 기능2 : 사용자의 친구 list 생성 */
    private static List<String> MakeFriendsList(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();
        for(int i=0;i<friends.size();i++){
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);
            if(a == user)userFriends.add(b);
            if(b == user)userFriends.add(a);
        }
        return userFriends;
    }
}
