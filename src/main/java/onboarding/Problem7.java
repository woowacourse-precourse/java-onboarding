package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scores = new HashMap<>();
        HashSet<String> alreadyFriend = new HashSet<>();

        //친구 점수
        for(List<String> friend : friends) {
            alreadyFriend.add(friend.get(0));
            if(!friend.get(1).contains(user)) {
                System.out.println("friend: "+ Arrays.toString(friend.toArray()));

                getScoreValue(scores, friend.get(1), 10);
            }
        }
        System.out.println("alreadyFriend: "+Arrays.toString(alreadyFriend.toArray()));

        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void getScoreValue(HashMap<String, Integer> scores, String id, int score) {
        //점수 계산하기
        if(scores.containsKey(id)) {
            scores.replace(id, scores.get(id)+score);
        } else {
            scores.put(id, score);
        }
    }
}
