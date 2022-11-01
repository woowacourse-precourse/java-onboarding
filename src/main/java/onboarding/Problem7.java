package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        Map<String, HashSet<String>> friendMap = new HashMap<>();
        friendMap = makeMap(friends, user);

        HashMap<String, Integer> friendScore = new HashMap<>();
        friendScore = makeScoreMap(friendMap, user);

        for (String visitor : visitors) {
            friendScore.put(visitor, calculatingVisitors(visitors, friendScore, visitor));
        }

        List<String> keySet = new ArrayList<>();
        keySet = sortingScoreMap(friendScore);

        for (String friend : keySet) {
            if (answer.size() == 5) {
                break;
            } else {
                //한번도 방문한 적도 없고 같이 아는 친구도 없으며 이미 친구인 경우는 추천할 필요가 없음
                if (friendScore.get(friend) != 0 && friendScore.get(friend) != -1) {
                    answer.add(friend);
                }
            }
        }

        return answer;
    }

    public static int calculatingVisitors(List<String> visitors, HashMap<String, Integer> friendScore, String visitor) {
        return friendScore.getOrDefault(visitor, 0) + 1;
    }

    /**
     * 주어진 친구 정보로 친구관계를 표현한 HashMap을 생성하는 메서드
     * 해쉬맵은 친구 이름을 key로, 친구관계인 친구들의 정보를 가진 HashSet 을 value 로 가짐
     *
     * @param friends 친구 정보
     * @return 친구 정보를 담은 HashMap
     */
    public static Map<String, HashSet<String>> makeMap(List<List<String>> friends, String user) {

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

        if (!friendMap.containsKey(user)) {
            HashSet<String> empty = new HashSet<>();
            friendMap.put(user, empty);
        }

        return friendMap;
    }

    public static HashMap<String, Integer> makeScoreMap( Map<String, HashSet<String>> friendMap, String user) {

        HashMap<String, Integer> friendScore = new HashMap<>();
        for (String friend : friendMap.keySet()) {
            if (!friend.equals(user)) {
                int score = calculateScore(friend, user, friendMap);
                friendScore.put(friend, score);
            }
        }
        return friendScore;
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

        //이미 친구인 경우는 -1
        if (friendMap.get(user).contains(friendB)) {
            score = -1;
            return score;

        } else {

            for (String friendBFriend : friendMap.get(friendB)) {
                if (friendMap.get(user).contains(friendBFriend)) {
                    score += 10;
                }
            }
        }
        return score;
    }

    public static List<String> sortingScoreMap(HashMap<String, Integer> friendScore) {

        List<String> keySet = new ArrayList<>(friendScore.keySet());

        keySet.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (friendScore.get(o1).equals(friendScore.get(o2))) {
                    return o1.compareTo(o2);
                }
                return friendScore.get(o2) - friendScore.get(o1);
            }
        });

        return keySet;
    }

}
