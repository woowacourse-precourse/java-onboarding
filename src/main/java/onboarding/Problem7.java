package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        return answer;
    }

    public static List<String> getAlreadyFriend(String user, List<List<String>> friends) {
        List<String> alreadyFriend = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                alreadyFriend.add(friends.get(i).get(0));
            }
        }
        return alreadyFriend;
    }
    public static List<List<String>> getFriendCountKnownTogether(String user, List<String> alreadyFriend, List<List<String>> friends) {
        List<List<String>> recommendationFriend = new ArrayList<>();

        for (int i = 0; i < alreadyFriend.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).get(0).equals(alreadyFriend.get(i)) && !friends.get(j).contains(user)) {
                    recommendationFriend.add(List.of(friends.get(j).get(1), "10"));
                }
            }
        }
        return recommendationFriend;
    }
    public static List<List<String>> getCountofVisitor(List<String> visitors, List<List<String>> recommendationFriend) {
        for (int i = 0; i < visitors.size(); i++) {
            recommendationFriend.add(List.of(visitors.get(i), "1"));
        }
        return recommendationFriend;
    }
    public static List<List<String>> getRecommendedFriend(List<List<String>> recommendationFriend, List<String> alreadyFriend) {
        Set<String> nameSet = new HashSet<>();
        for (int i = 0; i < recommendationFriend.size(); i++) {
            nameSet.add(recommendationFriend.get(i).get(0));
        }
        nameSet.removeAll(Set.copyOf(alreadyFriend));

        List<String> nameList = new ArrayList<>(nameSet);
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {
            Integer score = 0;
            for (int j = 0; j < recommendationFriend.size(); j++) {
                if (nameList.get(i).equals(recommendationFriend.get(j).get(0))) {
                    score += Integer.parseInt(recommendationFriend.get(j).get(1));
                }
            }
            result.add(List.of(nameList.get(i), score.toString()));
        }
        return result;
    }
//    public static void sortByScore() {}

}
