package onboarding.problem7.domain;

import java.util.ArrayList;

public class User {
    private final String name;
    private ArrayList<String> friendList = new ArrayList<>();

    public User(String name){
        this.name = name;
    }

    public void addFriend(String friendName){
        friendList.add(friendName);
    }

    public boolean isFriend(String name){
        return friendList.contains(name);
    }

    public ArrayList<String> getFriendList() {
        return friendList;
    }
}
