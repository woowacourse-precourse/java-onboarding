package onboarding;

import java.util.*;

public class Problem7 {
    public static void catchException(String user, List<List<String>> friends, List<String> visitors) {
        assert user.length() >= 1;
        assert user.length() <= 30;
        assert friends.size() >= 1;
        assert friends.size() <= 10000;
        for (int i = 0; i < friends.size(); i++) {
            assert friends.get(i).size() == 2;
            assert friends.get(i).get(0).length() >= 1;
            assert friends.get(i).get(0).length() <= 30;
            assert friends.get(i).get(1).length() >= 1;
            assert friends.get(i).get(1).length() <= 30;
            assert friends.get(i).get(0).matches("^[a-z]*$");
        }
        assert visitors.size() >= 0;
        assert visitors.size() <= 10000;
    }

    public static List<String> FindDirectFriends(String user, List<List<String>> friends) {
        List<String> directFriendsList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                directFriendsList.add(friends.get(i).get(1));
            }
            if (user.equals(friends.get(i).get(1))) {
                directFriendsList.add(friends.get(i).get(0));
            }
        }
        return directFriendsList;
    }

    public static List<String> FindTogetherKnowFriends(String user, List<List<String>> friends, List<String> directFriends) {
        List<String> togetherKnowFriends = new ArrayList<>();
        for (int i = 0; i < directFriends.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (directFriends.get(i).equals(friends.get(j).get(0)) && !friends.get(j).get(1).equals(user)) {
                    togetherKnowFriends.add(friends.get(j).get(1));
                }
                if (directFriends.get(i).equals(friends.get(j).get(1)) && !friends.get(j).get(0).equals(user)) {
                    togetherKnowFriends.add(friends.get(j).get(0));
                }
            }
        }
        return togetherKnowFriends;
    }

    public static void countVisitorsRecommendScore(List<String> visitors, List<List<String>> countScore) {
        for (int i = 0; i < visitors.size(); i++) {
            {
                countScore.get(i).add(visitors.get(i));
                countScore.get(i).add("1");
            }
        }
    }

    public static void countTogetherRecommendScore(List<String> visitors, List<String> togetherKnowFriends, List<List<String>> countScore) {
        for (int i = 0; i < togetherKnowFriends.size(); i++) {
            countScore.get(i + visitors.size()).add(togetherKnowFriends.get(i));
            countScore.get(i + visitors.size()).add("10");
        }
    }

    public static void mergeRecommendScore(List<List<String>> countScore) {
        for (int i = 0; i < countScore.size() - 1; i++) {
            for (int j = i + 1; j < countScore.size(); j++) {
                if (countScore.get(i).get(0).equals(countScore.get(j).get(0))) {
                    int num = Integer.parseInt(countScore.get(i).get(1)) + Integer.parseInt(countScore.get(j).get(1));
                    countScore.get(i).remove(1);
                    countScore.get(i).add(String.valueOf(num));
                    countScore.remove(j);
                }
            }
        }
    }

    public static void removeDirectFriendInRecommend(List<String> directFriends, List<List<String>> countScore) {
        for (int i = 0; i < directFriends.size(); i++)
            for (int j = 0; j < countScore.size(); j++) {
                if (directFriends.get(i).equals(countScore.get(j).get(0)))
                    countScore.remove(j);
            }
    }

    public static List<List<String>> sortRecommendList(List<List<String>> countScore) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < countScore.size(); i++)
            result.add(new ArrayList<>());
        int maxIndex;
        int countSize = countScore.size();
        for (int i = 0; i < countSize; i++) {
            maxIndex = 0;
            for (int j = 0; j < countScore.size() - 1; j++) {
                if (Integer.parseInt(countScore.get(j).get(1)) < Integer.parseInt(countScore.get(j + 1).get(1))) {
                    maxIndex = j + 1;
                }
                if ((Integer.parseInt(countScore.get(j).get(1)) == Integer.parseInt(countScore.get(j + 1).get(1))) &&
                        (countScore.get(j).get(0).compareTo(countScore.get(j + 1).get(0)) < 0)) {
                    maxIndex = j;
                }
            }
            result.get(i).add(countScore.get(maxIndex).get(0));
            result.get(i).add(countScore.get(maxIndex).get(1));
            countScore.remove(maxIndex);
        }
        return result;
    }

    public static List<String> selectRecommendFriends(List<List<String>> sortScore) {
        List<String> finalRecommendFriends = new ArrayList<>();
        int count = 5;
        if (sortScore.size() < 5)
            count = sortScore.size();
        for (int i = 0; i < count; i++) {
            finalRecommendFriends.add(sortScore.get(i).get(0));
        }
        return finalRecommendFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        catchException(user, friends, visitors);
        List<List<String>> countScore = new ArrayList<>();
        List<String> answer;
        List<String> directFriends = FindDirectFriends(user, friends);
        List<String> togetherKnowFriends = FindTogetherKnowFriends(user, friends, directFriends);

        for (int i = 0; i < visitors.size() + togetherKnowFriends.size(); i++) {
            countScore.add((new ArrayList<>()));
        }

        countVisitorsRecommendScore(visitors, countScore);
        countTogetherRecommendScore(visitors, togetherKnowFriends, countScore);
        mergeRecommendScore(countScore);
        removeDirectFriendInRecommend(directFriends, countScore);
        List<List<String>> sortScore = sortRecommendList(countScore);

        answer = selectRecommendFriends(sortScore);
        return answer;
    }
}
