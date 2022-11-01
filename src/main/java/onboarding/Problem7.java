package onboarding;

import java.util.*;

public class Problem7 {
    class Pair implements Comparable<Pair>{
        int first;
        String second;

        public Pair(int first, String second) {
            super();
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair p) {
            if(this.first == p.first)
                return this.second.compareTo(p.second);
            else
                return Integer.compare(this.first, p.first);
        }
    }
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

    public static void SetNotFriendList(List<List<String>> friends, HashSet<String> friendList, HashMap<String, Integer> notFriendList, List<String> visitors, String user)
    {
        for (int i = 0; i < friends.size(); i++)
        {
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);
            if (name1 == user || name2 == user)
                continue;
            if (friendList.contains(name1) && friendList.contains(name2))
                continue;
            if (!friendList.contains(name1) && !friendList.contains(name2))
                continue;
            if (friendList.contains(name1) && !notFriendList.containsKey(name2))
                notFriendList.put(name2, 0);
            else if (friendList.contains(name2) && !notFriendList.containsKey(name1))
                notFriendList.put(name1, 0);
        }

        for (String name : visitors)
            if (name != user && !friendList.contains(name) && !notFriendList.containsKey(name))
                notFriendList.put(name, 0);
    }

    public static void SetFriendScore(List<List<String>> friends, HashSet<String> friendList, HashMap<String, Integer> notFriendList)
    {
        for (int i = 0; i < friends.size(); i++)
        {
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);
            if (friendList.contains(name1) && friendList.contains(name2))
                continue;
            if (!friendList.contains(name1) && !friendList.contains(name2))
                continue;
            if (friendList.contains(name1) && notFriendList.containsKey(name2))
                notFriendList.put(name2, notFriendList.get(name2) + 10);
            else if (friendList.contains(name2) && notFriendList.containsKey(name1))
                notFriendList.put(name1, notFriendList.get(name1) + 10);
        }
    }

    public static void SetVisitorScore(List<String> visitors, HashMap<String, Integer> notFriendList)
    {
        for (String name : visitors)
            if (notFriendList.containsKey(name))
                notFriendList.put(name, notFriendList.get(name) + 1);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> friendList = new HashSet<String>();
        HashMap<String, Integer> notFriendList = new HashMap<String, Integer>();
        SetFriendList(friends, friendList, user);
        SetNotFriendList(friends, friendList, notFriendList, visitors, user);

        SetFriendScore(friends, friendList, notFriendList);
        SetVisitorScore(visitors, notFriendList);
        return answer;
    }
}