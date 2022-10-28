package onboarding;

import java.util.*;

public class Problem7 {
    /* 친구 관계를 활용하기 쉽도록 Map으로 변환하는 메소드 */
    public static Map<String, ArrayList<String>> makeFriendMap(List<List<String>> friends) {
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();

        // friends 리스트에 주어진 친구 관계를 Map으로 변환
        for(List<String> friend : friends) {
            // 첫 번째 친구의 친구 리스트에 두 번쨰 친구를 입력
            if(friendsMap.containsKey(friend.get(0))) {    // nullPointException
                friendsMap.get(friend.get(0)).add(friendsMap.get(friend.get(0)).size(), friend.get(1));
            } else {
                friendsMap.put(friend.get(0), new ArrayList<>());
                friendsMap.get(friend.get(0)).add(friendsMap.get(friend.get(0)).size(), friend.get(1));
            }

            // 두 번째 친구의 친구 리스트에 첫 번쨰 친구를 입력
            if(friendsMap.containsKey(friend.get(1))) {    // nullPointException
                friendsMap.get(friend.get(1)).add(friendsMap.get(friend.get(1)).size(), friend.get(0));
            } else {
                friendsMap.put(friend.get(1), new ArrayList<>());
                friendsMap.get(friend.get(1)).add(friendsMap.get(friend.get(1)).size(), friend.get(0));
            }
        }

        return friendsMap;
    }

    public static List<Map.Entry<String, Integer>> makeScoreList(Map<String, ArrayList<String>> friendsMap, String user, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();

        // 사용자와 함께아는 친구 +10점
        for(String friend : friendsMap.keySet()) {
            if(friend.equals(user) || friendsMap.getOrDefault(user, new ArrayList<>()).contains(friend)) {
                continue;    // user 본인, 이미 친구인 사람 제외
            }

            int score = 0;
            for(String userFriend : friendsMap.getOrDefault(user, new ArrayList<>())) {
                if(friendsMap.get(friend).contains(userFriend)) { // 함께 아는 친구가 존재하면 10점이 주어집니다
                    score += 10;
                    scoreMap.put(friend, score);
                }
            }
        }

        // 사용자의 타임라인 방문횟수 +1점
        for(String visitor : visitors) {
            if(friendsMap.getOrDefault(user, new ArrayList<>()).contains(visitor)) {
                continue;    // 이미 방문자와 친구라면 추천 친구에서 제외
            }
            int score = scoreMap.getOrDefault(visitor, 0) + 1;    // 함께아는 친구 점수에 이어서 +1
            scoreMap.put(visitor, score);
        }

        // 정렬: 점수는 내림차순으로 정렬하고 점수가 같으면 이름으로 오름차순 정렬
        List<Map.Entry<String, Integer>> friendsScoreList = new ArrayList<>(scoreMap.entrySet());
        Collections.sort(friendsScoreList, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                if(entry2.getValue() - entry1.getValue() == 0) {    // 점수가 같을 때는 이름(key)로 오름차순정렬
                    return entry1.getKey().compareTo(entry2.getKey());
                } else {    // 점수가 다를 때는 점수(value)로 내림차순 정렬
                    return entry2.getValue() - entry1.getValue();
                }
            }
        });

        return friendsScoreList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, ArrayList<String>> friendsMap = makeFriendMap(friends);    // 친구 관계를 정리할 Map 선언
        List<Map.Entry<String, Integer>> friendsScoreList = makeScoreList(friendsMap, user, visitors);    // 추천 친구 점수 리스트

        for(int i = 0; i < friendsScoreList.size(); i++) {
            if(i == 5) {
                break; // answer 에는 최대 5명 제한
            }
            answer.add(i, friendsScoreList.get(i).getKey());
        }

        return answer;
    }
}