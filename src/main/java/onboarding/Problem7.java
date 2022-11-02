package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, List<String>> friendsListMap = new HashMap<String, List<String>>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        // 친구 ListMap / List<List<String> -> Map<String, List> 변환
        friendsListMap = listToMap(friends);

        // 추천 친구 점수계산
        Map<String, Integer> recommendScore = withFriendsScore(user);

        // 타임라인 방문 친구 점수계산
        recommendScore = timelineVisitorCount(user, visitors, recommendScore);

        // 본인 삭제
        recommendScore.remove(user);

        // 본인친구 제외 & 정렬
        answer = recommendScore.entrySet().stream().filter(f -> !friendsListMap.get(user).contains(f.getKey())).sorted(Map.Entry.comparingByKey()).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(f -> f.getKey()).limit(5).collect(Collectors.toList());

        return answer;
    }

    public static Map<String, List<String>> listToMap(List<List<String>> friends){

        Map<String, List<String>> friendsListMap = new HashMap<String, List<String>>();

        for(List<String> friend : friends){
            if(friendsListMap.containsKey(friend.get(0))){
                friendsListMap.get(friend.get(0)).add(friend.get(1));
            }else{
                friendsListMap.put(friend.get(0), new ArrayList<String>(Collections.singleton(friend.get(1))));
            }

            if(friendsListMap.containsKey(friend.get(1))){
                friendsListMap.get(friend.get(1)).add(friend.get(0));
            }else{
                friendsListMap.put(friend.get(1), new ArrayList<String>(Collections.singleton(friend.get(0))));
            }
        }
        return friendsListMap;
    }

    public static Map<String, Integer> withFriendsScore(String user){

        Map<String, Integer> recommendScore = new HashMap<String, Integer>();

        // 함께아는 친구 점수
        for(String userFriend : friendsListMap.get(user)){
            for(String friendName : friendsListMap.get(userFriend)){
                if(recommendScore.containsKey(friendName)){
                    recommendScore.put(friendName, recommendScore.get(friendName) + 10);
                }else{
                    recommendScore.put(friendName, 10);
                }
            }
        }

        return recommendScore;
    }

    public static Map<String, Integer> timelineVisitorCount(String user, List<String> visitors, Map<String, Integer> recommendScore){

        // 타임라인 방문 횟수
        for(String visitor : visitors){
            if(!friendsListMap.get(user).contains(visitor)) {
                if (recommendScore.containsKey(visitor)) {
                    recommendScore.put(visitor, recommendScore.get(visitor) + 1);
                } else {
                    recommendScore.put(visitor, 1);
                }
            }
        }

        return recommendScore;
    }
}
