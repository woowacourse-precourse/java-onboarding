package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, HashSet<String>> friendsMap = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();

        for(List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            // 첫 번째 친구 리스트
            if (!friendsMap.containsKey(firstFriend)) friendsMap.put(firstFriend, new HashSet<>());
            friendsMap.get(firstFriend).add(secondFriend);

            // 두 번째 친구 리스트
            if (!friendsMap.containsKey(secondFriend)) friendsMap.put(secondFriend, new HashSet<>());
            friendsMap.get(secondFriend).add(firstFriend);
        }

        // 함께 아는 친구 점수
        HashSet<String> friendsOfUser = friendsMap.get(user);
        for(String nameOfOtherPerson : friendsMap.keySet()) {
            HashSet<String> friendsOfOtherPerson = friendsMap.get(nameOfOtherPerson);
            if(!nameOfOtherPerson.equals(user)) {
                if(friendsOfOtherPerson.contains(user))
                    continue;
                friendsOfOtherPerson.retainAll(friendsOfUser);
                // 함께 아는 친구 수 * 10
                score.put(nameOfOtherPerson, friendsOfOtherPerson.size() * 10);
            }
        }

        // 타임 라인 방문 점수
        for(String visitor : visitors) {
            if(score.containsKey(visitor)) score.put(visitor, score.get(visitor) + 1);
            else score.put(visitor, 1);
        }

        List<Map.Entry<String, Integer>> listScore = new ArrayList<>(score.entrySet());
        // listScore 정렬
        listScore.sort((obj1, obj2) -> {
            // value 기준 내림차순, 값이 같으면 key 기준 오름차순
            if (!obj2.getValue().equals(obj1.getValue()))
                return obj2.getValue().compareTo(obj1.getValue());
            else return obj1.getKey().compareTo(obj2.getKey());
        });

        for(int i = 0; i < listScore.size(); i++) {
            answer.add(listScore.get(i).getKey());
            if(i == 2) break;
        }
        return answer;
    }
}
