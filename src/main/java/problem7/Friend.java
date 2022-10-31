package problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Friend {

    private String name;
    private int score;

    public HashMap<String, List<String>> makeFriendMap(List<List<String>> friends) {
       // HashMap<String, String> friendMap = new HashMap<String, String>();
        HashMap<String, List<String>> friendMap = new HashMap<>();

        for(List<String> friend : friends) {
            List<String> list;

            if(friendMap.containsKey(friend.get(0))) {
                list = friendMap.get(friend.get(0));
            }else {
                list = new ArrayList<>();
            }

            list.add(friend.get(1));
            friendMap.put(friend.get(0), list);

            if(friendMap.containsKey(friend.get(1))) {
                list = friendMap.get(friend.get(1));
            }else {
                list = new ArrayList<>();
            }

            list.add(friend.get(0));
            friendMap.put(friend.get(1), list);

        }

        return friendMap;
    }
}
