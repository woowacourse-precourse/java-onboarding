package onboarding;

import java.security.PublicKey;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Tuple<HashMap<String, List<String>>, HashMap<String, Integer>> friendsInfos = createFriendsInfos(friends, visitors);
        HashMap<String, List<String>> friendsRelationshipHashMap = friendsInfos.first;
        HashMap<String, Integer> friendsScoreHashMap = friendsInfos.second;

        // 함께 아는 친구의 수에 따른 점수 추가
        relationScore(user, friendsRelationshipHashMap, friendsScoreHashMap);
        // 방문 횟수에 따른 점수 추가
        visitScore(visitors, friendsScoreHashMap);

        return createResult(user, friendsRelationshipHashMap, friendsScoreHashMap);
    }

    public static Tuple<HashMap<String, List<String>>, HashMap<String, Integer>> createFriendsInfos(List<List<String>> friends, List<String> visitors){
        // 친구 관계를 표현하는 friendsRelationshipHashMap 생성
        HashMap<String, List<String>> friendsRelationshipHashMap = new HashMap<>();
        // 추천 점수를 나타내는 friendsScoreHashMap 생성
        HashMap<String, Integer> friendsScoreHashMap = new HashMap<>();

        // 친구관계 정보를 통한 업데이트
        for(List<String> friend: friends){
            friendsRelationshipHashMap.computeIfAbsent(friend.get(0), k-> new ArrayList<>()).add(friend.get(1));
            friendsRelationshipHashMap.computeIfAbsent(friend.get(1), k-> new ArrayList<>()).add(friend.get(0));

            friendsScoreHashMap.putIfAbsent(friend.get(0), 0);
            friendsScoreHashMap.putIfAbsent(friend.get(1), 0);
        }

        // 타임라인 방문 기록을 통한 업데이트
        for (String visitor: visitors){
            friendsScoreHashMap.putIfAbsent(visitor, 0);
        }

        return new Tuple<>(friendsRelationshipHashMap, friendsScoreHashMap);
    }


    public static void relationScore(String user, HashMap<String, List<String>> friendsRelationshipHashMap, HashMap<String, Integer> friendsScoreHashMap){
        List<String> userFriends = friendsRelationshipHashMap.get(user);

        friendsRelationshipHashMap.forEach((name, relationship) -> {
            if(name.equals(user)) return; // 본인은 제외

            if (userFriends.stream().anyMatch(relationship::contains)) {
                friendsScoreHashMap.put(name, friendsScoreHashMap.get(name) + 10);
            };
        });
    }

    public static void visitScore(List<String> visitors, HashMap<String, Integer> friendsScoreHashMap){
        for(String visitor: visitors){
            friendsScoreHashMap.put(visitor, friendsScoreHashMap.get(visitor) + 1);
        }
    }

    public static List<String> createResult(String user, HashMap<String, List<String>> friendsRelationshipHashMap, HashMap<String, Integer> friendsScoreHashMap){
        List<String> userFriends = friendsRelationshipHashMap.get(user);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(friendsScoreHashMap.entrySet());
        List<String> result = new ArrayList<>();

        // 점수순으로 정렬 후, 이름순으로 정렬
        entryList.sort(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));

        for(Map.Entry<String, Integer> entry : entryList){
            // 이미 친구인 경우는 스킵
            if(userFriends.contains(entry.getKey())){
                continue;
            }

            // 0점인 경우 스킵
            if(entry.getValue() == 0){
                continue;
            }

            result.add(entry.getKey());

            // 5명이 되면 반환
            if (result.size() >= 5){
                return result;
            }
        }

        return result;
    }

    public static class Tuple<T1, T2> {
        private T1 first;
        private T2 second;

        public Tuple(T1 first, T2 second){
            this.first = first;
            this.second = second;
        }
    }
}
