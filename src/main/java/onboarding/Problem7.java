package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userAndFriendList = getFriendList(friends, user);
        userAndFriendList.add(user);

        HashMap<String, Integer> strangerScoreMap = getStrangerScoreMap(userAndFriendList, friends);
        calculateVisitorScore(visitors, userAndFriendList, strangerScoreMap);

        List<String> answer = makeAnswerList(strangerScoreMap);
        return answer;
    }

    private static List<String> makeAnswerList(HashMap<String, Integer> strangerScoreMap) {
        List<String> answerList = new ArrayList<>(strangerScoreMap.keySet());
        Collections.sort(answerList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (strangerScoreMap.get(o1) > strangerScoreMap.get(o2)) {
                    return -1;
                }
                else if (strangerScoreMap.get(o1) < strangerScoreMap.get(o2)) {
                    return 1;
                }
                else {
                    return o1.compareTo(o2);
                }
            }
        });
        removeZeroInList(answerList, strangerScoreMap);
        if (answerList.size() > 5) {
            pickTopFiveScoreMember(answerList);
        }
        return answerList;
    }

    private static void pickTopFiveScoreMember(List<String> answerList) {
        for (int i=answerList.size()-1 ; i>4; i--) {
            answerList.remove(i);
        }
    }

    private static void removeZeroInList(List<String> answerList, HashMap<String, Integer> strangerScoreMap) {
        for (int i=answerList.size()-1; i>=0; i--) {
            String key = answerList.get(i);
            int score = strangerScoreMap.get(key);
            if (score == 0) {
                answerList.remove(i);
                continue;
            }
            break;
        }
    }

    private static void calculateVisitorScore(List<String> visitors, List<String> userAndFriendList, HashMap<String, Integer> strangerScoreMap) {
        for (String visitor : visitors) {
            if (userAndFriendList.contains(visitor)) {
                continue;
            }
            strangerScoreMap.put(visitor, strangerScoreMap.getOrDefault(visitor, 0) + 1);
        }
    }

    private static HashMap<String, Integer> getStrangerScoreMap(List<String> userAndFriendList, List<List<String>> friends) {
        HashMap<String, Integer> strangerScoreMap = new HashMap<>();
        for (List<String> friendRelation : friends) {
            makeMapAndCalScore(friendRelation, userAndFriendList, strangerScoreMap);
        }
        return strangerScoreMap;
    }

    private static void makeMapAndCalScore(List<String> friendRelation, List<String> userAndFriendList, HashMap<String, Integer> strangerScoreMap) {
        String firstFriend = friendRelation.get(0);
        String secondFriend = friendRelation.get(1);

        if (userAndFriendList.contains(firstFriend) && userAndFriendList.contains(secondFriend)) {
            return;
        }
        if (userAndFriendList.contains(firstFriend) && !userAndFriendList.contains(secondFriend)) {
            strangerScoreMap.put(secondFriend, strangerScoreMap.getOrDefault(secondFriend, 0) + 10);
            return;
        }
        if (!userAndFriendList.contains(firstFriend) && userAndFriendList.contains(secondFriend)) {
            strangerScoreMap.put(firstFriend, strangerScoreMap.getOrDefault(firstFriend, 0) + 10);
            return;
        }
        strangerScoreMap.put(firstFriend, strangerScoreMap.getOrDefault(firstFriend, 0));
        strangerScoreMap.put(secondFriend, strangerScoreMap.getOrDefault(secondFriend, 0));
    }

    private static List <String> getFriendList(List<List<String>> friends, String user) {
        List<String> friendList = new ArrayList<>();
        for (List<String> friendRelation : friends) {
            if (isFriendWithUser(friendRelation, user)) {
                String friend = getFriend(friendRelation, user);
                friendList.add(friend);
            }
        }
        return friendList;
    }

    private static String getFriend(List<String> friendRelation, String user) {
        if (friendRelation.get(0).equals(user)) {
            return friendRelation.get(1);
        }
        return friendRelation.get(0);
    }

    private static boolean isFriendWithUser(List<String> friendRelation, String user) {
        return friendRelation.contains(user);
    }
}
