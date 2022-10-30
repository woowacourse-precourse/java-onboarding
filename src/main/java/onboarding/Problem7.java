package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    static class friend{
        String name;
        int point;
        friend(String name, int point) {this.name = name; this.point = point; }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> friend_graph = new HashMap<>();
        ArrayList<friend> sorted_friend = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++)
        {
            String f1 = friends.get(i).get(0);
            String f2 = friends.get(i).get(1);

            friend_graph.getOrDefault(f1, new ArrayList<>()).add(f2);
            friend_graph.getOrDefault(f2, new ArrayList<>()).add(f1);
        }

        for(var e: friend_graph.keySet())
        {
            if(e.equals(user)) continue;
            int count = 0;
            for(var name: friend_graph.get(e))
                if(friend_graph.get(user).contains(name)) count++;

            sorted_friend.add(new friend(e, count*10));
        }

        for(var e: visitors)
        {
            sorted_friend.replace(e, sorted_friend.get(e)+1);
        }




        List<String> answer = Collections.emptyList();
        return answer;
    }
}
