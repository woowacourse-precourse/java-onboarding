package onboarding.problem7;


import java.util.*;
import java.util.stream.Collectors;

public class SNSController {

    private HashMap<String, User> users;

    private static final int FRIENDS_FRIEND_RECOMMEND_POINT = 10;
    private static final int VISITED_USER_RECOMMEND_POINT = 1;

    public SNSController(){
        users = new HashMap<>();
    }

    public List<String> findRecommendUser(String userName){
        HashMap<String, RecommendPoint> recommendPoints = new HashMap<>();

        List<RecommendPoint> friendPoints = generateFriendRecommendPoint(userName);
        addPointsToHashMap(recommendPoints, friendPoints);
        List<RecommendPoint> visitorPoints = generateVisitorRecommendPoint(userName);
        addPointsToHashMap(recommendPoints, visitorPoints);
        removeMyFriends(userName, recommendPoints);

        return getRecommendedUserNames(recommendPoints);

    }

    private List<String> getRecommendedUserNames(HashMap<String, RecommendPoint> recommendPoints) {

        List<RecommendPoint> points = new ArrayList<>(recommendPoints.values());
        Collections.sort(points);

        if(points.size() > 5){
            points = points.subList(0, 5);
        }

        return points.stream().map(p -> p.getName()).collect(Collectors.toList());
    }

    private void addPointsToHashMap(HashMap<String, RecommendPoint> pointHasMap, List<RecommendPoint> points){
        for(RecommendPoint point : points){
            addPointToHashMap(pointHasMap, point);
        }
    }

    private void addPointToHashMap(HashMap<String, RecommendPoint> pointHashMap, RecommendPoint point){
        if(pointHashMap.containsKey(point.getName())){
            RecommendPoint originalPoint = pointHashMap.get(point.getName());
            originalPoint.addPoints(point.getPoint());
            pointHashMap.put(point.getName(), originalPoint);
            return;
        }
        pointHashMap.put(point.getName(), point);
    }

    private void removeMyFriends(String userName, HashMap<String, RecommendPoint> points){
        User user = users.get(userName);
        List<String> myFriends = new LinkedList<>(user.getFriendNames());
        for(String myFriend : myFriends){
            if(points.containsKey(myFriend)){
                points.remove(myFriend);
            }
        }
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
            HashSet<String> friendNames = friend.getFriendNames();
            friendNames.remove(userName);
            friendsFriend.addAll(friendNames);
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
        if(!users.containsKey(userName)){
            addUser(userName);
        }
        User user = users.get(userName);
        for(String visitedUserName : visitedUserNames){
            if(!users.containsKey(visitedUserName)){
                addUser(visitedUserName);
            }
            user.addVisitedUser(visitedUserName);
        }
        users.put(userName, user);
    }

}
