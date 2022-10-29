package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        return answer;
    }
    public static String[][] FriendGraph(List<List<String>> friends){
2

    }
    public static Set<String> MakeFriendlist(List<List<String>> friends){
        Set<String> Friendlist = new HashSet<>();
        for(int i=0;i< friends.size();i++){
           Friendlist.add(friends.get(i).get(0));
           Friendlist.add(friends.get(i).get(1));
        }
        return Friendlist;
    }

}
