package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friends_list = new ArrayList<>();

        findAlreadyAreinds(friends_list, user, friends);
        return answer;
    }
    public static List<String> findAlreadyAreinds(List<String> friends_list ,String user, List<List<String>> friends){

        for (int i=0;i<friends.size();i++)
        {
            if(friends.get(i).get(0).equals(user)) friends_list.add(friends.get(i).get(1));
            if(friends.get(i).get(1).equals(user)) friends_list.add(friends.get(i).get(0));
        }
        friends_list.remove(user);
        // 동일한 친구관계가 주어지지는 않으므로 중복 처리 없이 반환
        return friends_list ;
    }
}
