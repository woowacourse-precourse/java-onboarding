package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 친구 관계 Map에 넣기
        Map<String, List<String>> friendsGraph = new HashMap<>();

        // 점수
        Map<String, Integer> score = new HashMap<>();

        // 친구 관계를 하나씩 꺼내기
        for (List<String> friendsList : friends) {
            String friend1 = friendsList.get(0);
            String friend2 = friendsList.get(1);

            // 그래프 안에 없다면 새로운 리스트 생성
            if (!friendsGraph.containsKey(friend1)) {
                List<String> friendList = new ArrayList<>();
                score.put(friend1, 0); // 점수 초기화
                friendsGraph.put(friend1, friendList);
            }
            if (!friendsGraph.containsKey(friend2)) {
                List<String> friendList = new ArrayList<>();
                score.put(friend2, 0); // 점수 초기화
                friendsGraph.put(friend2, friendList);
            }

            // 친구 1의 친구 리스트에 친구 2 추가
            List<String> friendList1 = friendsGraph.get(friend1);
            friendList1.add(friend2);

            // 친구 2의 친구 리스트에 친구 1 추가
            List<String> friendList2 = friendsGraph.get(friend2);
            friendList2.add(friend1);
        }

        // 함께 아는 친구 수에 따른 점수 구하기
        List<String> userFriends = friendsGraph.get(user);
        for (String userFriend : userFriends) {
            List<String> knownFriends = friendsGraph.get(userFriend);
            for (String friend : knownFriends) {
                // 사용자는 건너뜀
                if (friend.equals(user)) continue;

                // 사용자와 이미 친구인 관계도 건너뜀
                boolean isAlreadyFriend = false;
                for (String uf : userFriends) {
                    if (friend.equals(uf)) {
                        isAlreadyFriend = true;
                        break;
                    }
                }
                if (isAlreadyFriend) continue;

                // 사용자도 아니고, 사용자의 친구도 아닌 사용자의 친구와 아는 사이라면(10점)
                Integer friendScore = score.get(friend);
                score.put(friend, friendScore + 10);
            }
        }

        // 방문 점수 구하기 (1점)
        for (String visitor : visitors) {
            if (!score.containsKey(visitor)) {
                score.put(visitor, 1); // 점수 초기화
                continue;
            }
            Integer visitorScore = score.get(visitor);
            score.put(visitor, visitorScore + 1);
        }
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
