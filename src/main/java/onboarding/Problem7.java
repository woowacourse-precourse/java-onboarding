package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> answerResult = result(user, friends, visitors);
        for (int i = 0; i < 5 && i < answerResult.size(); i++) {
            answer.add(answerResult.get(i));
        }
        return answer;
    }

    public static List<String> result(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = userFriends(user, friends);
        List<String> notUserFriends = notUserFriends(user, userFriends, friends, visitors);
        HashMap<String, Integer> candidateAndScore = makeCandidates(friends, notUserFriends, userFriends, visitors);

        List<String> result = new ArrayList<>(candidateAndScore.keySet());
        Collections.sort(result);
        result.sort((o1, o2) -> candidateAndScore.get(o2).compareTo(candidateAndScore.get(o1)));
        List<String> answerResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (candidateAndScore.get(result.get(i)) > 0)
                answerResult.add(result.get(i));
        }
        return answerResult;
    }


    public static List<String> userFriends (String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (user.equals((friends.get(i).get(0))) && !userFriends.contains(friends.get(i).get(1)))
                userFriends.add(friends.get(i).get(1));
            if (user.equals((friends.get(i).get(1))) && !userFriends.contains(friends.get(i).get(0)))
                userFriends.add(friends.get(i).get(0));
        }
        return userFriends;
    }
    public static List<String> notUserFriends(String user, List<String> userFriends, List<List<String>> friends, List<String> visitors) {
        Set<String> notUserFriends = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if(friends.get(i).get(j).equals(user) || userFriends.contains(friends.get(i).get(j)))
                    continue;
                notUserFriends.add(friends.get(i).get(j));
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            if (userFriends.contains(visitors.get(i)))
                continue;
            notUserFriends.add(visitors.get(i));
        }
        return new ArrayList<>(notUserFriends);
    }

    private static HashMap<String, Integer> makeCandidates(List<List<String>> friends, List<String> notUserFriends, List<String> userFriends, List<String> visitors) {
        HashMap<String,Integer> makeCandidates = new HashMap<>();
        for (int i = 0; i < notUserFriends.size(); i++) {
            String candidate = notUserFriends.get(i);
            makeCandidates.put(candidate, score(candidate, userFriends, visitors, friends));
        }
        return makeCandidates;
    }
    public static int score(String candidate, List<String> userFriends, List<String> visitors, List<List<String>> friends) {
        int friendOfFriendsScore = friendOfFriendsScore(candidate, userFriends, friends);
        int visitScore = visitScore(candidate, visitors);
        int score = friendOfFriendsScore + visitScore;

        return score;
    }

    public static int friendOfFriendsScore (String candidate, List<String> userFriends, List<List<String>> friends) {
        int count = 0;
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < userFriends.size(); j++) {
                if (friends.get(i).contains(userFriends.get(j)) && friends.get(i).contains(candidate))
                    count++;
            }
        }
        return count * 10;
    }
    public static int visitScore (String candidate, List<String> visitors) {
        int count = 0;
        for (int i = 0; i < visitors.size(); i++) {
            if(visitors.get(i).equals(candidate))
                count++;
        }
        return count;
    }
}
