package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        List<String> alreadyFriends = new ArrayList<>(Collections.emptyList());
        HashMap<String, Integer> mapForScore = new HashMap<>();

        for (List<String> list : friends){

            if (!mapForScore.containsKey(list.get(0)) && !list.get(0).equals(user)){
                mapForScore.put(list.get(0),0);
            }
            if (!mapForScore.containsKey(list.get(1)) && !list.get(1).equals(user)) {
                mapForScore.put(list.get(1),0);
            }
            if (list.get(1).equals(user)){
                alreadyFriends.add(list.get(0));
                mapForScore.remove(list.get(0));

            }
            if (list.get(0).equals(user)){
                alreadyFriends.add(list.get(1));
            }

        }

        for (String users : visitors){
            if (!mapForScore.containsKey(users) && !alreadyFriends.contains(users)){
                mapForScore.put(users,0);
            }
        }

        //System.out.println(mapForScore.keySet());

        for (List<String> list : friends){
            if (list.get(1).equals(user)){
                for (String x : findKnowingFriend(list.get(0), friends)){
                    if (!x.equals(user) && mapForScore.containsKey(x)){
                        int currentScore = mapForScore.get(x);
                        currentScore +=10;
                        mapForScore.put(x,currentScore);
                    }

                }
            }

        }

        for (String list : visitors){
            //System.out.println(list);
            if (mapForScore.containsKey(list)){
                int currentScore = mapForScore.get(list) ;
                currentScore +=1;
                mapForScore.put(list,currentScore);
            }

        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(mapForScore.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2){
                if (o2.getValue() == o1.getValue()){
                    if (o2.getKey().charAt(0) > o1.getKey().charAt(0)) return -1;
                    else if (o2.getKey().charAt(0) < o1.getKey().charAt(0)) return 1;
                    else return 0;
                }
                else return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : entryList){
            //System.out.println(entry.getKey() + " " + entry.getValue());
            answer.add(entry.getKey());
        }
        return answer;
    }

    private static List<String> findKnowingFriend(String bridgeFriend, List<List<String>> friends){
        List<String> tempStringList = new ArrayList<>();
        for (List<String> list : friends){
            if (list.get(0).equals(bridgeFriend)){
                //System.out.println(list.get(0) + " : " + list.get(1));
                tempStringList.add(list.get(1));
            }
        }
        return tempStringList;
    }
}
