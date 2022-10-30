package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        List<String> userFriends = new ArrayList<>();
        Map<String, Integer> userScore = new TreeMap<String, Integer>(); // 미리 알파벳 순으로 정렬되도록 저장한다.

        // user와 친구인 사람들 userFriends에 넣어준다.
        for(List<String> friend : friends) {
            int idx = friend.indexOf(user);
            if(idx != -1) {
                userFriends.add(friend.get((idx + 1) % 2));
            }
        }

        // user와 간접적으로 친구인 사람들 점수 증가.
        for(List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            // user 본인이 있으면 넘긴다.
            if(friend.contains(user)) {
                continue;
            }

            // 둘 다 userFriends에 있거나, 둘 다 없으면 볼 필요가 없으니 넘긴다.
            if((userFriends.contains(user1) && userFriends.contains(user2)) || (!userFriends.contains(user1) && !userFriends.contains(user2))) {
                continue;
            }
            String snsFriend = userFriends.contains(friend.get(0)) ? friend.get(1) : friend.get(0);

            // 이미 점수가 있으면 10을 추가, 아니면 10부터 시작.
            if(userScore.containsKey(snsFriend)) {
                userScore.put(snsFriend, userScore.get(snsFriend) + 10);
            } else {
                userScore.put(snsFriend, 10);
            }
        }

        // 직접적 친구 + user 제외 user의 타임라인에 방문한 사람들 1씩 증가.
        for(String name : visitors) {
            if(userFriends.contains(name) || user.equals(name)) {
                continue;
            }
            if(userScore.containsKey(name)) {
                userScore.put(name, userScore.get(name) + 1);
            } else {
                userScore.put(name, 1);
            }
        }

        // value 값을 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> userScore2 = new ArrayList<>(userScore.entrySet());

        Collections.sort(userScore2, new Comparator<>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        // 최대 5명까지 저장.
        for(Map.Entry<String, Integer> entry : userScore2.subList(0, Math.min(5, userScore2.size()))) {
            answer.add(entry.getKey());
        }

        return answer;
    }
}
