package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scores = new HashMap<>(); // 점수 계산해서 저장할 공간
        HashSet<String> alreadyFriend = new HashSet<>(); // 이미 친구인 아이디를 저장할 공간

        //친구 점수
        for(List<String> friend : friends) {
            alreadyFriend.add(friend.get(0));
            if(!friend.get(1).contains(user)) {
                System.out.println("friend: "+ Arrays.toString(friend.toArray()));

                getScoreValue(scores, friend.get(1), 10);
            }
        }
        System.out.println("alreadyFriend: "+Arrays.toString(alreadyFriend.toArray()));

        //방문 점수
        for(String visitor : visitors) {
            if(!alreadyFriend.contains(visitor)) {
                getScoreValue(scores, visitor, 1);
            }
        }
        System.out.println("scores: "+Arrays.toString(scores.keySet().toArray(new String[0])));
        System.out.println("scores: "+Arrays.toString(scores.values().toArray()));

        return new ArrayList<String>(scores.keySet());
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
