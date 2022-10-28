package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //TODO: network 만들기
        Map<String,List<String>> network = new HashMap<>();//{'이름':new ArrayList<>{}}
        for(List<String> friendship:friends){
            String oneName=friendship.get(0);
            String twoName=friendship.get(1);
            List<String>oneFriend=network.getOrDefault(oneName,new ArrayList<>());
            oneFriend.add(twoName);
            List<String>twoFriend=network.getOrDefault(twoName,new ArrayList<>());
            twoFriend.add(oneName);

            network.put(oneName,oneFriend);
            network.put(twoName,twoFriend);
        }
        //TODO: 'user 친구' 리스트
        //TODO: user와 친구가 아닌 'user 친구의 친구' 리스트 만들기

        //TODO: score 높은 순서대로 정렬 + 최대 5명

        List<String> answer = Collections.emptyList();

        return answer;
    }
}