package onboarding;

import java.util.*;

public class Problem7 {
    // 친구 추천 점수를 저장할 딕셔너리
    static Map<String, Integer> friendScoreDict = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // 사용자의 친구를 저장할 리스트
        List<String> userFriends = new ArrayList<>();
        // friends 에서 사용자와 친구인 유저를 리스트에 저장
        for (List<String> friendRelations : friends) {
            if(friendRelations.get(0) == user) userFriends.add(friendRelations.get(1));
            else if(friendRelations.get(1) == user) userFriends.add(friendRelations.get(0));
        }

        // 이미 친구가 아닌 사용자 중에 친구가 겹치면 10점
        for (List<String> friendRelations : friends) {
            String userA = userFriends.get(0);
            String userB = userFriends.get(1);
            if(userA == user || userB == user) continue;
            if(userFriends.contains(userA) && !userFriends.contains(userB)) {
                putScoreDict(userB, 10);
            }
            else if(userFriends.contains(userB) && !userFriends.contains(userA)) {
                putScoreDict(userA, 10);
            }
        }

        // 방문한 사람의 점수를 딕셔너리에 저장 및 업데이트
        for (String visitor : visitors) {
            // 이미 친구라면 스킵
            if(userFriends.contains(visitor)) continue;
            putScoreDict(visitor, 1);
        }
        return answer;
    }

    // 점수 딕셔너리에 이미 있는 유저면 score업데이트, 없으면 새로 추가
    static void putScoreDict(String name, int score) {
        if(friendScoreDict.containsKey(name))
            score += friendScoreDict.get(name);
        friendScoreDict.put(name, score);
    }
}
