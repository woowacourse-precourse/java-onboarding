package onboarding;

import java.util.*;

public class Problem7 {
    static List<List<String>> friendsForOne = new ArrayList<>();
    static HashMap<String, Integer> index = new HashMap<>();
    static HashMap<String, Integer> score = new HashMap<>();
    /*
        friendsForOne : 한 명당 친구 리스트를 담은 2차원 리스트
        index : 2차원 리스트 접근을 위해 이름을 인덱싱 하기 위한 HashMap
        score : 친구 점수 HashMap
     */

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        int indexNum = 0;   // 인덱싱을 위한 변수


        // 한 명을 기준으로 하는 친구 리스트업, 인덱싱, map 초기화
        for (List<String> l :friends) {
            String friend1 = l.get(0);
            String friend2 = l.get(1);

            indexNum = initFriendsInfo(indexNum, friend1, friend2);

            addFriends(friend1, friend2);
        }

        // 방문 점수 처리
        countVisitScore(visitors);
        return Collections.emptyList();
    }

    static int initFriendsInfo (int indexNum, String friend1, String friend2) {
        if (isNotIndexing(friend1)) {
            friendsForOne.add(new ArrayList<>(List.of(friend1)));    // 친구 리스트업
            index.put(friend1, indexNum++);     // 인덱싱
            score.put(friend1, 0);              // 추천 점수 초기화
        }
        if (isNotIndexing(friend2)) {
            friendsForOne.add(new ArrayList<>(List.of(friend2)));
            index.put(friend2, indexNum++);
            score.put(friend2, 0);
        }
        return indexNum;    // 현재 인덱스 반환
    }

    static boolean isNotIndexing (String s) {
        return index.get(s) == null;
    }

    // 각 친구를 기준으로 친구 관계 추가
    static void addFriends (String friend1, String friend2) {
        friendsForOne.get(index.get(friend1)).add(friend2);
        friendsForOne.get(index.get(friend2)).add(friend1);
    }

    // 방문 점수 처리
    static void countVisitScore (List<String> visitors) {
        for (String s : visitors) {
            score.putIfAbsent(s, 0);
            score.put(s, score.get(s) + 1);
        }
    }
}
