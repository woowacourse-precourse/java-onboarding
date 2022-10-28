package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String,Integer> scoreBoardOfSuggestedFriends;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        scoreBoardOfSuggestedFriends = scoreBoardMapping(peopleNameSet(friends));

        Map<String,LinkedList<String>> eachFriendsList = friendsAdjacencyListByMap();
        setFriendsInfo(eachFriendsList,friends);

        LinkedList<String> userFriendList = eachFriendsList.get(user);
        ArrayList<String> alreadyCountedFriend = new ArrayList<>();

        considerFriendsScore(user,userFriendList,alreadyCountedFriend,eachFriendsList);
        considerVisitorScore(visitors);

        return finalSortedFriendList(alreadyCountedFriend);
    }
    static Map<String,Integer> scoreBoardMapping(Set<String> peopleSet){
        Map<String,Integer> map = new HashMap<>();

        for (String person : peopleSet) map.put(person, 0);
        return map;
    }

    static Set<String> peopleNameSet(List<List<String>> friends) {
        Set<String> friendSet = new HashSet<>();
        for (List<String> twoOfFriend : friends) {
            friendSet.add(twoOfFriend.get(0));
            friendSet.add(twoOfFriend.get(1));
        }

        return friendSet;
    }
    static Map<String,LinkedList<String>> friendsAdjacencyListByMap(){
        Map<String,LinkedList<String>> friendsList = new HashMap<>();

        scoreBoardOfSuggestedFriends.forEach((nameOfPerson,value) -> {
            LinkedList<String> newAdjacencyList = new LinkedList<>();
            friendsList.put(nameOfPerson,newAdjacencyList);
        });
        return friendsList;
    }

    static void setFriendsInfo(Map<String,LinkedList<String>> listMap,List<List<String>> friends){
        // add friends information
        for (List<String> twoOfFriend : friends) {
            String personA = twoOfFriend.get(0);
            String personB = twoOfFriend.get(1);

            // add friends on LinkedList
            listMap.get(personA).addLast(personB);
            listMap.get(personB).addLast(personA);
        }
    }
    static void considerFriendsScore(String user,LinkedList<String> userFriendList,ArrayList<String> countedFriend,Map<String,LinkedList<String>> friendsList){
        while(!userFriendList.isEmpty()){
            String selectedFriend = userFriendList.removeFirst();
            countedFriend.add(selectedFriend);

            LinkedList<String> friendsListOfSelectedFriends = friendsList.get(selectedFriend);

            while(!friendsListOfSelectedFriends.isEmpty()){
                raiseFriendsOfFriendsScore(user,friendsListOfSelectedFriends);
            }
        }
    }
    static void raiseFriendsOfFriendsScore(String targetUser, LinkedList<String> friendsList){
        String friendKnownTogether = friendsList.removeFirst();

        if(!friendKnownTogether.equals(targetUser)){
            int score = scoreBoardOfSuggestedFriends.get(friendKnownTogether);
            scoreBoardOfSuggestedFriends.replace(friendKnownTogether,score + 10);
        }
    }
    static void considerVisitorScore(List<String> visitors){
        for (String visitedPerson : visitors) {
            changeScoreOfVisitors(visitedPerson);
        }
    }
    static void changeScoreOfVisitors(String visitor){
        try{
            int score = scoreBoardOfSuggestedFriends.get(visitor);
            scoreBoardOfSuggestedFriends.replace(visitor,score+1);
        }catch(NullPointerException ex){
            scoreBoardOfSuggestedFriends.put(visitor,1);
        }
    }
    static List<String> finalSortedFriendList(ArrayList<String> alreadyCountedFriend){
        List<String> keySetList = new ArrayList<>(scoreBoardOfSuggestedFriends.keySet());
        keySetList.sort((o1, o2) -> scoreBoardOfSuggestedFriends.get(o2).compareTo(scoreBoardOfSuggestedFriends.get(o1)));

        List<String> answer = new ArrayList<>(Collections.emptyList());

        for(String key : keySetList){
            if(isValidNewFriend(alreadyCountedFriend,key,scoreBoardOfSuggestedFriends.get(key))){
                answer.add(key);
            }
        }

        return answer;
    }
    static boolean isValidNewFriend(ArrayList<String> selectedFriends, String friends, int value){
        if(value == 0){
            return false;
        }else{
            return !selectedFriends.contains(friends);
        }
    }
}
