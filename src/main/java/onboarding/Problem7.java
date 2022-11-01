package onboarding;

import java.util.*;

public class Problem7 {
    

    public static void SetFriendList(List<List<String>> friends, HashSet<String> friendList, String user)
    {
        for (int i = 0; i < friends.size(); i++)
        {
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);
            if (name1 == user && !friendList.contains(name2))
                friendList.add(name2);
            else if (name2 == user && !friendList.contains(name1))
                friendList.add(name1);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> friendList = new HashSet<String>();
        SetFriendList(friends, friendList, user);
        return answer;
    }
}
