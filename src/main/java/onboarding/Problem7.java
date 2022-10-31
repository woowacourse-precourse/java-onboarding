package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> result = userlist(friends,visitors);



        return result;
    }

    public static List<String> userlist (List<List<String>> friends, List<String> visitors) {
        List<String> userdata = new ArrayList<>();
        for(int i=0;i< friends.size();i++) {
            userdata.add(friends.get(i).get(0));
            userdata.add(friends.get(i).get(1));

        }
        for(int j=0;j< visitors.size();j++) {
            userdata.add(visitors.get(j));
        }
        return overlap(userdata);
    }

    public static List<String> overlap (List<String> list) {
        Set<String> set = new HashSet<>(list);
        list = new ArrayList<>(set);

        return list;
    }
}
