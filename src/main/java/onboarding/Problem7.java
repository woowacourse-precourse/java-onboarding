//1. user랑 친구인 사람 목록 리스트를 만들어
//2. friends에 있는 유저 목록 해시맵 만들어(key:사람이름, value: 사람이랑 친구인 애들 목록)
//3. 해시맵 돌면서 user랑 친구인 사람 목록이랑 value랑 교집합 수를 구해
//4. 유저 목록 해시맵 하나 더 만들어서 스코어 저장해

package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashSet<String> userFriends = userFriendsList(user, friends);
        Map<String, HashSet<String>> connection = userFriendConnection(user, friends);
        Map<String, Integer> score = userScore(user, friends, visitors);
        for (String name : connection.keySet()) {
            HashSet<String> setTmp = new HashSet<>();
            setTmp.addAll(userFriends);
            setTmp.retainAll(connection.get(name));
            score.put(name, score.get(name)+setTmp.size()*10) ;
        }
        for (String visitor : visitors) {
            score.put(visitor, score.get(visitor)+1);
        }
        for (String userFriend : userFriends) {
            score.remove(userFriend);
        }
        List<Map.Entry<String, Integer>> entries =
                score.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : entries) {
            answer.add(entry.getKey());
        }

        return answer;
    }

    private static HashSet<String> userFriendsList(String user, List<List<String>> friends) {
        HashSet<String> userFriends = new HashSet<>();
        for(List<String> friend : friends) {
            if (friend.contains(user)) {
                userFriends.add(friend.get(1-friend.indexOf(user)));
            }
        }

        return userFriends;
    }

    private static Map<String, HashSet<String>> userFriendConnection(String user, List<List<String>> friends) {
        Map<String, HashSet<String>> userConnection = new HashMap<>();
        for (List<String> friend : friends) {
            if (userConnection.containsKey(friend.get(0))) {
                HashSet<String> list0 = userConnection.get(friend.get(0));
                list0.add(friend.get(1));
            } else {
                userConnection.put(friend.get(0), new HashSet<>(Arrays.asList(friend.get(1))));
            }
            if (userConnection.containsKey(friend.get(1))) {
                HashSet<String> list1 = userConnection.get(friend.get(1));
                list1.add(friend.get(0));
            } else {
                userConnection.put(friend.get(1), new HashSet<>(Arrays.asList(friend.get(0))));
            }
        }
        userConnection.remove(user);
        return userConnection;
    }

    private static Map<String, Integer> userScore(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> userScore = new TreeMap<>();
        for (List<String> friend : friends) {
            if (!(userScore.containsKey(friend.get(0)))) {
                userScore.put(friend.get(0), 0);
            }
            if (!(userScore.containsKey(friend.get(1)))) {

                userScore.put(friend.get(1), 0);
            }
        }
        for (String visitor : visitors) {
            if (!(userScore.containsKey(visitor))) {
                userScore.put(visitor, 0);
            }
            if (!(userScore.containsKey(visitor))) {

                userScore.put(visitor, 0);
            }
        }
        userScore.remove(user);

        return userScore;
    }
}

