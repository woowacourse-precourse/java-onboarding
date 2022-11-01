package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class UsersInfo {
    private String user;
    private List<List<String>> friends;
    private List<String> usersFriends;
    private List<String> visitors;
    private  List<String> recomendFriends;

    public void setUser(String name) {
        user = name;
    }

    public void setFriends(List<List<String>> list) {
        friends = list;
    }

    public void setVisitors(List<String> list) {
        visitors = list;
    }

    public String getUser() {
        return user;
    }

    public List<List<String>> getFriends() {
        return friends;
    }

    public List<String> getUsersFriends() {
        return usersFriends;
    }

    public List<String> getVisitors() {
        return visitors;
    }

    public List<String> getRecomendFriends() {
        return recomendFriends;
    }
}

class Friends extends UsersInfo {
    private List<String> friendsFriend = new ArrayList<>();

    public void findUsersFriends(){
        List<String> usersFriends = getFriends().stream()
                .filter(friendList -> friendList.contains(getUser()))
                .map(friendList -> friendList.get(findFriendsIndex(getUser(),friendList)))
                .collect(Collectors.toList());

    }

    public void findFriendsFriend() {
        Iterator<String> iterator = getUsersFriends().iterator();
        while (iterator.hasNext()) {
            String friend = iterator.next();
            List<String> list = getFriends().stream()
                    .filter(friends -> friends.contains(friend))
                    .map(friends -> friends.get(findFriendsIndex(friend, friends)))
                    .distinct()
                    .collect(Collectors.toList());
            friendsFriend = list;
        }
    }
    private int findFriendsIndex(String user, List<String> friendList) {
        return friendList.get(0).equals(user) ? 1 : 0;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
