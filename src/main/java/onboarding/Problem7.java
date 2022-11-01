package onboarding;

import java.util.*;

public class Problem7 {
    // 기능 목록 1 : user의 친구를 구하는 함수
    public static List<String> findUserFriends(List<List<String>> friends,String user){
        List<String> myfriends = new ArrayList<>();

        for(List<String> friend:friends){
            if(friend.contains(user)){
                if(friend.get(0)==user){
                    myfriends.add(friend.get(1));
                }
                if(friend.get(1)==user){
                    myfriends.add(friend.get(0));
                }
            }
        }
        return myfriends;
    }

    // 기능 목록 2 : 함께 아는 친구를 구하는 함수
    public static List<String> findFriendsOfFriends(List<List<String>> friends, List<String> myfriends, String user){
        List<String> friendsOffriends = new ArrayList<>();

        for(String myfriend:myfriends){
            for(List<String> friend:friends){
                if(friend.contains(myfriend)&&!friend.contains(user)){
                    if(friend.get(0)==myfriend){
                        friendsOffriends.add(friend.get(1));
                    }
                    if(friend.get(1)==myfriend){
                        friendsOffriends.add(friend.get(0));
                    }
                }
            }
        }

        return friendsOffriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
