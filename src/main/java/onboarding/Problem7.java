package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();
        Map<String, HashSet<String>> friendMap = new HashMap<>();

        friendMap = makeMap(friends);

        HashMap<String, Integer> friendScore = new HashMap<>();


        for (String friend : friendMap.keySet()) {

            if (friend.equals(user)) {
                continue;
            } else {
                int score = calculateScore(friend, user, friendMap);
                friendScore.put(friend, score);
            }

        }

        for (String visitor : visitors) {
            friendScore.put(visitor, friendScore.getOrDefault(visitor, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(friendScore.keySet());

        keySet.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (friendScore.get(o1).equals(friendScore.get(o2))) {
                    return o1.compareTo(o2);
                }
                return friendScore.get(o2) - friendScore.get(o1);
            }
        });


        for (String friend : keySet) {
            if (answer.size() == 5) {
                break;
            } else {
                if (friendScore.get(friend) != 0) {
                    answer.add(friend);
                }
            }
        }

        return answer;
    }

    /**
     * 주어진 친구 정보로 친구관계를 표현한 HashMap을 생성하는 메서드
     * 해쉬맵은 친구 이름을 key로, 친구관계인 친구들의 정보를 가진 HashSet 을 value 로 가짐
     *
     * @param friends 친구 정보
     * @return 친구 정보를 담은 HashMap
     */
    public static Map<String, HashSet<String>> makeMap(List<List<String>> friends) {

        Map<String, HashSet<String>> friendMap = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {

            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            HashSet<String> friendList = friendMap.getOrDefault(friendA, new HashSet<>());
            friendList.add(friendB);
            friendMap.put(friendA, friendList);

            friendList = friendMap.getOrDefault(friendB, new HashSet<>());
            friendList.add(friendA);
            friendMap.put(friendB, friendList);

        }

        return friendMap;
    }

    /**
     * 친구관계를 표현한 HashMap에 있는 정보를 가지고 추천친구의 점수를 구하는 메서드
     *
     * @param friendB user와 비교할 친구
     * @param user    주어진 user
     * @param friendMap 친구관계를 표현한 HashMap
     * @return 친구추천 점수
     */
    public static int calculateScore(String friendB, String user, Map<String, HashSet<String>> friendMap) {

        int score = 0;

        if (friendMap.get(user).contains(friendB)) {
            score = -1;
            return score;

        } else {

            HashSet<String> friendBList = friendMap.get(friendB);
            HashSet<String> userFriendList = friendMap.get(user);
            for (String friendBFriend : friendBList) {
                if (userFriendList.contains(friendBFriend)) {
                    score += 10;
                }
            }
        }
        return score;
    }

}
