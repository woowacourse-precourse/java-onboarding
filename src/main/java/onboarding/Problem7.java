package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //입력된 userId와 친구인 사람 list 반환하는 함수
    public static List<String> getFriends(String userId, List<List<String>> friends){
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend : friends){
            if(friend.get(0).equals(userId)) {
                userFriend.add(friend.get(1));
                continue;
            }
            if(friend.get(1).equals(userId)){
                userFriend.add(friend.get(0));
            }
        }

        return userFriend;
    }

    //추천리스트에 등록된 사람에 포함되었는지 확인하는 함수
    public static int isContained(String userId, List<String> recommandList){
        for(int i=0;i<recommandList.size();i++){
            if(userId.equals(recommandList.get(i))) return i;
        }

        return -1;
    }

}
