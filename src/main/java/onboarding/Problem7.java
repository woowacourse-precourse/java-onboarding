package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static ArrayList friend(String user, List<List<String>> friends) {
        ArrayList<String> friendsList = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) {
                friendsList.add(friends.get(i).get(1));
            }
            if(friends.get(i).get(1).equals(user)) {
                friendsList.add(friends.get(i).get(0));
            }
        }

        return friendsList;
    }

}
