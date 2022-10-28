package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Problem7 {
    static HashMap<String,Integer> pointMap = new HashMap<>();
    //find connected friends
    public static void connect(String start, HashMap<String, ArrayList<String>> lst){
        Stack<String> stack = new Stack<>();
        //DFS
        stack.addAll(lst.get(start));
        while(!stack.isEmpty()){
            String v = stack.pop();
            pointMap.put(v, pointMap.getOrDefault(v, 10) + 10);
            stack.addAll(lst.get(v));
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

        return res;
    }
}
