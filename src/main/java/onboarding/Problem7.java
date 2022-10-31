package onboarding;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;


public class Problem7 {
    // 친구 관계가 데이터로 있는 friends 리스트를 활용하기 좋은 Map 형태로 변환하는 메소드
    public static Map<String, ArrayList<String>> convertToMap(List<List<String>> friends) {
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();

        for(List<String> friend : friends) {        // 양방향성 친구 관계를 모두 추가함
            ArrayList<String> firstFriendList = friendsMap.getOrDefault(friend.get(0), new ArrayList<>());
            firstFriendList.add(firstFriendList.size(), friend.get(1));
            friendsMap.put(friend.get(0), firstFriendList);

            ArrayList<String> secondFriendList = friendsMap.getOrDefault(friend.get(1), new ArrayList<>());
            secondFriendList.add(secondFriendList.size(), friend.get(0));
            friendsMap.put(friend.get(1), secondFriendList);
        }

        return friendsMap;
    }

    // 함께 아는 친구는 추천 점수를 10점 더해주는 메소드
    public static void plusAcquaintanceScore(String user, Map<String, ArrayList<String>> friendsMap, Map<String, Integer> scoreMap) {
        for(String friendOfUser : friendsMap.get(user)) {
            for(String foundedFriend : friendsMap.get(friendOfUser)) {
                if (friendsMap.get(user).contains(foundedFriend) || foundedFriend.equals(user)) {
                    continue;
                }
                scoreMap.put(foundedFriend, scoreMap.getOrDefault(foundedFriend, 0) + 10);
            }
        }
    }

    // 타임 라인 방문자에게 1점 더해주는 메소드
    public static void plusVisitTimelineScore(String visitor, Map<String, Integer> scoreMap) {
        scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
    }

    // 점수로 먼저 정렬을 하고 점수가 동일하면 이름순으로 정렬하는 메소드
    public static List<Map.Entry<String, Integer>> applySort(Map<String, Integer> scoreMap) {
        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(scoreMap.entrySet());

        Collections.sort(scoreList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                if (entry1.getValue() == entry2.getValue()) {
                    return entry1.getKey().compareTo(entry2.getKey());
                } else {
                    return entry2.getValue() - entry1.getValue();
                }
            }
        });

        return scoreList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> friendsMap = convertToMap(friends);
        Map<String, Integer> scoreMap = new HashMap<>();

        plusAcquaintanceScore(user, friendsMap, scoreMap);        // 함께 아는 친구 점수 +10

        for(String visitor : visitors) {
            if (friendsMap.get(user).contains(visitor)) {
                continue;
            }
            plusVisitTimelineScore(visitor, scoreMap);            // 타임 라인 방문자 점수 +1
        }

        for(Map.Entry<String, Integer> recommendedFriend : applySort(scoreMap)) {
            answer.add(answer.size(), recommendedFriend.getKey());

            if (answer.size() == 5) {
                break;        // 최대 추천해줄 수 있는 친구의 수는 5명으로 제한
            }
        }

        return answer;
    }
}