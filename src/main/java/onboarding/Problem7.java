package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<Map.Entry<String, Integer>> getSortedList(HashMap<String,Integer> l){
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(l.entrySet());

        Collections.sort(sortedList, (sList1, sList2) -> {
            if (sList1.getValue() != sList2.getValue()) {
                return sList2.getValue().compareTo(sList1.getValue());
            } else {
                return sList1.getKey().compareTo(sList2.getKey());
            }
        });
        return sortedList;
    }

    public static HashMap<String,ArrayList<String>> getAdjacencylist(List<List<String>> friends){
        HashMap<String,ArrayList<String>> point = new HashMap<>();

        for(List<String> i : friends){
            for(int j=0;j<2;j++){
                if (!point.containsKey(i.get(j))){
                    point.put(i.get(j),new ArrayList<>(Arrays.asList(i.get(Math.abs(j-1)))));
                }else{
                    ArrayList<String> l = point.get(i.get(j));

                    l.add(i.get(Math.abs(j-1)));
                    point.put(i.get(j),l);
                }
            }
        }
        return point;
    }
    
    public static HashMap<String,Integer> getPointMap(HashMap<String,ArrayList<String>> point,String user, List<String> visitors){
        HashMap<String,Integer> result = new HashMap<>();

        Stack<Map.Entry<String, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(user,0));
        while(!stack.isEmpty()) {
            Map.Entry<String, Integer> name = stack.pop();
            if (name.getValue()==2) {
                result.put(name.getKey(), 10);
                continue;
            }
            if (point.containsKey(name.getKey()))
                point.get(name.getKey()).stream().forEach(e-> {
                    stack.push(new AbstractMap.SimpleEntry<>(e,name.getValue()+1));
                });
        }

        visitors.stream().forEach(e->{
            int visitPoint=(!result.containsKey(e))?1:result.get(e)+1;
            result.put(e,visitPoint);
        });

        if(result.containsKey(user))
            result.remove(user);
        if(point.containsKey(user)) {
            for (String i : point.get(user)) {
                result.remove(i);
            }
        }

        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String,ArrayList<String>> point = getAdjacencylist(friends);
        HashMap<String,Integer> result = getPointMap(point,user,visitors);

        return getSortedList(result).stream().map(s->s.getKey()).limit(5).collect(Collectors.toList());

    }
}