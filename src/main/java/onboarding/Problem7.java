package onboarding;

import java.util.*;

public class Problem7 {
    static void inputUserFriednsScore(HashMap<String,List<String>> friendsGroups,HashMap<String,Integer> friendsGroupsScore,List<String> userFriends){
        for(int i=0; i<userFriends.size(); i++){
            List<String> score = friendsGroups.get(userFriends.get(i));
            for(int j=0; j<score.size(); j++){
                if(!friendsGroupsScore.containsKey(score.get(j))){
                    continue;
                }
                friendsGroupsScore.put(score.get(j),friendsGroupsScore.get(score.get(j)) + 10);
            }
        }

    }
    static void deleteOverLapFriends(List<String> friendsGroups,HashMap<String,Integer> friendsGroupsScore){
        for(int i=0; i<friendsGroups.size(); i++){
            String friends = friendsGroups.get(i);
            if(friendsGroupsScore.containsKey(friends)){
                friendsGroupsScore.remove(friends);
            }
        }
    }
    static List<String> createUserFriends(HashMap<String,List<String>> friendsGroups,String userName){
        List<String> userFriendsGroups = friendsGroups.get(userName);
        return userFriendsGroups;
    }
    static void deleteZeroScore(HashMap<String,Integer> friendsGroupsScore) {
        for(String strKey :friendsGroupsScore.keySet()){
            int strValue = friendsGroupsScore.get(strKey);
            if(strValue == 0){
                friendsGroupsScore.remove(strKey);
            }
        }
    }
    static void createfriendsGroupsScore(HashMap<String, Integer> friendsGroupsScore, List<List<String>>friends,String userName, List visitor){
        for(int i=0; i<friends.size(); i++){
            String friends1 = friends.get(i).get(0);
            String friends2 = friends.get(i).get(1);
            if(friends2.equals(userName) || friends1.equals(userName)){
                continue;
            }
            friendsGroupsScore.put(friends1,0);
            friendsGroupsScore.put(friends2,0);
        }
        for(int i=0; i<visitor.size(); i++){
            if(friendsGroupsScore.containsKey(visitor.get(i))){
                friendsGroupsScore.put((String) visitor.get(i),friendsGroupsScore.get(visitor.get(i))+1);
            }
            else{
                friendsGroupsScore.put((String) visitor.get(i),1);
            }

        }
    }
    static void createfriendsGroups(HashMap<String,List<String>> friendsGroups, List<List<String>>friends, String userName){
        for(int i=0; i<friends.size(); i++){
            String friends1 = friends.get(i).get(0);
            String friends2 = friends.get(i).get(1);

            if(!friendsGroups.containsKey(friends1)) {
                friendsGroups.put(friends1, new ArrayList<>());
            }
            if(!friendsGroups.containsKey(friends2)) {
                friendsGroups.put(friends2, new ArrayList<>());
            }
            friendsGroups.get(friends1).add(friends2);
            friendsGroups.get(friends2).add(friends1);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String,List<String>> friendsGroups = new HashMap<>();
        HashMap<String, Integer> friendsGroupsScore = new HashMap<>();
        List<String> userFriends = new ArrayList<>();

        createfriendsGroups(friendsGroups,friends,user);
        createfriendsGroupsScore(friendsGroupsScore,friends,user,visitors);
        userFriends = createUserFriends(friendsGroups,user);
        inputUserFriednsScore(friendsGroups,friendsGroupsScore,userFriends);
        deleteZeroScore(friendsGroupsScore);
        deleteOverLapFriends(userFriends,friendsGroupsScore);

        Map<String,Integer> sortedFriendsGroups = new TreeMap<>(friendsGroupsScore);
        List<String> listKeySet = new ArrayList<>(sortedFriendsGroups.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (sortedFriendsGroups.get(value2).compareTo(sortedFriendsGroups.get(value1))));

        if(listKeySet.size() <= 5) {
            for (String str : listKeySet) {
                answer.add(str);
            }
        }
        else if(listKeySet.size() > 5){
            for(int i=0; i<5; i++){
                answer.add(listKeySet.get(i));
            }
        }

        return answer;
    }
}
