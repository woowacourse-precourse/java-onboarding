package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static HashMap<String, ArrayList<String>> friendListMap = new HashMap<>();
    private static HashMap<String, Integer> scoreMap = new HashMap<>();

    public static void main(String[] args) {
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        solution("mrko",friends, visitors);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<UserInfo> processList = new ArrayList<>();

        initFriendListMap(friends);
        initScoreMap(visitors);
        setCommonFriendScore(user);
        setVisitorScore(visitors);

        for (String userName : scoreMap.keySet()) {
            processList.add(new UserInfo(userName, scoreMap.get(userName)));
        }

        for (String s : scoreMap.keySet()) {
            System.out.println("s = " + s);
            System.out.println(scoreMap.get(s));
            System.out.println();
        }

//        Collections.sort(processList, new Comparator<UserInfo>() {
//            @Override
//            public int compare(UserInfo o1, UserInfo o2) {
//                return o2.score - o1.score;
//            }
//        });
//
//        for (UserInfo userInfo : processList) {
//            if (answer.size() >= 5) {
//                break;
//            } else {
//                if (userInfo.score > 0) {
//                    answer.add(userInfo.userName);
//                }
//            }
//        }

        return answer;
    }

    private static void initFriendListMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if (!friendListMap.keySet().contains(friendA)) {
                friendListMap.put(friendA, new ArrayList<>());
            }else{
                friendListMap.get(friendA).add(friendB);
            }

            if (!friendListMap.keySet().contains(friendB)) {
                friendListMap.put(friendB, new ArrayList<>());
            }else{
                friendListMap.get(friendB).add(friendA);
            }
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

    private static void setVisitorScore(List<String> visitors) {
        for (String visitor : visitors) {
            int curScore = scoreMap.get(visitor);
            scoreMap.put(visitor, curScore + 1);
        }
    }

    private static class UserInfo{
        String userName;
        Integer score;

        public UserInfo(String userName, Integer score) {
            this.userName = userName;
            this.score = score;
        }
    }
}
