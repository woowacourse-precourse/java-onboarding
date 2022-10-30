package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String, Integer> friendCandidate = new HashMap<>();
    private static Set<String> oldFriend = new HashSet<>();
    private static List<List<String>> friendData;
    private static String owner;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = getRecomendedFriends(user,friends,visitors);
        return answer;
    }


    private static List<String> getRecomendedFriends(String user, List<List<String>> friends, List<String> visitors){
        settingForStaticValue(user,friends);
        increaseFriendWeightByRelationship(List.copyOf(oldFriend));
        increaseFriendWeightByVisted(visitors);
        return getMostSuitableFriend(5);
    }
    private static void settingForStaticValue(String user, List<List<String>> friends){
        friendData=friends;
        owner=user;
        List<String> olderFriends = getFriendOfUser(user);
        olderFriends.stream().forEach(a->oldFriend.add(a));
    }

    private static List<String> getFriendOfUser(String user) {
        List<String> friendList = new ArrayList<>();
        for(int i=0; i<friendData.size(); i++){
            if(friendData.get(i).contains(user)){
                int friendIndex = (friendData.get(i).indexOf(user)+1)%2;
                friendList.add(friendData.get(i).get(friendIndex));
            }
        }
        return friendList;
    }

    private static void increaseFriendWeightByRelationship(List<String> friend){
        List<String> friendCheckList=new ArrayList<>(friend);
        friendCheckList.add(owner);
        for(int i=0; i<friendData.size(); i++){
            List<String> friendRelationshipInFriendData = friendData.get(i);
            Long numberOfFriendByFriendList = friendRelationshipInFriendData.stream().filter(a->friendCheckList.contains(a)).count();
            if(numberOfFriendByFriendList>=1){
                friendRelationshipInFriendData.stream()
                        .filter(a->!friendCheckList.contains(a))
                        .filter(a->!oldFriend.contains(a))
                        .forEach(a->increaseWeight(a,10));
            }
        }
    }

    private static void increaseWeight(String candidate, Integer score){
        if(friendCandidate.containsKey(candidate)){
            friendCandidate.replace(candidate, friendCandidate.get(candidate)+score);
            return;
        }
        friendCandidate.put(candidate,score);
    }

    private static void increaseFriendWeightByVisted(List<String> visitors){
        for(int i=0; i<visitors.size(); i++){
            if(oldFriend.contains(visitors.get(i))){
                continue;
            }
            increaseWeight(visitors.get(i),1);
        }
    }

    private static List<String> getMostSuitableFriend(int count){
        List<String> keySet =  new ArrayList<>(friendCandidate.keySet());
        keySet.sort((o1, o2) -> friendCandidate.get(o2).compareTo(friendCandidate.get(o1)));
        return keySet.stream().limit(count).collect(Collectors.toList());
    }

}
