package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String, Integer> map = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 친구 셋 생성
        Set<String> direct_friend = new HashSet<>();
        for (List<String> friend_pair : friends){
            if (friend_pair.get(0).equals(user)) {
                direct_friend.add(friend_pair.get(1));
            } else if (friend_pair.get(1).equals(user)) {
                direct_friend.add(friend_pair.get(0));
            }
        }

        // 친구의 친구 점수 부여
        for (List<String> friend_pair : friends){
            String friend_of_friend;
            if (friend_pair.contains(user)) {
                continue;
            }else if (direct_friend.containsAll(friend_pair)){
                continue;
            } else if (direct_friend.contains(friend_pair.get(0))){
                friend_of_friend = friend_pair.get(1);
            } else if (direct_friend.contains(friend_pair.get(1))){
                friend_of_friend = friend_pair.get(0);
            } else {
                continue;
            }
            Add_10_points(friend_of_friend);
        }

        // 방문자 점수 부여
        for (String visitor : visitors){
            if (!direct_friend.contains(visitor)){
                Add_point(visitor);
            }
        }

        return recommendation();
    }


    public static void Add_10_points(String friend){}

    public static void Add_point(String visitor){}

    public static List<String> recommendation(){
        List<String> answer = new ArrayList<>();
        return answer;
    }

}
