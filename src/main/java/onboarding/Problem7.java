package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> myfriend = new ArrayList<String>();
        List<String> friendsfriend = new ArrayList<String>();
        List<String> visitors_name = new ArrayList<String>();


        myfriend = find_friend(friends);
        friendsfriend = finds_friend(friends);
        //친구의 친구에서 user 제거
        friendsfriend.remove(user);

        return answer;
    }
    // 친구 list 반환
    public static List<String> find_friend(List<List<String>> friends) {
        List<String> friend = new ArrayList<String>();
        for (int i = 0; i < friends.size(); i++) {
            friend.add(friends.get(i).get(0));
        }
        return friend;
    }

    // 친구의 친구 list 반환
    public static List<String> finds_friend(List<List<String>> friends) {
        List<String> friend = new ArrayList<String>();
        for (int i = 0; i < friends.size(); i++) {
            friend.add(friends.get(i).get(1));
        }
        return friend;
    }
}
