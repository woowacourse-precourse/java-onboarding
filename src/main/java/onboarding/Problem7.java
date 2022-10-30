package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        try {
            if(!isCorrectInputs(user,friends,visitors)) {
                throw new Exception("제한사항에 위배되는 input값입니다");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static boolean isCorrectInputs(String user, List<List<String>> friends, List<String> visitors) {
        if(user.length()<1||user.length()>30) return false;
        if(friends.size()<1||friends.size()>10000) return false;
        for (List<String> friend : friends) {
            if(friend.size()!=2) return false;
            String friend1 = friend.get(0);
            String friend2 = friend.get(0);
            if((friend1.length()<1||friend1.length()>30)) return false;
            if(friend2.length()<1||friend2.length()>30) return false;
        }
        if(visitors.size()<0||visitors.size()>10000) return false;

        return true;
    }
}

