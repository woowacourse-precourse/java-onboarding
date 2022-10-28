package onboarding.problem7;


import java.util.HashMap;
import java.util.List;

public class SNSController {

    private HashMap<String, User> users;

    public SNSController(){
        users = new HashMap<>();
    }

    public void addUser(String userName){
        users.put(userName, new User(userName));
    }

    public void addFriend(String userName1, String userName2){
        if(!users.containsKey(userName1)){
            addUser(userName1);
        }
        if(!users.containsKey(userName2)){
            addUser(userName2);
        }

        addFriend(users.get(userName1), userName2);
        addFriend(users.get(userName2), userName1);
    }

    private void addFriend(User user, String friendName){
        user.addFriend(friendName);
        users.put(user.getName(), user);
    }

    public void addVisitor(String userName, String visitedUserName){
        User user = users.get(userName);
        user.addVisitedUser(visitedUserName);
        users.put(userName, user);
    }

    public void addVisitors(String userName, List<String> visitedUserNames){
        User user = users.get(userName);
        for(String visitedUserName : visitedUserNames){
            user.addVisitedUser(visitedUserName);
        }
        users.put(userName, user);
    }

    private class FriendRecommendPoint {

        private final String name;
        private int point;

        public FriendRecommendPoint(String name){
            this.name = name;
            point = 0;
        }

        public void addPoints(int point){
            this.point += point;
        }

        public int getPoint(){
            return point;
        }

        public String getName(){
            return name;
        }
    }

}
