package onboarding;

import java.util.*;

public class Problem7 {

    private static HashMap<String, ArrayList<String>> friendListMap = new HashMap<>();
    private static HashMap<String, Integer> scoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        initFriendListMap(friends);
        initScoreMap(visitors);
        setCommonFriendScore(user);
        setVisitorScore(user, visitors);
        answer = compareAndSort();

        return answer;
    }

    private static void initFriendListMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if (!friendListMap.keySet().contains(friendA)) {
                friendListMap.put(friendA, new ArrayList<>());
            }
            friendListMap.get(friendA).add(friendB);

            if (!friendListMap.keySet().contains(friendB)) {
                friendListMap.put(friendB, new ArrayList<>());
            }
            friendListMap.get(friendB).add(friendA);
        }
    }

    private static void initScoreMap(List<String> visitors) {
        for (String friendName : friendListMap.keySet()) {
            scoreMap.put(friendName, 0);
        }

        for (String visitor : visitors) {
            if (!scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, 0);
            }
        }
    }

    private static void setCommonFriendScore(String user) {
        ArrayList<String> userFriendList = friendListMap.get(user);

        for (String friend : friendListMap.keySet()) {
            if (!friend.equals(user)) {
                ArrayList<String> enrolledFriends = friendListMap.get(friend);
                for (String enrolledFriend : enrolledFriends) {
                    if (userFriendList.contains(enrolledFriend)) {
                        int curScore = scoreMap.get(friend);
                        scoreMap.put(friend, curScore + 10);
                    }
                }
            }
        }
    }

    private static void setVisitorScore(String user, List<String> visitors) {
        ArrayList<String> userFriendList = friendListMap.get(user);

        for (String visitor : visitors) {
            if (!userFriendList.contains(visitor)) {
                int curScore = scoreMap.get(visitor);
                scoreMap.put(visitor, curScore + 1);
            }
        }
    }

    private static List<String> compareAndSort() {
        List<UserInfo> processList = new ArrayList<>();
        List<String> rtnList = new ArrayList<>();

        for (String userName : scoreMap.keySet()) {
            processList.add(new UserInfo(userName, scoreMap.get(userName)));
        }

        Collections.sort(processList);

        for (UserInfo userInfo : processList) {
            if (rtnList.size() >= 5) {
                break;
            } else {
                if (userInfo.score > 0) {
                    rtnList.add(userInfo.userName);
                }
            }
        }

        return rtnList;
    }

    private static class UserInfo implements Comparable<UserInfo>{
        String userName;
        Integer score;

        public UserInfo(String userName, Integer score) {
            this.userName = userName;
            this.score = score;
        }

        @Override
        public int compareTo(UserInfo o) {
            return Integer.compare(o.score, this.score);
        }
    }
}
