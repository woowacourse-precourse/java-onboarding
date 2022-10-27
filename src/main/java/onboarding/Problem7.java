package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List <String> user_friend = new LinkedList<>();

        for(List <String> pair : friends){
            if(pair.get(0).equals(user))    user_friend.add(pair.get(1));
            else if(pair.get(1).equals(user))    user_friend.add(pair.get(0));
        }
//        System.out.println("user_friend = " + user_friend);

        List <String> point_10 = new LinkedList<>();
        for(List <String> pair : friends){
            if(user_friend.contains(pair.get(0)) && !pair.get(1).equals(user))  point_10.add(pair.get(1));
            else if(user_friend.contains(pair.get(1)) && !pair.get(0).equals(user))  point_10.add(pair.get(0));
        }
//        System.out.println("point_10 = " + point_10);

        Hashtable <String, Integer> hashtable = new Hashtable<>();
        for(String name : point_10){
            if(!hashtable.keySet().contains(name)) hashtable.put(name, 10);
            else
                hashtable.put(name, hashtable.get(name) + 10);
        }
        for(String name : visitors){
            if(user_friend.contains(name))  continue;
            if(!hashtable.keySet().contains(name)) hashtable.put(name, 1);
            else
                hashtable.put(name, hashtable.get(name) + 1);
        }
//        System.out.println("hashtable = " + hashtable);

        List <String> result = new LinkedList<>();
        for(String key : hashtable.keySet())    result.add(key);
        Collections.sort(result, (a, b) ->{
            if(hashtable.get(a) == hashtable.get(b)){
                return a.compareTo(b);
            }
            else{
                return -(hashtable.get(a) - hashtable.get(b));
            }
        });
//        System.out.println("result = " + result);

        return result;
    }
}
