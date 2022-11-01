package onboarding.problem7;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class User {

    private final String name;

    private HashSet<String> friendNames;
    private List<String> visitedUserNames;

    public User(String userName){
        this.name = userName;
        friendNames = new HashSet<>();
        visitedUserNames = new LinkedList<>();
    }

    public void addFriend(String friendUserName){
        friendNames.add(friendUserName);
    }

    public void addVisitedUser(String visitedUserName){
        visitedUserNames.add(visitedUserName);
    }

    public String getName(){
        return name;
    }

    public HashSet<String> getFriendNames(){
        return friendNames;
    }

    public List<String> getVisitedUserNames(){
        return visitedUserNames;
    }
}
