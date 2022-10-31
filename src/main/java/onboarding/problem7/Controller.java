package onboarding.problem7;

import java.util.List;

public class Controller {

    public static List<String> getSolution(String user, List<List<String>> friends, List<String> visitors) {
        if (Validation.check(user, friends, visitors)) {
            Relations relation = new Relations(friends);
            Visitors visitor = new Visitors(visitors);
            init(relation, visitor);
            List<String> myFriends = relation.getFriendsList(user);
            for (int i = 0; i < myFriends.size(); i++) {
                List<String> acquaintance = relation.getFriendsList(myFriends.get(i));
                Friend.addWeight(acquaintance, Constant.FRIEND_WEIGHT);
            }
            Friend.addWeight(visitors, Constant.VISITOR_WEIGHT);
            List<String> recommendedList = Friend.getRecommendedList(user, myFriends);
            recommendedList.removeAll(myFriends);
            return recommendedList;
        }
        return Constant.EXCEPTION;
    }

    private static void init(Relations relation, Visitors visitor) {
        List<String> distinctFriends = relation.getDistinctFriends();
        List<String> distinctVisitors = visitor.getDistinctVisitors();
        Friend.initID(distinctFriends);
        Friend.initID(distinctVisitors);
    }
}
