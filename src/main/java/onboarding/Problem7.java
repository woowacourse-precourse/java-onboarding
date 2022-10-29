package onboarding;
/*
    기능 목록
    1. 이미 친구인 유저의 목록을 만드는 기능 -> getFriendList
    2. 이 유저가 친구인지 아닌지 확인하는 기능 -> checkFriend
    3. 추천 할 수 있는 유저 목록을 해쉬맵으로 만드는 기능 -> getRecommendList
    4. 목록의 유저들의 추천 점수를 구하는 기능 -> setPoint
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> getFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user))
                friendList.add(friends.get(i).get(1));
            else if (friends.get(i).get(1).equals(user))
                friendList.add(friends.get(i).get(0));
        }
        return friendList;
    }

    private static boolean checkFriend(String name, List<String> friendList) {
        for (int i = 0; i < friendList.size(); i++) {
            if (friendList.get(i).equals(name))
                return true;
        }
        return false;
    }

    private static Map<String, Integer> getRecommendList(String user, List<List<String>> friends, List<String> friendList, List<String> visitors) {
        Map<String, Integer> recommendList = new HashMap<String, Integer>();
        List<String> friend;

        for (int i = 0; i < friends.size(); i++) {
            friend = friends.get(i);
            if (friends.get(0).equals(user) == false && checkFriend(friend.get(0), friendList) == false)
                recommendList.put(friend.get(0), 0);
            if (friends.get(1).equals(user) == false && checkFriend(friend.get(1), friendList) == false)
                recommendList.put(friend.get(1), 0);
        }
        for (int i = 0; i < visitors.size(); i++) {
            if (checkFriend(visitors.get(i), friendList) == false)
                recommendList.put(visitors.get(i), 0);
        }
        return recommendList;
    }

    private static void setPoint(String user, Map<String, Integer> recommendList, List<String> friendList,
                                 List<List<String>> friends, List<String> visitors) {
        List<String> friend;

        for (int i = 0; i < friends.size(); i++) {
            friend = friends.get(i);
            if (friend.get(0).equals(user) || friend.get(1).equals(user))
                continue;
            if (checkFriend(friend.get(0), friendList) == false && checkFriend(friend.get(1), friendList) == true)
                recommendList.put(friend.get(0), recommendList.get(friend.get(0)) + 10);
            else if (checkFriend(friend.get(1), friendList) == false && checkFriend(friend.get(0), friendList) == true)
                recommendList.put(friend.get(1), recommendList.get(friend.get(1)) + 10);
        }
        for (int i = 0; i < visitors.size(); i++) {
            if (checkFriend(visitors.get(i), friendList) == false)
                recommendList.put(visitors.get(i), recommendList.get(visitors.get(i) + 10));
        }
    }
}
