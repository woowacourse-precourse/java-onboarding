package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Problem7 P = new Problem7();
        List<String> following = P.checkFriend(user, friends);
        return answer;
    }

    // user와 이미 친구인 list를 반환하는 메서드
    public List<String> checkFriend (String user, List<List<String>> friends) {
        List<String> following = new ArrayList<>();
        for(List l : friends) {
            if(l.contains(user)){
                following.add(String.valueOf(l.get(0)));
            }
        }
        return following;
    }
}
