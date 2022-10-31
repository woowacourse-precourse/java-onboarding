package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /* 친구의 관계를 나타냄 */
        Map<String,List<String>> friendships;
        friendships = setFriendship(friends);

        /* 사용자의 친구의 친구를 나타냄 */
        List<String> friendsFriends = getFriendsFriends(user, friendships);

        /* 친구의 친구인 사람들의 점수 계산 */
        Map<String, Integer> score = getRelationScore(friendsFriends);

        /* 방문자의 점수 계산 */
        score = addVisitorScore(score, visitors);

        /* 이미 친구인 사람들 제거 */
        score = removeUsersFriends(score, friendships, user);

        /* 점수순, 이름순 정렬을 위한 Pair */
        Pair[] temp = new Pair[score.size()];
        int i = 0;
        for (String key : score.keySet()){
            temp[i] = new Pair(key, score.get(key));
            i += 1;
        }
        Arrays.sort(temp);

        List<String> answer = new ArrayList<>();
        for (int j = 0; j < score.size(); j++) {
            answer.add(temp[j].getName());
        }

        return answer;
    }

    private static Map<String,List<String>> setFriendship(List<List<String>> friends){
        Map<String,List<String>> friendships = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> currentFriendships = friends.get(i);
            String currentKey = currentFriendships.get(0);
            String currentValue = currentFriendships.get(1);
            /* 친구 관계는 상호 관계이므로 둘다 관계성 추가 */
            List<String> currentFriendship = getRelationToHash(friendships, currentKey, currentValue);
            friendships.put(currentKey, currentFriendship);
            currentFriendship = getRelationToHash(friendships, currentValue, currentKey);
            friendships.put(currentValue, currentFriendship);
        }
        return friendships;
    }

    private static List<String> getRelationToHash(Map<String,List<String>> friendships, String key, String value){
        List<String> temp = new ArrayList<>();
        if (friendships.get(key) == null){
            temp.add(value);
            return temp;
        }
        temp = friendships.get(key);
        temp.add(value);
        return temp;
    }

    private static List<String> getFriendsFriends(String user, Map<String,List<String>> friendships){
        List<String> temp = new ArrayList<>();
        List<String> userFriend = friendships.get(user);
        for (int i = 0; i < userFriend.size(); i++) {
            List<String> currentFriendsFriends = friendships.get(userFriend.get(i));
            for (int j = 0; j < currentFriendsFriends.size(); j++) {
                temp.add(currentFriendsFriends.get(i));
            }
        }
        return temp;
    }

    private static Map<String, Integer> getRelationScore(List<String> friendsFriends){
        Map<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < friendsFriends.size(); i++) {
            String key = friendsFriends.get(i);
            if (temp.containsKey(key)){
                temp.put(key, temp.get(key) + 10);
            }
            else{
                temp.put(key, 10);
            }
        }
        return temp;
    }

    private static Map<String, Integer> addVisitorScore(Map<String, Integer> score, List<String> visitors){
        for (int i = 0; i < visitors.size(); i++) {
            String key = visitors.get(i);
            if (score.containsKey(key)){
                score.put(key, score.get(key) + 1);
            }
            else{
                score.put(key, 1);
            }
        }
        return score;
    }

    private static Map<String, Integer> removeUsersFriends(Map<String, Integer> score, Map<String,List<String>> friendships, String user){
        for (int i = 0; i < friendships.get(user).size(); i++) {
            score.remove(friendships.get(user).get(i));
        }
        return score;
    }



    static class Pair implements Comparable<Pair> {
        String name;
        int score;

        public String toString(){
            return "Pair{" +
                    "name = '" + name + '\'' +
                    ", score = " + score +
                    '}';
        }
        public Pair(String name, int score){
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Pair o){
            if (this.score == o.score){
                return this.name.compareTo(o.name);
            }
            return o.score - this.score;
        }

        public String getName(){
            return name;
        }

    }
}
