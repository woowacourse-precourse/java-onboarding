package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 1. user와 친구인 사람들(userFriends)을 가져오고
        // 2. usersFriends과 친구인 사람들의 점수를 정리
        // 3. visitors의 점수 정리

        HashMap<String, List<String>> userHashMap = new HashMap<>();
        HashMap<String, Integer> scoreHashMap = new HashMap<>();


        userHashMap = makeHashMap(userHashMap, user, friends);
        scoreHashMap = getScoreHashMap(userHashMap, scoreHashMap, user, friends);
        scoreHashMap = plusVisitorsScoreHashMap(scoreHashMap, visitors, userHashMap, user);

        answer = getResult(scoreHashMap);

        return answer;
    }

    public static HashMap<String, List<String>> makeHashMap
            (HashMap<String, List<String>> hashMap, String name, List<List<String>> friends) {
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


    public static HashMap<String, Integer> getScoreHashMap
            (HashMap<String, List<String>> userHashMap, HashMap<String, Integer> scoreHashMap, String user, List<List<String>> friends) {
        List<String> userFriends = userHashMap.get(user);

        for (int i = 0; i < userFriends.size(); i++) {
            String friendName = userFriends.get(i);
            scoreHashMap = makeScoreHashMap(scoreHashMap, friendName, friends, user);
        }

        return scoreHashMap;
    }

    public static HashMap<String, Integer> plusVisitorsScoreHashMap
            (HashMap<String, Integer> scoreHashMap, List<String> visitors, HashMap<String, List<String>> userFriendsHashMap, String user) {

        List<String> userFriends = userFriendsHashMap.get(user);

        for (int i = 0; i < visitors.size(); i++) {
            String visitorName = visitors.get(i);

            if(userFriends.contains(visitorName)) {
                continue;
            }

            if (scoreHashMap.containsKey(visitorName)) {
                int curScore = scoreHashMap.get(visitorName);
                scoreHashMap.put(visitorName, curScore + 1);
            }
            else {
                scoreHashMap.put(visitorName, 1);
            }
        }

        return scoreHashMap;
    }

    public static List<String> getResult(HashMap<String, Integer> scoreHashMap) {
        List<String> result = new ArrayList<>();

        List<Map.Entry<String, Integer>> scoreEntries
                = scoreHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (int i = 0; i < scoreEntries.size(); i++) {
            if (scoreEntries.get(i).getValue() > 0) {
                result.add(scoreEntries.get(i).getKey());
            }

            if (result.size() >= 5) {
                break;
            }

        }

        return result;
    }

}
