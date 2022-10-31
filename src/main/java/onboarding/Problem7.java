package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,Set<String>> friendShip= findOutFriendship(friends);
        Map<String, Integer> grade = new HashMap<>();
        Set<String> myFriend=friendShip.get(user);
        for(String otherUser: friendShip.keySet()){
            Set<String> intersection=new HashSet<>(myFriend);
            intersection.retainAll(friendShip.get(otherUser));
            grade.put(otherUser,intersection.size()*10);
        }
        for(String otherUser: visitors){
            if (grade.containsKey(otherUser)){
                grade.put(otherUser,grade.get(otherUser)+1);
            }else{
                grade.put(otherUser,1);
            }
        }
        List<Map.Entry<String, Integer>> sortedFriendCandidate=sortMapByValue(grade);
        List<String> topFive=new ArrayList<>();
        int i=0;
        for(Map.Entry<String, Integer> friendCandidate:sortedFriendCandidate){
            if(i>=5){
                break;
            }
            if(friendCandidate.getValue().equals(0)){
                continue;
            }
            if(myFriend.contains(friendCandidate.getKey())){
                continue;
            }
            if(friendCandidate.getKey().equals(user)){
                continue;
            }
            topFive.add(friendCandidate.getKey());
            i+=1;
        }
        return topFive;
    }

    private static Map<String,Set<String>> findOutFriendship(List<List<String>>friends){
        Map<String, Set<String>> friendShip = new HashMap<>();
        for(List<String> relationship:friends){
            String firstHuman = relationship.get(0);
            String secondHuman = relationship.get(1);
            if(!friendShip.containsKey(firstHuman)){
                friendShip.put(firstHuman,new HashSet<>());
            }
            if(!friendShip.containsKey((secondHuman))){
                friendShip.put(secondHuman, new HashSet<>());
            }
            friendShip.get(firstHuman).add(secondHuman);
            friendShip.get(secondHuman).add(firstHuman);
        }
        return friendShip;
    }

    private static List<Map.Entry<String, Integer>> sortMapByValue(Map<String,Integer> map){
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Problem7::compareUserGrade);
        return entries;
    }

    private static int compareUserGrade(Map.Entry<String,Integer> human1, Map.Entry<String,Integer>human2){
        if(human1.getValue().equals(human2.getValue())){
            return human1.getKey().compareTo(human2.getKey());
        }
        return -(human1.getValue()-human2.getValue());
    }
}
