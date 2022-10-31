package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 1. user와 친구인 사람들(userFriends)을 가져오고
        // 2. usersFriends과 친구인 사람들의 점수를 정리
        // 3. visitors의 점수 정리

        HashMap<String, List<String>> userHashMap = new HashMap<>();
        HashMap<String, Integer> scoreHashMap = new HashMap<>();


        userHashMap = makeHashMap(userHashMap, user, friends);
        scoreHashMap = getFriendsHashMap(userHashMap, scoreHashMap, user, friends);

        return answer;
    }

    public static HashMap<String, List<String>> makeHashMap(HashMap<String, List<String>> hashMap, String name, List<List<String>> friends) {
        List<String> friendsList = new ArrayList<>();
        hashMap.put(name, friendsList);

        for(int i = 0; i < friends.size(); i++) {
            List<String> tempFriendsList = friends.get(i);
            if (tempFriendsList.contains(name)) {
                if (tempFriendsList.get(0).equals(name)) {
                    List<String> tempUserFriendsList = hashMap.get(name);
                    tempUserFriendsList.add(tempFriendsList.get(1));
                    hashMap.put(name, tempUserFriendsList);
                }
                else if(tempFriendsList.get(1).equals(name)) {
                    List<String> tempUserFriendsList = hashMap.get(name);
                    tempUserFriendsList.add(tempFriendsList.get(0));
                    hashMap.put(name, tempUserFriendsList);
                }
            }
        }

        return hashMap;
    }

    public static HashMap<String, Integer> makeScoreHashMap
            (HashMap<String, Integer> scoreHashMap, String friendName, List<List<String>> friends, String user) {
        List<String> friendsList = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++) {
            List<String> tempFriendsList = friends.get(i);
            if (tempFriendsList.contains(friendName)) {
                if (tempFriendsList.get(0).equals(friendName)) {
                    String recommandFriend = tempFriendsList.get(1);

                    if (recommandFriend.equals(user)) {
                        continue;
                    }

                    if (!(scoreHashMap.containsKey(recommandFriend))) {
                        scoreHashMap.put(recommandFriend, 10);
                    }
                    else {
                        int currentScore = scoreHashMap.get(recommandFriend);
                        scoreHashMap.put(recommandFriend, currentScore + 10);
                    }
                }
                else if(tempFriendsList.get(1).equals(friendName)) {
                    String recommandFriend = tempFriendsList.get(0);

                    if (recommandFriend.equals(user)) {
                        continue;
                    }

                    if (!(scoreHashMap.containsKey(recommandFriend))) {
                        scoreHashMap.put(recommandFriend, 10);
                    }
                    else {
                        int currentScore = scoreHashMap.get(recommandFriend);
                        scoreHashMap.put(recommandFriend, currentScore + 10);
                    }
                }
            }
        }

        return scoreHashMap;
    }


    public static HashMap<String, Integer> getFriendsHashMap
            (HashMap<String, List<String>> userHashMap, HashMap<String, Integer> scoreHashMap, String user, List<List<String>> friends) {
        List<String> userFriends = userHashMap.get(user);

        for (int i = 0; i < userFriends.size(); i++) {
            String friendName = userFriends.get(i);
            scoreHashMap = makeScoreHashMap(scoreHashMap, friendName, friends, user);
        }

        return scoreHashMap;
    }

}
