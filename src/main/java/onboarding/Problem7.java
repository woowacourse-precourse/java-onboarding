package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Problem7 {
    static List<String> findMyFriend(String user, List<List<String>> friends){
        List<String> friedList = new ArrayList<>(Collections.emptyList());
        for(int i = 0; i < friends.size(); i++){
            if(Objects.equals(friends.get(i).get(0), user)){
                friedList.add(friends.get(i).get(1));
            }
            if(Objects.equals(friends.get(i).get(1), user)){
                friedList.add(friends.get(i).get(0));
            }
        }
        return friedList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList = findMyFriend(user, friends);
        System.out.println(friendList);
        return answer;
    }
}
