package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> realFriends = new ArrayList<>();
        List<String> frOfFriends = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();

        //user의 진짜 친구 찾기
        for(List<String> friend : friends){
            for(int i=0; i<2; i++){
                if(friend.get(i) == user)
                    realFriends.add(friend.get(1-i));
            }
        }

        //user의 진짜 친구의 친구, 한 다리 건너 아는 친구 찾기
        for(String realFriend : realFriends){
            for(List<String> friend : friends){
                for(int i=0; i<2; i++){
                    if(friend.get(i) == realFriend) {
                        if(friend.get(1-i) != user && !realFriends.contains(friend.get(1-i)))
                            frOfFriends.add(friend.get(1 - i));
                    }
                }
            }
        }

        //한 다리 건너 아는 친구의 점수를 10점 올림
        for(String frOfFriend : frOfFriends){
            if(score.containsKey(frOfFriend))
                score.put(frOfFriend, score.get(frOfFriend) +10);
            else
                score.put(frOfFriend,10);
        }

        //user에 방문한 사람의 점수를 1점 올림
        for(String visitor : visitors){
            if(realFriends.contains(visitor)) continue;

            if(score.containsKey(visitor))
                score.put(visitor, score.get(visitor) +1);
            else
                score.put(visitor,1);
        }

        //숫자가 높은 순으로 정렬
        List<Map.Entry<String, Integer>> scoreList = new LinkedList<>(score.entrySet());
        scoreList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        //5명까지만 리턴
        int i=0;
        for(Map.Entry<String, Integer> scoreHigh : scoreList){
            if(i<5) {
                answer.add(scoreHigh.getKey());
                i++;
            }
        }
        return answer;
    }
}
