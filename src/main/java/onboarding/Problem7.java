package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        List<String> tempFriends = new ArrayList<>();
        Map<String, List<String>> myFriends = new HashMap<>();

        // 친구 리스트 정리하기
        for (int i=0; i<friends.size(); i++) {
            String name = friends.get(i).get(0);
            tempFriends.clear();
            for (int j=0; j<friends.size(); j++) {
                if (name.equals(friends.get(j).get(0))) {
                    tempFriends.add(friends.get(j).get(1));
                }
            }
            myFriends.put(name, tempFriends);
            // tempFriends.clear();  -> clear를 여기서하면 친구 목록이 없어지는 이유는 무엇일까?
        }

        // System.out.println(myFriends);

        return answer;
    }
}
