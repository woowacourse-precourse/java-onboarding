package onboarding.problem7.domain;

import java.util.ArrayList;

public class User {
    private final String name;
    private ArrayList<String> friendList = new ArrayList<>();

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addFriend(String friendName){
        friendList.add(friendName);
    }

    public ArrayList<String> getFriendList() {
        return friendList;
    }
}
