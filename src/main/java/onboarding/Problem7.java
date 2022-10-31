package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Set<String>> friendMap = getFriendMap(friends);

        Set<String> userFriends = getUserFriends(user, friendMap);

        Map<String, Integer> friendScore = new HashMap<>();

        togetherKnownScore(user, friendMap, userFriends, friendScore);

        visitScore(visitors, userFriends, friendScore);

        return makeResult(friendScore);
    }
    /*
    이름에 연결된 친구 관계 집합 Map
    @param friends : 친구 관계 정보
    @return 친구 이름에 관계되어 있는 사람 집합 반환
    */
    private static Map<String, Set<String>> getFriendMap(List<List<String>> friends){

        Map<String, Set<String>> map = new HashMap<>();

        for(List<String> list: friends){
            String name1 = list.get(0);
            String name2 = list.get(1);

            if(!map.containsKey(name1)){
                map.put(name1, new HashSet<>());
            }
            if(!map.containsKey(name2)){
                map.put(name2, new HashSet<>());
            }

            map.get(name1).add(name2);
            map.get(name2).add(name1);
        }

        return map;
    }

    /*
    @param user : 사용자 이름
    @param map : 친구 관계 맵
    @return user의 친구 목록
     */
    private static Set<String> getUserFriends(String user, Map<String, Set<String>> map){
        return map.get(user);
    }

    /*
    @param user : 추천 받을 대상 이름
    @param map : 친구 관계 맵
    @param userFriends : 사용자 친구 목록
    @param score : 갱신할 친구 이름-점수 맵
     */
    private static void togetherKnownScore(String user, Map<String, Set<String>> map, Set<String> userFriends, Map<String, Integer> score){
        for(String name : map.keySet()){
            if(name.equals(user)) continue;

            for (String uname : map.get(name)){
                if(userFriends.contains(uname)){
                    score.put(name, score.getOrDefault(name, 0) + 10);
                }
            }
        }
    }

    /*
    @param visitors : 방문한 사람
    @param userFriends : 방문한 사람 친구 목록
    @param score : 갱신할 이름 - 점수 관계 맵
     */
    private static void visitScore(List<String> visitors, Set<String> userFriends, Map<String, Integer> score) {
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    /*
    추천 점수가 같은 경우 이름 순 정렬
    @param recommendList : 정렬할 추천 리스트
    @return 이름 순 정렬된 추천 리스트
     */
    private static List<String> makeResult (Map<String, Integer> recommendList) {
        return recommendList.keySet().stream().sorted((o1, o2) -> {
            if (recommendList.get(o1) > recommendList.get(o2)) {
                return -1;
            } else if (recommendList.get(o1) < recommendList.get(o2)) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        }).limit(5).collect(Collectors.toList());
    }

}

