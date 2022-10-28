package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args){
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");

        System.out.print(solution(user,friends,visitors));
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        HashMap<String,ArrayList<String>> point = new HashMap<>();
        HashMap<String,Integer> result = new HashMap<>();
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

        for(String i : point.get(user)){
            for(String j : point.get(i)){
                if (!result.containsKey(j))
                    result.put(j,10);
            }
        }

        for (String i : visitors) {
            if (!result.containsKey(i))
                result.put(i,1);
            else
                result.put(i,result.get(i)+1);
        }

        result.remove(user);
        for(String i : point.get(user)){
            result.remove(i);
        }

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(result.entrySet());

        Collections.sort(list_entries, (sList1, sList2) -> {
            if (sList1.getValue() != sList2.getValue()) {
                return ((Integer)Integer.parseInt(String.valueOf(sList2.getValue()))).compareTo(((Integer)Integer.parseInt(String.valueOf(sList1.getValue()))));
//                return Integer.parseInt(sList1.getKey()).compareTo(Integer.parseInt(sList2.getKey()));
//                return Integer.compare(Integer.parseInt(sList1.getKey()),Integer.parseInt(sList2.getKey()));
            } else {
                return sList1.getKey().compareTo(sList2.getKey());
            }
        });

        int i=0;
        for(Map.Entry<String, Integer> entry : list_entries) {
            if (i>=5)break;
            answer.add(entry.getKey());
            i++;
        }

        return answer;
    }
}