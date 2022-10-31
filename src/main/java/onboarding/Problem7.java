package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, ArrayList<String>> friendGraph = initFriendGraph(friends);
        HashMap<String, Integer> recommendScore = initRecommendScoreList();
        AddRecommendScoreOfFriends(recommendScore, friendGraph, user);
        System.out.println(recommendScore);
        return answer;
    }

    // 친구관계를 저장할 HashMap을 초기화하는 함수
    public static HashMap<String, ArrayList<String>> initFriendGraph(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> friendGraph = new HashMap<String, ArrayList<String>>();
        for (List<String> friend : friends) addFriends(friendGraph, friend);
        return friendGraph;
    }

    // 친구관계를 추가하는 함수
    public static void addFriends(HashMap<String, ArrayList<String>> friendGraph, List<String> friend) {
        for (int i = 0; i < 2; i++) {
            if (!friendGraph.keySet().contains(friend.get(i%2))) {
                ArrayList<String> friendList = new ArrayList<String>();
                friendGraph.put(friend.get(i%2), friendList);
            }
            friendGraph.get(friend.get(i%2)).add(friend.get((i+1) % 2));
            }
    }

    // user의 추천친구에 대한 정보를 저장할 ArrayList를 초기화하는 함수
    public static HashMap<String, Integer> initRecommendScoreList() {
        return new HashMap<String, Integer>();
    }

    // user의 추천친구 리스트에 파라미터로 전달된 유저가 있는지 확인하는 함수
    public static boolean checkUserInRecommendScoreList(HashMap<String, Integer> recommendScore, String other) {
        return recommendScore.keySet().contains(other);
    }

    // 전달받은 파라미터가 user의 친구인지 확인하는 함수
    public static boolean checkUserFriends(HashMap<String, ArrayList<String>> friendGraph, String user, String other) {
        return friendGraph.get(user).contains(other);
    }

    // 점수를 갱신할 때 제한조건을 체크하는 함수
    public static boolean checkBeforeAddRecommendScore(HashMap<String, Integer> recommendScore, HashMap<String, ArrayList<String>> friendGraph, String user, String other) {
        return user.equals(other) || checkUserFriends(friendGraph, user, other);
    }

    // 함께 아는 친구의 수에 따라 점수를 추가하는 함수
    public static void AddRecommendScoreOfFriends(HashMap<String, Integer> recommendScore, HashMap<String, ArrayList<String>> friendGraph, String user) {
        // 함께 아는 친구: other, 친구: friend
        for (String friend: friendGraph.get(user)) {
            if (!friendGraph.containsKey(friend)) continue;
            for (String other: friendGraph.get(friend)) {

                // 추천친구 list에 추가할지 말지 체크
                if (checkBeforeAddRecommendScore(recommendScore, friendGraph, user, other)) continue;

                // 추천친구 list에 other가 없다면 이를 추가
                if (!checkUserInRecommendScoreList(recommendScore, other)) recommendScore.put(other, 0);

                recommendScore.replace(other, recommendScore.get(other) + 10);

            }
        }
    }
}
