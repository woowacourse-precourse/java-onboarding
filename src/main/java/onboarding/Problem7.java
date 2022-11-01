package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String, Integer> peopleMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        makePeopleMap(user, friends, visitors);
        makeGraph(friends);
        return answer;
    }

    public static HashMap<String, ArrayList<String>> makeGraph(List<List<String>> friends){
        Map<String, ArrayList<String>> graph = new HashMap<>();
        String firstFriend;
        String secondFriend;
        for (int index=0; index<friends.size(); index++) {

            ArrayList<String> tempList = new ArrayList<>();
            firstFriend = friends.get(index).get(0);
            secondFriend = friends.get(index).get(1);

            if (graph.containsKey(firstFriend)){
                tempList = graph.get(firstFriend);
                tempList.add(secondFriend);
            } else if(!graph.containsKey(firstFriend)){
                tempList.add(secondFriend);
            }
            graph.put(firstFriend, tempList);

            if (graph.containsKey(secondFriend)){
                tempList = graph.get(secondFriend);
                tempList.add(firstFriend);
            } else if(!graph.containsKey(secondFriend)){
                tempList.add(firstFriend);
            }
            graph.put(secondFriend, tempList);
        }


        return (HashMap<String, ArrayList<String>>) graph;
    }

    public static void makePeopleMap(String user, List<List<String>> friends, List<String> visitors){
        String firstFriend;
        String secondFriend;
        for (int index=0; index<friends.size(); index++){
            firstFriend = friends.get(index).get(0);
            secondFriend = friends.get(index).get(1);

            if(!user.equals(firstFriend)){
                peopleMap.put(firstFriend, 0);
            }

            if(!user.equals(secondFriend)){
                peopleMap.put(secondFriend, 0);
            }
        }

        String visitor;

        for (int index=0; index<visitors.size(); index++){
            visitor = visitors.get(index);

            if(!user.equals(visitor)){
                peopleMap.put(visitor, 0);
            }
        }
    }
}
