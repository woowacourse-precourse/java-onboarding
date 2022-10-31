package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        if(user.length()<1 || user.length()>30)
            return answer;
        if (friends.size()<1 || friends.size()>10000)
            return answer;
        if (visitors.size()<0 || visitors.size()>10000)
            return answer;
        if (!user.toLowerCase().equals(user))
            return answer;

        ArrayList<String> oldFriends= (ArrayList<String>) getOldFriends(user, friends);
        Map<String,Integer> friendScores = new HashMap<String,Integer>();

        for (int i=0; i<oldFriends.size(); i++){
            for (int j=0; j<friends.size();j++){
                boolean isUserRelation = friends.get(j).contains(user);
                if (isUserRelation)
                    continue;

                boolean isMutualFriend = friends.get(j).contains(oldFriends.get(i));
                if (isMutualFriend){
                    friendScores = calculateMutualFriendScore(friendScores, oldFriends.get(i),friends.get(j));
                }
            }
        }

        for (int i=0; i<visitors.size();i++){
            boolean isUser = visitors.get(i).equals(user);
            boolean isOldFriend = oldFriends.contains(visitors.get(i));
            if (!isUser && !isOldFriend)
                friendScores = calculateVisitorScore(friendScores,visitors.get(i));
        }
        answer = getRecommendedFriends(friendScores);

        return answer;
    }

    public static List<String> getOldFriends(String user, List<List<String>> friends){
        ArrayList<String> oldFriends = new ArrayList<String>();

        for (int i=0; i<friends.size(); i++){
            if (friends.get(i).contains(user)){
                if (friends.get(i).get(0).equals(user))
                    oldFriends.add(friends.get(i).get(1));
                else
                    oldFriends.add(friends.get(i).get(0));
            }
        }
        return oldFriends;
    }

    public static Map<String,Integer> updateScore(Map<String,Integer> friendScores, String recommendedUsername, int scoreSize){
        if (friendScores.containsKey(recommendedUsername)){
            friendScores.put(recommendedUsername,friendScores.get(recommendedUsername)+scoreSize);
        }else{
            friendScores.put(recommendedUsername,scoreSize);
        }
        return friendScores;
    }

    public static Map<String,Integer> calculateMutualFriendScore(Map<String,Integer> friendScores,String oldFriend, List<String> friendRelation){
        String mutualFriend = friendRelation.get(0);

        if (oldFriend.equals(mutualFriend)){
            friendScores = (HashMap<String,Integer>) updateScore(friendScores, friendRelation.get(1),10);
        } else{
            friendScores = (HashMap<String,Integer>) updateScore(friendScores, friendRelation.get(0),10);
        }
        return friendScores;
    }

    public static Map<String,Integer> calculateVisitorScore(Map<String,Integer> friendScores, String visitor){
        friendScores = (HashMap<String,Integer>) updateScore(friendScores, visitor,1);
        return friendScores;
    }

    public static List<String> getRecommendedFriends(Map<String,Integer> friendScores){
        ArrayList<String> answer = getSortedList(friendScores);
        if (answer.size()<=5)
            return answer;
        else
            return answer.subList(0,4);
    }

    public static ArrayList<String> getSortedList(Map<String, Integer> friendScores) {
        ArrayList<String> answer = new ArrayList<String>(friendScores.keySet());
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (friendScores.get(o2)== friendScores.get(o1))
                    return o1.compareTo(o2);

                return friendScores.get(o2)- friendScores.get(o1);
            }
        });
        return answer;
    }
}
