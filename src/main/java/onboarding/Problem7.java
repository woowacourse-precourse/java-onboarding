package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//A와 B는 친구
//입력된 유저와 친구는 아니지만,

//같이 알고있는 사람이 있다면 +10점
//방문횟수 + 1점

//필요한 기능 목록 -> 유저의 친구 찾기
//유저의 친구 목록에 있는 사람 result에서 제외
//유저의 친구의 친구를 찾고, 그 유저에게 + 10점
//방문자들은 +1점
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = findMyFriends(user,friends);
        return answer;
    }
//입력된 유저의 친구 목록을 구해야함 - findMyFriends
    public static List<String> findMyFriends(String user, List<List<String>> friends){
        List<String> result = new ArrayList<String>();

        for(int i = 0; i<friends.size(); i++){
            if(friends.get(i).indexOf(user)==0){
                result.add(friends.get(i).get(1));
                continue;
            }
            if(friends.get(i).indexOf(user)==1) {
                result.add(friends.get(i).get(0));
                continue;
            }

        }
        System.out.println(result);
        return result;

    }
}
