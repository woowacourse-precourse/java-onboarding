package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    /* checkUserFriend: 사용자와 친구인 사람 목록 만드는 함수 */
    public static List<String> checkUserFriend(List<List<String>> friends, String user){
        List<String> userFriends = new ArrayList<>();

        for(int i=0; i<friends.size(); i++){
            List<String> relation = friends.get(i);
            if(relation.get(0).equals(user)){ //사용자와 친구인 사람이 있다면 친구인 사람 저장
                userFriends.add(relation.get(1));
            } else if (relation.get(1).equals(user)) {
                userFriends.add(relation.get(0));
            }
        }

        return userFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();

        userFriends = checkUserFriend(friends, user);

        return answer;
    }
}