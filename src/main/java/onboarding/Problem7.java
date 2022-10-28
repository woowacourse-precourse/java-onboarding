package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> map = new HashMap<>(); //사용자 친구추천 후보들
        HashSet<String> set = new HashSet<>(); //사용자와 이미 친구인 사람들

        //함께아는 친구 점수 계산하는 기능
        for(int i = 0; i < friends.size(); i++){
            String friend = friends.get(i).get(0);
            String friendOfFriend = friends.get(i).get(1);
            set.add(friend);
            if(friendOfFriend.equals(user)){
                continue;
            }
            //점수 계산
            if(map.containsKey(friendOfFriend)){
                int sum = map.get(friendOfFriend) + 10;
                map.put(friendOfFriend, sum);
            }else{
                map.put(friendOfFriend, 10);
            }
        }

        //visitor 점수 계산하는 기능
        //점수높은 5명 뽑는 기능

        return answer;
    }
}
