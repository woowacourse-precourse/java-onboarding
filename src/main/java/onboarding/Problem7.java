package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /* 친구의 관계를 나타냄 */
        Map<String,List<String>> friendships = setFriendship(friends);
        /* 사용자의 친구의 친구를 나타냄 */
        List<String> friendsFriends = getFriendsFriends(user, friendships);
        /* 친구의 친구인 사람들의 점수 계산 */
        Map<String, Integer> score = getRelationScore(friendsFriends);

        /* 방문자의 점수 계산 */
        addVisitorScore(score, visitors);
        /* 이미 친구인 사람들 + user 제거 */
        removeUsersFriends(score, friendships, user);

        /* 점수순, 이름순 정렬을 위한 Pair */
        Pair[] pairForNameScore = initScore(score);
        Arrays.sort(pairForNameScore);

        List<String> answer = new ArrayList<>();
        getAnswer(pairForNameScore, score, answer);
        return answer;
    }

    private static Pair[] initScore(Map<String, Integer> score){
        Pair[] pairForNameScore = new Pair[score.size()];
        int i = 0;
        for (String key : score.keySet()){
            pairForNameScore[i] = new Pair(key, score.get(key));
            i += 1;
        }
        return pairForNameScore;

    }

    private static void getAnswer(Pair[] temp, Map<String, Integer> score, List<String> answer){
        for (int i = 0; i < score.size(); i++) {
            answer.add(temp[i].getName());
            if (isOverAnswerLength(answer.size())){
                break;
            }
        }
    }

    private static Boolean isOverAnswerLength(int size){
        final int MAX_ANSWER = 5;
        return size >= MAX_ANSWER;
    }

    private static Map<String,List<String>> setFriendship(List<List<String>> friends){
        Map<String,List<String>> friendships = new HashMap<>();
        for (List<String> currentFriendships : friends) {
            String currentA = currentFriendships.get(0);
            String currentB = currentFriendships.get(1);
            /* 친구 관계는 상호 관계이므로 둘다 관계성 추가 */
            addRelationToHash(friendships, currentA, currentB);
            addRelationToHash(friendships, currentB, currentA);
        }
        return friendships;
    }

    private static void addRelationToHash(Map<String,List<String>> friendships, String key, String value){
        List<String> temp = friendships.getOrDefault(key, new ArrayList<>());
        temp.add(value);
        friendships.put(key, temp);
    }

    private static List<String> getFriendsFriends(String user, Map<String,List<String>> friendships){
        List<String> friendsFriends = new ArrayList<>();
        List<String> userFriend = friendships.get(user);
        if (userFriend == null){
            return friendsFriends;
        }
        for (String s : userFriend) {
            List<String> currentFriendsFriends = friendships.get(s);
            friendsFriends.addAll(currentFriendsFriends);
        }
        return friendsFriends;
    }

    private static Map<String, Integer> getRelationScore(List<String> friendsFriends){
        Map<String, Integer> score = new HashMap<>();
        for (String key : friendsFriends) {
            if (score.containsKey(key)) {
                score.put(key, score.get(key) + 10);
            } else {
                score.put(key, 10);
            }
        }
        return score;
    }

    private static void addVisitorScore(Map<String, Integer> score, List<String> visitors){
        for (String key : visitors) {
            score.put(key, score.getOrDefault(key, 0) + 1);
        }
    }

    private static void removeUsersFriends(Map<String, Integer> score, Map<String,List<String>> friendships, String user){
        if (friendships.get(user) == null){
            return;
        }

        for (int i = 0; i < friendships.get(user).size(); i++) {
            score.remove(friendships.get(user).get(i));
        }
        score.remove(user);
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
        public int getScore(){ return score;}
    }
}
