package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * [ ] 친구 추천 규칙에 따라 점수가 가장 높은 순으로 5명을 return한다.
 * [ ] 추천 점수가 0인 경우에는 추천하지 않는다.
 * [ ] 추천 점수가 같은 경우에는 이름 순으로 정렬한다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendsOfUser = makeListOfFriendsUser(user, friends);

        HashMap<String, Integer> recommendScore = new HashMap<>();
        recommendScore = getScoreByKnowEachOther(user, friends, friendsOfUser, recommendScore);

        System.out.println(recommendScore);
        return friendsOfUser;
    }

    public static List<String> makeListOfFriendsUser(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>();

        for (List<String> relation : friends) {
            if (relation.contains(user)) {
                friendsOfUser.addAll(relation);
            }
        }
        friendsOfUser.remove(user);

        return friendsOfUser;
    }

    public static HashMap<String, Integer> getScoreByKnowEachOther(String user, List<List<String>> friends, List<String> friendsOfUser, HashMap<String, Integer> recommendScore) {
        for (List<String> relation : friends) {
            String friendA = relation.get(0);
            String friendB = relation.get(1);

            if (friendA.equals(user) || friendB.equals(user)) continue;

            if (friendsOfUser.contains(friendA) && !recommendScore.containsKey(friendB))
                recommendScore.put(friendB, 10);
            if (friendsOfUser.contains(friendA) && recommendScore.containsKey(friendB))
                recommendScore.put(friendB, recommendScore.get(friendB) + 10);

            if (friendsOfUser.contains(friendB) && !recommendScore.containsKey(friendA))
                recommendScore.put(friendA, 10);
            if (friendsOfUser.contains(friendB) && recommendScore.containsKey(friendA))
                recommendScore.put(friendA, recommendScore.get(friendA) + 10);
        }

        return recommendScore;
    }
}
