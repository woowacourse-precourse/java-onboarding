package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem7 {

    private class User{
        String name;
        Int score;
    }

    private static HashMap<String, Integer> makeFriendsList(List<List<String>> friends){
        HashMap<String, Integer> friendsList = new HashMap<String, Integer>();

        for(List<String> f:friends){
            if(!friendsList.contains(f.get(0))) friendsList.put(f.get(0), 0);
            if(!friendsList.contains(f.get(1))) friendsList.add(f.get(1), 0);
        }
        return friendsList;
    }


    private static  List<String> makeCurFriendsList(List<List<String>> friends){
        List<String> curFriendsList = new ArrayList<>();


        return curFriendsList;
    }


    private static  HashMap<String, Integer> calDupFriends(List<List<String>> friends, HashMap<String, Integer> friendsList, List<String> curFriendsList){


        return friendsList;
    }

    private static  HashMap<String, Integer> calVisitors(HashMap<String, Integer> friendsList, List<String> visitors){


        return friendsList;
    }

    private static  List<String> sortFriendsList(HashMap<String, Integer> friendsList){
        List<String> sortedList = new ArrayList<>();


        return sortedList;
    }

    private static  List<String> delCurFriends(List<String> sortedList, List<String> curFriendsList){
        List<String> answer = new ArrayList<>();

        return answer;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();





        return answer;
    }
}
