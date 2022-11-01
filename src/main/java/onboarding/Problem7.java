package onboarding;
/**
 *
 * 친구 추천 알고리즘 - 기능 요구 사항
 *  1. 유저와 직접적인 친구를 찾아 이름 리스트를 반환하는 함수를 만든다.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friends_list = new ArrayList<>();

        findAlreadyFriends(friends_list, user, friends);
        return answer;
    }
    public static List<String> findAlreadyFriends(List<String> friends_list, String user, List<List<String>> friends) {
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) friends_list.add(friends.get(i).get(1));
            if(friends.get(i).get(1).equals(user)) friends_list.add(friends.get(i).get(0));
        }
        friends_list.remove(user);
        return friends_list;
    }
}
