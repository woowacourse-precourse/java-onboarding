package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Set<String> myFriend = new HashSet<>(); // 사용자와 직접 친구인 회원 이름 저장
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) myFriend.add(friend.get(1));
            else if (friend.get(1).equals(user)) myFriend.add(friend.get(0));
        }

        Map<String, Integer> newFriend = new HashMap<>(); // key : 새로운 추천 친구 후보, value : 추천 점수
        // 함께 아는 친구 newFriend에 저장(추천 점수 10점)
        for (List<String> friend : friends) {
            String u1 = friend.get(0);
            String u2 = friend.get(1);
            if (u1.equals(user) || u2.equals(user)) continue;

            if (myFriend.contains(u1) && !myFriend.contains(u2) && !newFriend.containsKey(u2)) {
                newFriend.put(u2, 10);
            } else if (myFriend.contains(u2) && !myFriend.contains(u1) && !newFriend.containsKey(u1)) {
                newFriend.put(u1, 10);
            }
        }

        // 타임 라인 방문 횟수 점수 계산
        for (String visitor : visitors) {
            if (!user.equals(visitor) && !myFriend.contains(visitor)) {
                int temp = newFriend.getOrDefault(visitor, 0); // 함께 아는 친구가 아닌 경우 고려
                newFriend.put(visitor, temp+1);
            }
        }

        // newFriend map을 key : 추천 점수, value : 추천 회원 담긴 list인 map으로 변환
        Map<Integer, List<String>> scores = new TreeMap<>();
        for (String friend : newFriend.keySet()) {
            int score = newFriend.get(friend);
            List<String> users = scores.getOrDefault(-score, new ArrayList<>());
            users.add(friend);
            scores.put(-score, users);
        }

        // answer list에 상위 최대 5명의 추천 후보 저장
        for (int score : scores.keySet()) {
            if (score == 0 || answer.size() >= 5) break;

            List<String> users = scores.get(score);
            Collections.sort(users);

            for (String u : users) {
                answer.add(u);
                if (answer.size() >= 5) break;
            }
        }

        return answer;
    }
}
