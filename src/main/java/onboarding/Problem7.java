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

        // 함께 아는 친구 점수 처리
        countFriendsScore(user);

        // 사용자 본인인 경우와 친구인 경우 제외
        exceptScore(user);

        // 정렬 기준으로 정렬 후 결과 리스트 반환
        return sortFriends();
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

    // 함께 아는 친구 점수 처리
    static void countFriendsScore (String user) {
        for (String s1 : friendsForOne.get(index.get(user))) {
            for (String s2 : friendsForOne.get(index.get(s1))) {
                score.put(s2, score.get(s2) + 10);
            }
        }
    }

    // 사용자 본인인 경우와 친구인 경우 제외
    static void exceptScore (String user) {
        for (String s1 : friendsForOne.get(index.get(user)))
            score.put(s1, 0);
    }

    // 정렬 기준으로 정렬 후 결과 리스트 반환
    static List<String> sortFriends () {
        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(score.entrySet());


        // 친구 점수의 오름차순으로 정렬하며 친구 점수가 같으면, 이름순으로 정렬
        scoreList.sort((o1, o2) -> {
            if (isScoreEqual (o1.getValue(), o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            if (o1_isSmallerThan_o2 (o1.getValue(), o2.getValue()))
                return 1;
            return -1;
        });

        return extractFrinedsMax5(scoreList);
    }

    static boolean isScoreEqual (int n, int m) { return n == m; }
    static boolean o1_isSmallerThan_o2 (int n, int m) { return n < m; }

    // 최대 다섯명까지, 우선 순위 기준에 따른 추천 친구 배열 반환
    static List<String> extractFrinedsMax5 (List<Map.Entry<String, Integer>> scoreList) {
        List<String> sortedFriends = new ArrayList<>();
        int cnt = 5;
        for (Map.Entry<String, Integer> entry : scoreList) {
            if (scoreIsZero(entry.getValue()) || isCountOver(cnt)) break;
            sortedFriends.add(entry.getKey());
            cnt--;
        }
        return sortedFriends;
    }
    static boolean scoreIsZero (int n) { return n == 0; }
    static boolean isCountOver (int n) { return n == 0; }
}