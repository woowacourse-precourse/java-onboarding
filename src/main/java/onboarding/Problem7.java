package onboarding;
import java.util.*;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    static Map<String, Integer> friendScoreDict = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriends = new ArrayList<>();
        // friends 에서 사용자와 친구인 유저를 리스트에 저장
        for (List<String> friendRelations : friends) {
            if(friendRelations.get(0) == user) userFriends.add(friendRelations.get(1));
            else if(friendRelations.get(1) == user) userFriends.add(friendRelations.get(0));
        }

        // 이미 친구가 아닌 사용자 중에 친구가 겹치면 10점
        for (List<String> friendRelations : friends) {
            String userA = friendRelations.get(0);
            String userB = friendRelations.get(1);
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
        // 정렬을 위해서 List 형태로 Map을 가져옴
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendScoreDict.entrySet());
        // 이름순으로 정렬, 점수순으로 내림차순 정렬
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        // 최대 반복 횟수
        int count = 5;
        List<String> resultList = new ArrayList<>();
        // 점수 순대로 정렬된 Map에서 이름을 하나씩 리스트에 저장. (최대 5번 반복)
        for(Map.Entry<String, Integer> entry : entryList) {
            resultList.add(entry.getKey());
            count--;
            if(count <= 0) break;
        }
        return resultList;
    }

    // 점수 딕셔너리에 이미 있는 유저면 score업데이트, 없으면 새로 추가
    static void putScoreDict(String name, int score) {
        if(friendScoreDict.containsKey(name))
            score += friendScoreDict.get(name);
        friendScoreDict.put(name, score);
    }
}