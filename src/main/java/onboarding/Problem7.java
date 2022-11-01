package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String>  solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.singletonList("aa");
        List<String> userFriendList = getUserList(user, friends);
        List<String> userList =  getUserList(friends, visitors);

        return answer;
    }
    public static List<String> getUserList(String user, List<List<String>> friends){
        List<String> userFriendList = new ArrayList<>();
        for (List<String> friend : friends){
            if (friend.indexOf(user) == 1){
                userFriendList.add(friend.get(0));
            }
            if (friend.indexOf(user) == 0){
                userFriendList.add(friend.get(1));
            }
        }
        return userFriendList;
    }

    public static List<String> getUserList(List<List<String>> friends, List<String> visitors) {
        List<String> flattenUserList = new ArrayList<>();

        for (List<String> friend : friends) {
            flattenUserList.addAll(friend);
        }
        flattenUserList.addAll(visitors);

        return flattenUserList.stream().distinct().collect(Collectors.toList());
    }

//    public static List<String>
}
