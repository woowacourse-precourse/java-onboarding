package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * friends의 목록중 user와 같은 리스트에 안에 포함된 유저들의 리스트 반환
     * @param {List<List<String>>} friends
     * @param {String} user
     * @return userFriendList
     */
    public static List<String> userFriendList(List<List<String>> friends, String user) {
        List<String> userFriendList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0) == user) userFriendList.add(friends.get(i).get(1));
            else if(friends.get(i).get(1) == user) userFriendList.add(friends.get(i).get(0));
        }
        return userFriendList;
    }
}
