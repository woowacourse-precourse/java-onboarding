package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String, Integer> peopleMap;
    static ArrayList<String> answer;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        peopleMap = new HashMap<>();
        answer = new ArrayList<>();


        Map<String, ArrayList<String>> friendGraph = new HashMap<>();


        makePeopleMap(user, friends, visitors);
        friendGraph = makeGraph(friends);
        countVisitors(visitors);
        countFriends(user, friendGraph);
        System.out.println(peopleMap);
        findAnswer();
        return answer;
    }


    public static void findAnswer(){
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(peopleMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int count = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            if (count == 5){
                break;
            }
            if (entry.getValue() != 0){
                answer.add(entry.getKey());
                count += 1;
            }

        }
    }

    public static void countFriends(String user, Map<String, ArrayList<String>> graph){
        ArrayList<String> firstFriends = graph.get(user);
        ArrayList<String> connectFriend;
        String plusFriend;
        int value;
        for(int index=0; index<firstFriends.size(); index++){
            connectFriend = graph.get(firstFriends.get(index));

            for (int conIndex=0; conIndex < connectFriend.size(); conIndex++){
                plusFriend = connectFriend.get(conIndex);
                if (!plusFriend.equals(user)){
                    value = peopleMap.get(plusFriend);
                    value += 10;
                    peopleMap.put(plusFriend, value);
                }
            }

        }
    }

    public static void countVisitors(List<String> visitors){
        String visitor;
        int value;
        for (int index=0; index<visitors.size(); index++){
            visitor = visitors.get(index);
            value = peopleMap.get(visitor);
            value += 1;
            peopleMap.put(visitor, value);
        }
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

            tempList = new ArrayList<>();

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