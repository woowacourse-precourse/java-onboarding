package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem7 {

    private class User{
        String name;
        int score;
    }

    private static HashMap<String, Integer> makeFriendsList(List<List<String>> friends){
        HashMap<String, Integer> friendsList = new HashMap<String, Integer>();

        for(List<String> f:friends){
            if(!friendsList.containsKey(f.get(0))) friendsList.put(f.get(0), 0);
            if(!friendsList.containsKey(f.get(1))) friendsList.put(f.get(1), 0);
        }
        return friendsList;
    }


    private static  List<String> makeCurFriendsList(List<List<String>> friends, String user){
        List<String> curFriendsList = new ArrayList<>();

        for(List<String> f:friends){
            if(f.get(0).equals(user)) curFriendsList.add(f.get(1));
            else if(f.get(1).equals(user)) curFriendsList.add(f.get(0));
        }
        return curFriendsList;
    }


    private static  HashMap<String, Integer> calDupFriends(HashMap<String, Integer> friendsList, List<List<String>> friends, List<String> curFriendsList){
        int score;

        for(List<String> f:friends){
            if(curFriendsList.contains(f.get(0))){
                score = friendsList.get(f.get(1));
                friendsList.replace(f.get(1), score+10);
            }

            if(curFriendsList.contains(f.get(1))){
                score = friendsList.get(f.get(0));
                friendsList.replace(f.get(0), score+10);
            }
        }

        return friendsList;
    }

    private static  HashMap<String, Integer> calVisitors(HashMap<String, Integer> friendsList, List<String> visitors){
        int score;
        for(String v: visitors){
            if(!friendsList.containsKey(v)) friendsList.put(v, 0);
            score = friendsList.get(v);
            friendsList.replace(v, score+1);
        }

        return friendsList;
    }


    private static  HashMap<String, Integer> delFriends(HashMap<String, Integer> friendsList, List<String> curFriendsList, String user){

        friendsList.remove(user);
        for(String f: curFriendsList){
            friendsList.remove(f);
        }

        friendsList.entrySet().removeIf(
                entry -> entry.getValue().equals(0));

        return friendsList;
    }


    private static  List<String> sortFriendsList(HashMap<String, Integer> deletedList){
        List<String> sortedList = new ArrayList<>();

        List<HashMap.Entry<String, Integer>> entryList = new ArrayList<>(deletedList.entrySet());

        entryList.sort((o1, o2) ->  {return o1.getKey().compareTo(o2.getKey());});
        entryList.sort((o1, o2) ->  deletedList.get(o2.getKey()) - deletedList.get(o1.getKey()));

        for(HashMap.Entry<String, Integer> e: entryList){
            sortedList.add(e.getKey());
        }

        return sortedList;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Integer> friendsList = makeFriendsList(friends);
        List<String> curFriendList = makeCurFriendsList(friends, user);

        friendsList = calDupFriends(friendsList, friends, curFriendList);
        friendsList = calVisitors(friendsList, visitors);

        friendsList = delFriends(friendsList, curFriendList, user);
        answer = sortFriendsList(friendsList);

        return answer;
    }
}
