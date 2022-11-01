package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //user와 친구인 사용자 추려내는 기능
    public List<String> findUserFriend(String user, List<List<String>> friends){
        List<String> userFriendList = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            if (Objects.equals(friends.get(i).get(0), user)){
                userFriendList.add(friends.get(i).get(1));
            }else if(Objects.equals(friends.get(i).get(1), user)){
                userFriendList.add(friends.get(i).get(0));
            }
        }
        return userFriendList;
    }
}
