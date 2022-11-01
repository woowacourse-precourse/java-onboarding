package onboarding;
import java.util.List;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> pointboard = new HashMap<>();
        Map<String, List<String>> userfriends = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for (List<String> friend : friends) {
            String leftfriend = friend.get(0);
            String rightfriend = friend.get(1);

            List<String> currentleft = new ArrayList<>();
            List<String> currentright = new ArrayList<>();

            if(userfriends.get(leftfriend) != null) currentleft = userfriends.get(leftfriend);
            if(userfriends.get(rightfriend) != null) currentright = userfriends.get(rightfriend);

            currentleft.add(rightfriend);
            userfriends.put(leftfriend, currentleft);

            currentright.add(leftfriend);
            userfriends.put(rightfriend, currentright);
        }
        for (String name : userfriends.get(user)) {
            for (String nextperson : userfriends.get(name)) {
                int point = 0;

                if(nextperson==user) continue;
                if(userfriends.get(user).contains(nextperson)) continue;
                if(pointboard.get(nextperson) != null) point = pointboard.get(nextperson);
                pointboard.put(nextperson, point+10);
            }
        }

        for (String visit : visitors) {
            int point = 0;
            if(visit==user) continue;
            if(userfriends.get(user).contains(visit)) continue;
            if(pointboard.get(visit) != null) point = pointboard.get(visit);
            pointboard.put(visit, point+1);
        }
        return answer;
    }
}

