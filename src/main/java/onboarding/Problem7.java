package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, ArrayList<String>> friendGraph = initFriendGraph();
        ArrayList<HashMap<String, Integer>> recommendScoreList = initRecommendScoreList();
        return answer;
    }

    // 친구관계를 저장할 HashMap을 초기화하는 함수
    public static HashMap<String, ArrayList<String>> initFriendGraph() {
        return new HashMap<String, ArrayList<String>>();
    }

    // 친구관계를 추가하는 함수
    public static void addFriends(HashMap<String, ArrayList<String>> friendGraph, ArrayList<String> friends) {
        for (int i = 0; i < 2; i++) {
            if (friendGraph.keySet().contains(friends.get(i%2))) {
                friendGraph.get(friends.get(i%2)).add(friends.get((i+1) % 2));
            }
        }
    }

    // user의 추천친구에 대한 정보를 저장할 ArrayList를 초기화하는 함수
    public static ArrayList<HashMap<String, Integer>> initRecommendScoreList() {
        return new ArrayList<HashMap<String, Integer>>();
    }
}
