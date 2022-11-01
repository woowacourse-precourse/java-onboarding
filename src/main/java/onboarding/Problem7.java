package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Integer> recommendList = new HashMap<>();

        //나와 친구인 유저의 아이디 set 만들기
        Set<String> friendSet = new HashSet<>();
        for (List<String> list: friends) {
            if(list.contains(user)) {
                friendSet.add(list.get(0));
                friendSet.add(list.get(1));
            }
        }
        friendSet.remove(user);

        return answer;
    }
}
