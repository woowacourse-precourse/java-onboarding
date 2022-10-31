package onboarding;

import java.util.*;

class People implements Comparable<People>{

    @Override
    public int compareTo(People o){
        return 0;
    }
}

public class Problem7 {

    public void putPeopleToMap(HashMap<String,People> map, String peopleName){

    }

    public void addFriendToPeople(String user, People people, String friendName){

    }

    public void removeUserFriend(HashMap<String,People> map, String name){

    }

    public HashMap<String, People> makePeopleMap(String user, List<List<String>> friends, List<String> visitors){
        HashMap<String,People> map = new HashMap<>();
        return map;
    }

    public void scoreToUserFriend(ArrayList<String> userFriendsList, People person){

    }
    public void calculateFriendsScore(String user, HashMap<String, People> map){

    }

    public void calculateVisitorsScore(String user, HashMap<String, People> map, List<String> visitors){

    }

    public void addEmailToList(String user, People person,  ArrayList<String> recommendedList){

    }

    public ArrayList<String> makeRecommendedList(String user, HashMap<String, People> map){
        ArrayList<String> recommendedList = new ArrayList<>();
        return recommendedList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 T = new Problem7();

        HashMap<String, People> map = T.makePeopleMap(user, friends, visitors);
        T.calculateFriendsScore(user, map);
        T.calculateVisitorsScore(user, map, visitors);
        ArrayList<String> answer = T.makeRecommendedList(user, map);

        return answer;
    }
}

