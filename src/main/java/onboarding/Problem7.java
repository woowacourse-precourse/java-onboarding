package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> friendsList = new ArrayList<>(friends);
        List<String> userFriendsList = getUserFriendsList(user, friendsList);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    // 사용자의 친구 리스트를 반환하는 함수
    public static List<String> getUserFriendsList(String user, List<List<String>> friendsList){

        List<String> userFriendsList = new ArrayList<>();
        for(int i = 0; i< friendsList.size(); i++){
            List<String> friend = new ArrayList<>(friendsList.get(i));
            if (friend.contains(user)) {
                friendsList.remove(friend);
                friend.remove(user);
                userFriendsList.add(friend.get(0));
            }
        }

        return userFriendsList;
    }
}
