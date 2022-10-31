package onboarding;

import java.util.*;

public class Problem7 {
    public static boolean chk_error(String user, List<List<String>> friends, List<String> visitors)
    {
        if (user.length() < 1 || user.length() > 30)
            return false;
        if (friends.size() < 1 || friends.size() > 10000)
            return false;
        for (List<String> friend: friends)
        {
            if (friend.size() != 2)
                return false;
        }
        if(visitors.size() > 10000)
            return false;
        return true;
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map){
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static HashMap<String,Integer> check_friend(String user, List<List<String>> friends,
                                                       HashMap<String, Integer> map, List<String> user_friends)
    {
        for (int i = 0; i < user_friends.size(); i++)
        {
            for (int j = 0; j < friends.size(); j++)
            {
                if (friends.get(j).get(0).equals(user_friends.get(i))
                && !friends.get(j).get(1).equals(user) && map.get(friends.get(j).get(1)) != -1)
                    map.put(friends.get(j).get(1), map.get(friends.get(j).get(1)) + 10);
                else if (friends.get(j).get(1).equals(user_friends.get(i))
                        && !friends.get(j).get(0).equals(user) && map.get(friends.get(j).get(0)) != -1)
                    map.put(friends.get(j).get(0), map.get(friends.get(j).get(0)) + 10);
            }
        }
        return map;
    }
    public static HashMap<String, Integer> add_visitor(HashMap<String, Integer> map, List<String> visitors)
    {
        for (int j = 0; j < visitors.size(); j++)
            if (map.get(visitors.get(j)) != -1)
                map.put(visitors.get(j),map.get(visitors.get(j)) + 1);
        return map;
    }
    public static List<String> make_answer(HashMap<String, Integer> map)
    {
        List<String> result = new ArrayList<String>();
        for (String key : map.keySet())
        {
            if (map.get(key) != -1 && map.get(key) != 0)
                result.add(key);
        }
        return result;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> user_friends = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        if(!chk_error(user, friends, visitors))
            return answer;
        for (int i = 0; i < visitors.size(); i++) {
            map.put(visitors.get(i), 0);
        }
        for (int i = 0; i < friends.size(); i++)
        {
            if (friends.get(i).get(0) == user)
            {
                user_friends.add(friends.get(i).get(1));
                map.put(friends.get(i).get(1),-1);
            }else if (friends.get(i).get(1) == user)
            {
                user_friends.add(friends.get(i).get(0));
                map.put(friends.get(i).get(0), -1);
            }else
            {
                map.put(friends.get(i).get(0), 0);
                map.put(friends.get(i).get(1), 0);
            }
        }
        map = add_visitor(map, visitors);
        map = check_friend(user, friends, map, user_friends);
        map = sortByValue(map);
        answer = make_answer(map);
        return answer;
    }
}
