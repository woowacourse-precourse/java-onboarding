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
    public static boolean checkUserInRecommendScoreList(HashMap<String, Integer> recommendScore, String user) {
        for (int i = 0; i < recommendScore.size(); i++) {
            if (recommendScore.keySet().contains(user)) return true;
        }
        return false;
    }

    // 전달받은 파라미터가 user의 친구인지 확인하는 함수
    public static boolean checkUserInRecommendScoreList(HashMap<String, ArrayList<String>> friendGraph, String user, String other) {
        if (friendGraph.get(user).contains(other)) return true;
        return false;
    }

    // 점수를 갱신할 때 제한조건을 체크하는 함수
    public static boolean checkBeforeAddRecommendScore(HashMap<String, Integer> recommendScore, HashMap<String, ArrayList<String>> friendGraph, String user, String other) {
        return checkUserInRecommendScoreList(recommendScore, user) && checkUserInRecommendScoreList(friendGraph, user, other);
    }
}
