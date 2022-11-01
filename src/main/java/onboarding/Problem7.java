package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Problem7 {

    public static<K> void increment(Map<K, Integer> map, K key)
    {
        Integer count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
    }public static<K> void increment10(Map<K, Integer> map, K key)
    {
        Integer count = map.getOrDefault(key, 0);
        map.put(key, count + 10);
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();
        List<List<String>> friendlist;
        Map<String, Integer> scoreboard = new HashMap<String,Integer>();
        int listsize=friends.size();
        for(int i=0;i<friends.size();i++)
        {
                scoreboard.put(friends.get(i).get(0), 0);
                scoreboard.put(friends.get(i).get(1), 0);
        }
        for(int i=0;i<visitors.size();i++) //increment visit score
        {
            increment(scoreboard,visitors.get(i));
        }

        for(int i=0;i<listsize;i++)
        {
            if(friends.get(i).get(0).equals(user))
            {
                String tmp=friends.get(i).get(1);
                for(int j=0;j<listsize;j++) {
                    if (friends.get(j).get(0).equals(tmp)) {
                        increment10(scoreboard, friends.get(j).get(1));
                    }
                    else if(friends.get(j).get(1).equals(tmp)){
                        increment10(scoreboard,friends.get(j).get(0));
                    }
                }
            }
            else if(friends.get(i).get(1).equals(user))
            {
                String tmp=friends.get(i).get(0);
                for(int j=0;j<listsize;j++) {
                    if (friends.get(j).get(0).equals(tmp)) {
                        increment10(scoreboard, friends.get(j).get(1));
                    }
                    else if(friends.get(j).get(1).equals(tmp)){
                        increment10(scoreboard,friends.get(j).get(0));
                    }
                }
            }
        }
        scoreboard.remove(user);
        for(int i=0;i<listsize;i++)
        {
            if(friends.get(i).get(0).equals(user))
            {
                scoreboard.remove(friends.get(i).get(1));
            }
            else if(friends.get(i).get(1).equals(user)) {
            scoreboard.remove(friends.get(i).get(0));
            }
        }
        for(Map.Entry<String,Integer> entry: scoreboard.entrySet())
        {
            if(entry.getValue()==0)
            {
                scoreboard.remove(entry.getKey());
            }
        }
        //System.out.println(scoreboard);
        List<String> answer = new ArrayList<>(scoreboard.keySet());
        Collections.sort(answer, (o1, o2) -> Double.compare( scoreboard.get(o2), scoreboard.get(o1) ) );
        return answer;
    }
}
