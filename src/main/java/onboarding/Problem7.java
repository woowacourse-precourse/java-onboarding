package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*   구현 기능
*   1. user의 친구 리스트를 만들어주는 기능
*   2. 친구 리스트에 있는 친구의 친구를 찾아주는 기능
*   3. 사용자와 함께 아는 친구의 점수를 추가해주는 기능
*   4. 방문자 점수를 추가해주는 기능
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static List<String> findUsersFriends(String user, List<List<String>> friedns) {
        ArrayList<String> friendList = new ArrayList<>();
        for(List<String> friend : friedns){
            if(friend.get(0).equals(user)) {
                friendList.add(friend.get(1));
            }
            if(friend.get(1).equals(user)){
                friendList.add(friend.get(0));
            }
        }
        return friendList;
    }
}
