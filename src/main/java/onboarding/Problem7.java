package onboarding;

import java.util.*;


/*
* 기능 목록
* 1. 사용자의 이름과 친구관계 목록을 입력받아 직접 아는 친구 리스트를 반환하는 createDirectFriends() 메서드
* 2. 직접 아는 친구 리스트와 친구 관계 목록을 입력받아 함께 아는 친구에 대한 점수를 scoremap에 추가하는 findMutualFriends() 메서드
* 3. 각각의 친구 관계와 직접 아는 친구 한 명을 입력받아 검사하고 scoreMap에 점수를 추가하는 scoreMutualFriends() 메서드
* 4. 방문자 리스트와, 점수를 저장하는 scoreMap을 입력받아 방문자에 대한 점수를 추가하는 scoreVisitedFriends() 메서드
* 5. 사람 별 점수를 저장한 scoreMap을 입력받아 점수 순으로 내림차순 정렬된 사람 리스트를 반환하는 createSortedFriendsName() 메서드
* 6. 위 결과와 본인 사용자인 user, 직접 아는 친구은 directFriends를 입력받아 결과 (최대 5명의 추천받을 친구)를 반환하는 chooseFiveFriends() 메서드
* */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>();

        List<String> directFriends = createDirectFriends(user, friends);

        findMutualFriends(scoreMap, friends, directFriends);

        scoreVisitedFriends(visitors, scoreMap);

        List<String> names = createSortedFriendsName(scoreMap);

        List<String> answer = chooseFiveFriends(names, directFriends, user);

        return answer;
    }

    private static List<String> chooseFiveFriends(List<String> names, List<String> directFriends, String user){
        List<String> result = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            if (result.size() >= 5) break;

            if (directFriends.contains(names.get(i)) || names.get(i).equals(user)) continue;

            result.add(names.get(i));
        }
        return result;
    }

    private static List<String> createSortedFriendsName(HashMap<String, Integer> scoreMap) {
        List<String> result = new ArrayList<>(scoreMap.keySet());
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return scoreMap.get(o2) - scoreMap.get(o1);
            }
        });

        return result;
    }
    private static void scoreVisitedFriends(List<String> visitors, HashMap<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }
    }

    private static List<String> createDirectFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        for (List<String> relationship : friends){
            if (relationship.get(0).equals(user)) result.add(relationship.get(1));
            if (relationship.get(1).equals(user)) result.add(relationship.get(0));
        }
        return result;
    }

    private static void findMutualFriends(HashMap<String, Integer> scoreMap, List<List<String>> friends, List<String> directFriends) {
        for (String friend : directFriends) {
            for (List<String> relationship : friends){
                scoreMutualFriends(scoreMap, relationship, friend);
            }
        }
    }

    private static void scoreMutualFriends(HashMap<String, Integer> scoreMap, List<String> relationship, String friend) {
        if (relationship.get(0).equals(friend))
            scoreMap.put(relationship.get(1), scoreMap.getOrDefault(relationship.get(1), 0) + 10);
        else if (relationship.get(1).equals(friend))
            scoreMap.put(relationship.get(0), scoreMap.getOrDefault(relationship.get(0), 0) + 10);
    }
}
