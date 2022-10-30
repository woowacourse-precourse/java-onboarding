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

    //친구의 친구관계 리스트 만들기
    public static List<String> makeFriendList(Set<String> userFriend, String friend, List<List<String>> friends) {
        ArrayList<String> friendList = new ArrayList<>();

        for(List<String> list : friends){
            if (list.get(0).equals(friend) && !userFriend.contains(list.get(1))) friendList.add(list.get(1));
            if (list.get(1).equals(friend) && !userFriend.contains(list.get(0))) friendList.add(list.get(0));
        }
        return friendList;
    }
}