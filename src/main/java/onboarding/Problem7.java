package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        HashMap<String, HashSet<String>> friendGraph = new HashMap<>(); // 해당 친구의 친구 Set을 value로 가짐
        HashSet<String> nameList = new HashSet<>(); // 전체 이름들의 목록
        HashMap<String, Integer> friendScore = new HashMap<>(); // 친구들의 점수 저장(0점일 경우 저장 안됨)

        // friends에 따른 friendGraph 생성 및 friendList 초기화
        nameList.add(user);
        friendGraph.put(user, new HashSet<String>());
        for (int i = 0; i < friends.size(); i++) {
            String leftFriend = friends.get(i).get(0);
            String rightFriend = friends.get(i).get(1);

            if (!nameList.contains(leftFriend)) {
                nameList.add(leftFriend);
                friendGraph.put(leftFriend, new HashSet<String>());
            }
            if (!nameList.contains(rightFriend)) {
                nameList.add(rightFriend);
                friendGraph.put(rightFriend, new HashSet<String>());
            }

            friendGraph.get(leftFriend).add(rightFriend);
            friendGraph.get(rightFriend).add(leftFriend);
        }

        // user의 친구 각 원소로부터 user와 겹치는 친구 * 10점을 추가한다. (이미 친구인 경우엔 추가X)
        // friends 크기가 최대 1만이므로 friendsGraph들의 총 원소는 2만개를 넘지 않는다.
        for (String userFriend : nameList) {
            if (friendGraph.get(user).contains(userFriend) || userFriend.equals(user)) {
                continue;
            }

            // userFriend 친구 목록 중 user 친구와 공통되는 부분만 남긴다.
            friendGraph.get(userFriend).retainAll(friendGraph.get(user));
            if (friendGraph.get(userFriend).size() > 0) {
                friendScore.put(userFriend, friendGraph.get(userFriend).size() * 10);
            }
        }

        // 방문 횟수 * 1점을 추가한다. (이미 친구인 경우엔 추가X)
        for (String visitor : visitors) {
            if (friendGraph.get(user).contains(visitor)) {
                continue;
            }

            if (!friendScore.containsKey(visitor)) {
                friendScore.put(visitor, 0);
            }
            friendScore.replace(visitor, friendScore.get(visitor) + 1);
        }

        // friendScore은 1점이상인 경우에만 value가 존재하므로 점수 -> 이름순으로 정렬한다.
        answer = new ArrayList<>(friendScore.keySet());
        answer.sort((a, b) -> {
            if (friendScore.get(a) != friendScore.get(b)) {
                return friendScore.get(b) - friendScore.get(a);
            }
            return a.compareTo(b);
        });

        if (answer.size() > 5) {
            return answer.subList(0, 5);
        }
        return answer;
    }
}
