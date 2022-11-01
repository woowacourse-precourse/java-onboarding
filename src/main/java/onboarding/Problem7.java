package onboarding;
/***
 * 기능목록
 * 1. 친구관계 그래프 생성
 * 2. 사용자의 친구 리스트 생성
 * 3. 사용자와 함께 아는 친구 수 카운팅
 * 4. 추천 점수 계산(방문자 포함)
 * 5. 추천 점수 기준 정렬후 키값 반환
 */

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, ArrayList<String>> friendGraph = new HashMap<>();
        ArrayList<String> userFriendList = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();

        friendGraph = getFriendGraph(friends);
        userFriendList = getFriendList(user, friendGraph);
        score = calScore(user, userFriendList, friendGraph, visitors);
        answer = sortScore(score);
        return answer;
    }

    public static HashMap<String, ArrayList<String>> getFriendGraph(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> friendGraph = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            String f1 = friends.get(i).get(0);
            String f2 = friends.get(i).get(1);

            if (friendGraph.get(f1) == null) {
                friendGraph.put(f1, new ArrayList<String>());
            }
            friendGraph.get(f1).add(f2);

            if (friendGraph.get(f2) == null) {
                friendGraph.put(f2, new ArrayList<String>());
            }
            friendGraph.get(f2).add(f1);
        }
        return friendGraph;
    }

    public static ArrayList<String> getFriendList(String user, HashMap<String, ArrayList<String>> friendGraph) {
        ArrayList<String> friendList = new ArrayList<>();
        friendList = friendGraph.get(user);

        return friendList;
    }

    public static int findNearFriend(ArrayList<String> userFriendList, ArrayList<String> otherFriendList) {
        int cnt = 0;
        for (int i = 0; i < userFriendList.size(); i++) {
            if (otherFriendList.contains((userFriendList.get(i)))) cnt++;
        }
        return cnt;
    }

    public static HashMap<String, Integer> calScore(String user,
                                                    ArrayList<String> userFriendList,
                                                    HashMap<String, ArrayList<String>> friendGraph,
                                                    List<String> visitors) {
        HashMap<String, Integer> score = new HashMap<>();
        int otherScore = 0;

        for (String key : friendGraph.keySet()) {
            if (key == user) continue;
            String other = key;
            ArrayList<String> otherFriendList = getFriendList(other, friendGraph);
            int friendNum = findNearFriend(userFriendList, otherFriendList);
            otherScore = 10 * friendNum;
            score.put(other, otherScore);
        }

        for (String visitor : visitors) {
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }

        for (int i = 0; i < userFriendList.size(); i++) {
            if (score.containsKey(userFriendList.get(i))) {
                score.remove(userFriendList.get(i));
            }
        }
        return score;
    }

    public static List<String> sortScore(HashMap<String, Integer> score) {

    }

