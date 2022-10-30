package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem7 {
    private static HashMap<String, Boolean> isFriend; //user와 친구인지 판단
    private static HashMap<String, List<String>> userList; //user 리스트

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }

    //friends 확인하여 친구 관계 확인
    private static void checkFriends(String user, List<List<String>> friends){
        for(int i=0;i<friends.size();i++){
            List<String> friend = friends.get(i);
            String A = friend.get(0);
            String B = friend.get(1);

            //A가 user라면 B가 친구
            if(A.equals(user)){
                isFriend.put(B,true);
            }
            //B가 user라면 A가 친구
            else if(B.equals(user)){
                isFriend.put(A,true);
            }

            List<String> tmpA = userList.getOrDefault(A, new ArrayList<>());
            tmpA.add(B);
            userList.put(A, tmpA);

            List<String> tmpB = userList.getOrDefault(B, new ArrayList<>());
            tmpB.add(A);
            userList.put(B, tmpB);
        }
    }

    //visitors 확인하여 1점 추가

    //user로 부터 2번 건넌 친구들 확인하는 dfs
}