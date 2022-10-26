package onboarding;

import java.util.*;

/**
 * 기능 사항
 * 1. 추천할 친구 class 인 RecFriend 구현
 * 2. 친구 관계를 만드는 함수
 * 3. 친구 관계일 경우 10점을 추가하는 함수
 * 4. 방문자일 경우 1점을 추가하는 함수
 */
public class Problem7 {


    static HashMap<String, Set<String>> friendsHashMap = new HashMap<>();
    static HashMap<String, Integer> points = new HashMap<>();

    /**
     * 1. 추천할 친구 RecFriend class
     */
    static class RecFriend {
        private String name;
        private Integer score;

        RecFriend(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }

    }

    /**
     * 친구 관계를 만드는 함수
     * @param user
     * @param friends
     */
    static void makeFriendShip(String user, List<List<String>> friends){
        friends.forEach(f -> {
            if (!f.get(0).equals(user)) points.put(f.get(0), 0);
            if (!f.get(1).equals(user)) points.put(f.get(1), 0);
            if (!friendsHashMap.containsKey(f.get(0))) {
                friendsHashMap.put(f.get(0), new HashSet<>());
            }
            if (!friendsHashMap.containsKey(f.get(1))) {
                friendsHashMap.put(f.get(1), new HashSet<>());
            }
            friendsHashMap.get(f.get(0)).add(f.get(1));
            friendsHashMap.get(f.get(1)).add(f.get(0));
        });


    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
