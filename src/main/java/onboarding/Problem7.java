package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return new ArrayList<>();
    }


    //유저의 친구관계 알아내기
    public static Set<String> findUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriend = new HashSet<>();
        for (List<String> f : friends) {         //user이름 포함되면 set에 넣기
            if (f.contains(user)) {
                userFriend.add(f.get(0));
                userFriend.add(f.get(1));
            }
        }
        return userFriend;
    }

}