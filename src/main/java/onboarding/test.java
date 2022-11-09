package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {

    public static List<String> getFriends(List<List<String>> friends, String user) {
        List<String> userFriend = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                userFriend.add(friends.get(i).get(1));
            }
            if (friends.get(i).get(1).equals(user)) {
                userFriend.add(friends.get(i).get(0));
            }
        }
        return userFriend;
    }

    public static List<String> getSharedFriends(List<List<String>> friends, List<String> myfriends, String user) {
        List<String> sharedFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < myfriends.size(); j++) {
                if (friends.get(i).get(0).equals(myfriends.get(j)) && !friends.get(i).get(1).equals(user)) {
                    sharedFriends.add(friends.get(i).get(1));
                }
                if (friends.get(i).get(1).equals(myfriends.get(j)) && !friends.get(i).get(1).equals(user)) {
                    sharedFriends.add(friends.get(i).get(0));
                }
            }
        }
        return sharedFriends;
    }

    public static Map<String, Integer> getScoreBoard(List<String> sharedFriends, List<String> myfriends, List<String> visitors) {
        Map<String, Integer> scoreBoard = new TreeMap<>();
        for (String oneFriend : sharedFriends
        ) {
            if (scoreBoard.get(oneFriend) == null) {
                scoreBoard.put(oneFriend, 0);
            }
            scoreBoard.put(oneFriend, scoreBoard.get(oneFriend) + 10);
        }
        for (String visitFriend : visitors
        ) {
            if (!myfriends.contains(visitFriend)) {
                if (scoreBoard.get(visitFriend) == null) {
                    scoreBoard.put(visitFriend, 0);
                }
                scoreBoard.put(visitFriend, scoreBoard.get(visitFriend) + 1);
            }
        }
        return scoreBoard;
    }




    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "jun"),
                List.of("donut", "andole"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> myfriends = getFriends(friends, user);
        List<String> sharedFriends = getSharedFriends(friends, myfriends, user);
        Map<String, Integer> scoreBoard = getScoreBoard(sharedFriends, myfriends, visitors);


        List<Integer> scoreArray = new ArrayList<>();
        for (Integer score: scoreBoard.values()
             ) {
            scoreArray.add(score);
        }
        Collections.sort(scoreArray);
        Collections.reverse(scoreArray);

        List<String> recommendedFriends = new ArrayList<>();
        for (int i = 0; i < scoreArray.size(); i++) {
            for (String dd:scoreBoard.keySet()
                 ) {
                if (scoreBoard.get(dd) == scoreArray.get(i) && !recommendedFriends.contains(dd)) {
                    recommendedFriends.add(dd);
                }
            }
        }

        System.out.println(recommendedFriends.size());

        for (String eachScore:recommendedFriends
             ) {
            System.out.println(eachScore);
        }

    }
}