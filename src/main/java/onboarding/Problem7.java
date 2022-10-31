package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Problem7 {
    static Map<String,Integer> pointMap = new HashMap<>();
    //find connected friends
    public static void connect(String start, HashMap<String, ArrayList<String>> lst){
        Stack<String> stack = new Stack<>();
        //DFS
        stack.add(start);
        while(!stack.isEmpty()){
            String v = stack.pop();
            if(!pointMap.containsKey(v)) {
                pointMap.put(v, 10);
                stack.addAll(lst.get(v));
            }
            else{
                pointMap.put(v, pointMap.get(v)+10);
            }
        }
    }
    //check visited people
    public static void visit(List<String> lst){
        for(String v : lst){
            pointMap.put(v, pointMap.getOrDefault(v, 1) + 1);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //generate friend graph
        HashMap<String, ArrayList<String>> friendMap = new HashMap<>();
        for(int i = 0; i < friends.size(); i++){
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);
            ArrayList<String> aList = new ArrayList<>();
            ArrayList<String> bList = new ArrayList<>();
            if(friendMap.containsKey(a)){
                aList = friendMap.get(a);
                aList.add(b);
            }
            else{
                aList.add(b);
            }
            friendMap.put(a, aList);
            if(friendMap.containsKey(b)){
                bList = friendMap.get(b);
                bList.add(a);
            }
            else{
                bList.add(a);
            }
            friendMap.put(b, bList);
        }
        connect(user, friendMap);
        visit(visitors);
        //make a list to except user and user's friends
        List<String> except = new ArrayList<>();
        except.add(user);
        except.addAll(friendMap.get(user));
        for(String e : except){
            pointMap.remove(e);
        }
        List<String> res = pointMap.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Integer>::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
                )
                .map(it -> it.getKey())
                .collect(Collectors.toList());
        if(res.size() >= 6){
            return res.subList(0, 5);
        }
        else{
            return res.subList(0, res.size());
        }
    }
}
