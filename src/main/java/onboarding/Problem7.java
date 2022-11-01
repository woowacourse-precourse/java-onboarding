package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        /*친구 목록 해쉬맵 구현*/
        Map<String,List<String>> friendInfo = new HashMap<>();

        for(int i=0; i<friends.size(); i++) {
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            if(friendInfo.containsKey(friends.get(i).get(0))){
                list1 = friendInfo.get(friends.get(i).get(0));
                list1.add(friends.get(i).get(1));
            }else list1.add(friends.get(i).get(1));

            if(friendInfo.containsKey(friends.get(i).get(1))){
                list2 = friendInfo.get(friends.get(i).get(1));
                list2.add(friends.get(i).get(0));
            } else list2.add(friends.get(i).get(0));

            friendInfo.put(friends.get(i).get(0),list1);
            friendInfo.put(friends.get(i).get(1),list2);
        }

        /*친구 목록 점수 계산*/

        List<String> userFriends = List.of();

        if(friendInfo.containsKey(user)) userFriends = friendInfo.get(user);
        Map<String,Integer> friendScore = new HashMap<>();

        for(String key:friendInfo.keySet()) {
            if(key == user) continue;
            int score =0;
            for(int i=0; i<userFriends.size(); i++){
                if(friendInfo.get(key).contains(userFriends.get(i))) score +=10;
            }
            if(score > 0){
                if(friendScore.containsKey(key)){
                    score += friendScore.get(key);
                }
                friendScore.put(key,score);
            }
        }

        /*방문자 점수 계산*/
        for(int i=0; i<visitors.size(); i++){
            int score = 1;
            if(friendScore.containsKey(visitors.get(i))){
                score += friendScore.get(visitors.get(i));
            }
            friendScore.put(visitors.get(i),score);
        }

        /*최대 5명 추출*/

        for(int i=0; i<userFriends.size(); i++){
            if(friendScore.containsKey(userFriends.get(i)))
                friendScore.remove(userFriends.get(i));
        }

        List<String> recommendFriend = new ArrayList<>(friendScore.keySet());

        recommendFriend.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(friendScore.get(o2) == friendScore.get(o1)) return o1.compareTo(o2);
                return friendScore.get(o2).compareTo(friendScore.get(o1));
            }
        });

        for(String key:recommendFriend) {
            answer.add(key);
            if(answer.size()==5) break;
        }

        return answer;
    }
}
