package onboarding.problem7;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SNSController {

    private HashMap<String, User> users;

    private static final int FRIENDS_FRIEND_RECOMMEND_POINT = 10;
    private static final int VISITED_USER_RECOMMEND_POINT = 1;

    public SNSController(){
        users = new HashMap<>();
    }



    private List<RecommendPoint> generateVisitorRecommendPoint(String userName){
        User user = users.get(userName);
        List<String> visitorsName = user.getVisitedUserNames();
        return generateRecommendPoints(visitorsName, VISITED_USER_RECOMMEND_POINT);
    }

    private List<RecommendPoint> generateFriendRecommendPoint(String userName){
        List<String> friendsFriendNames = findFriendsFriend(userName);
        return generateRecommendPoints(friendsFriendNames, FRIENDS_FRIEND_RECOMMEND_POINT);
    }

    private List<RecommendPoint> generateRecommendPoints(List<String> recommendUserNames, int point) {

        List<RecommendPoint> recommendPoints = new LinkedList<>();

        for(String recommendUserName : recommendUserNames){
            RecommendPoint recommendPoint = new RecommendPoint(recommendUserName);
            recommendPoint.addPoints(point);
            recommendPoints.add(recommendPoint);
        }
        return recommendPoints;
    }

    private List<String> findFriendsFriend(String userName){
        List<String> friendsFriend = new LinkedList<>();
        User user = users.get(userName);
        for(String friendName : user.getFriendNames()){
            User friend = users.get(friendName);
            friendsFriend.addAll(friend.getFriendNames());
        }
        return friendsFriend;
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

    private class RecommendPoint implements Comparable<RecommendPoint>{

        private final String name;
        private int point;

        public RecommendPoint(String name){
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

        @Override
        public int compareTo(RecommendPoint o) {
            return this.point - o.getPoint();
        }
    }

}
