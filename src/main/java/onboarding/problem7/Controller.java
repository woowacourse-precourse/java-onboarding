package onboarding.problem7;

import java.util.List;

public class Controller {
    public static List<String> getSolution(String user, List<List<String>> friends, List<String> visitors) {
        Relations relation = new Relations(friends);
        Visitors visitor = new Visitors(visitors);
        List<String> distinctFriends = Friend.getDistinctFriends(relation);
        List<String> distinctVisitors = Visitors.getDistinctVisitors();
        Friend.initID(distinctFriends, distinctVisitors);
        Friend.initWeight();
        List<String> myFriends = Friend.getFriendsList(relation, user);

        for (int i = 0; i < myFriends.size(); i++) {
            List<String> acquaintance = Friend.getFriendsList(relation, myFriends.get(i));
            Friend.addWeight(acquaintance, Constant.FRIEND_WEIGHT);
        }
        Friend.addWeight(visitors, Constant.VISITOR_WEIGHT);
        List<String> recommendedList = Friend.recommendedList(user);
        List<String> friendList = Friend.getFriendsList(relation, user);
        for (int i = 0; i < recommendedList.size(); i++) {
            String person = recommendedList.get(i);
            if (friendList.contains(person)) {
                recommendedList.remove(person);
            }
        }
        return recommendedList;
    }
}
