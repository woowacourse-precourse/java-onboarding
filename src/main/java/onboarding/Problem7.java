package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> findFriends(String user, List<List<String>> friends) {
        List<String> myFriend = new ArrayList<>();
        for(int i=0; i<friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) myFriend.add(friends.get(i).get(1));
            else if(friends.get(i).get(1).equals(user)) myFriend.add(friends.get(i).get(0));
        }
        return myFriend;
    }

    public static HashMap<String, Integer> relatedFriendScore(String user, List<String> myFriend, List<List<String>> friends) {
        HashMap<String, Integer> relatedFriend = new HashMap<>();
        for(int i=0; i<myFriend.size(); i++) {
            String name = myFriend.get(i);
            for(int j=0; j<friends.size(); j++) {
                if(friends.get(j).get(0).equals(user) || friends.get(j).get(1).equals(user)) continue;
                if(friends.get(j).get(0).equals(name)) relatedFriend.put(friends.get(j).get(1), 10);
                else if(friends.get(j).get(1).equals(name)) relatedFriend.put(friends.get(j).get(0), 10);
            }
        }
        return relatedFriend;
    }

    public static HashMap<String, Integer> visitorScore(List<String> myFriend, HashMap<String, Integer> related, List<String> visitors) {
        for(int i=0; i<visitors.size(); i++) {
            Boolean friendFlag = false;
            for(String friend : myFriend) {
                if(visitors.get(i).equals(friend)) friendFlag = true;
            }

            if(!friendFlag) {
                if(related.containsKey(visitors.get(i))) {
                    related.replace(visitors.get(i), related.get(visitors.get(i))+1);
                }
                else {
                    related.put(visitors.get(i), 1);
                }
            }
        }
        return related;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> myFriend = findFriends(user, friends);
        HashMap<String, Integer> related = relatedFriendScore(user, myFriend, friends);
        HashMap<String, Integer> score = visitorScore(myFriend, related, visitors);

        List<Map.Entry<String, Integer>> scoreList = new LinkedList<>(score.entrySet());
        scoreList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        if(scoreList.size() < 5) {
            for(int i=0; i<scoreList.size(); i++) {
                answer.add(scoreList.get(i).getKey());
            }
        }
        else {
            for(int i=0; i<5; i++) {
                answer.add(scoreList.get(i).getKey());
            }
        }
        return answer;
    }
}
