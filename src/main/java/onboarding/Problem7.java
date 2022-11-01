package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashSet<String> checkFriend = new HashSet<>(); // 친구
        Map<String, Integer> score = new HashMap<>(); // 점수

        for (int i = 0; i < friends.size(); i++) {
            String friend = friends.get(i).get(0); // 친구
            String unknown = friends.get(i).get(1); // 친구의 친구
            if (friend.equals(user)) { // 친구 목록에 친구가 있다면
                checkFriend.add(unknown);
            } else if(unknown.equals(user)){
                checkFriend.add(friend);
            }
        }

        //함께아는 친구 수 계산
        for (int i = 0; i < friends.size(); i++) {
            String friend = friends.get(i).get(0);
            String unknown = friends.get(i).get(1);
            if (friend.equals(user) || unknown.equals(user)) {
                continue;
            }
            if (checkFriend.contains(friend) && checkFriend.contains(unknown)) {
                continue;
            }
            if (checkFriend.contains(friend)) {
                if (score.containsKey(unknown)){
                    score.put(unknown, score.get(unknown) + 10);
                } else {
                    score.put(unknown, 10);
                }
            } else if (checkFriend.contains(unknown)) {
                if (score.containsKey(friend)){
                    score.put(friend, score.get(friend) + 10);
                } else{
                    score.put(friend, 10);
                }
            }
        }
        //방문횟수
        for (int i = 0; i < visitors.size(); i++) {
            if (!checkFriend.contains(visitors.get(i))) {
                if (score.containsKey(visitors.get(i))) {
                    score.put(visitors.get(i), score.get(visitors.get(i))+1);
                } else {
                    score.put(visitors.get(i), 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> scoreSort = new ArrayList<>(score.entrySet()); // 결과값이 큰 사람을 구하자.
        scoreSort.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        for (int i = 0; i < scoreSort.size(); i++) {
            if (i > 4) break;
            answer.add(scoreSort.get(i).getKey());
        }
        return answer;
    }
}

