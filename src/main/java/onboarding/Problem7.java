package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> friendsRelation = friendsRelation(friends);
        HashMap<String, Integer> scoreRelation = scoreRelation(visitors);
        HashMap<String, Integer> extraRelation = extraRelation(friendsRelation, scoreRelation, user);
        HashMap<Integer, List<String>> scoreTable = reverseScoreRelation(extraRelation);
        List<String> answer = sortScoreTable(scoreTable, user);
        return answer;
    }
    private static HashMap<String, List<String>> friendsRelation(List<List<String>> friends) {
        HashMap<String, List<String>> relation = new HashMap<String, List<String>>();
        for (List<String> twoFriends : friends) {
            List<String> basic = new ArrayList<String>();
            String person1 = twoFriends.get(0);
            String person2 = twoFriends.get(1);
            List<String> friends1 = relation.getOrDefault(person1, basic);
            List<String> friends2 = relation.getOrDefault(person2, basic);
            friends1.add(person2);
            friends2.add(person1);
            relation.put(person1, friends1);
            relation.put(person2, friends2);
        }
        return relation;
    }

    private static HashMap<String, Integer> scoreRelation(List<String> visitors) {
        HashMap<String, Integer> relation = new HashMap<String, Integer>();
        for (String visitor : visitors) {
            int before = relation.getOrDefault(visitor, 0);
            relation.put(visitor, before+1);
            relation.put(visitor, before+1);
        }
        return relation;
    }

    private static HashMap<String, Integer> scoreRelation(List<String> candidate, HashMap<String, Integer> scoreRelation) {
        for (String candi : candidate) {
            int before = scoreRelation.getOrDefault(candi, 0);
            scoreRelation.put(candi, before+10);
            scoreRelation.put(candi, before+10);
        }
        return scoreRelation;
    }
    private static HashMap<String, Integer> extraRelation(HashMap<String, List<String>> friendsRelation, HashMap<String, Integer> scoreRelation, String user) {
        List<String> basic = new ArrayList<String> ();
        List<String> friends = friendsRelation.getOrDefault(user, basic);
        for (String friend: friends) {
            List<String> candidate = friendsRelation.getOrDefault(friend, basic);
            scoreRelation = scoreRelation(candidate, scoreRelation);
        }
        scoreRelation = removeFriends(friends, scoreRelation);
        return scoreRelation;
    }

    private static HashMap<String, Integer> removeFriends(List<String> friends, HashMap<String, Integer> scoreRelation) {
        for (String friend: friends) {
            scoreRelation.remove(friend);
        }
        return scoreRelation;
    }

    private static HashMap<Integer, List<String>> reverseScoreRelation(HashMap<String, Integer> scoreRelation) {
        HashMap<Integer, List<String>> scores = new HashMap<Integer, List<String>>();
        List<String> basic = new ArrayList<String>();
        for (String key: scoreRelation.keySet()) {
            int score = scoreRelation.get(key);
            List<String> socreList = scores.getOrDefault(key, basic);
            socreList.add(key);
            scores.put(score, socreList);
        }
        scores.remove(0);
        return scores;
    }

    private static List<String> sortScoreTable(HashMap<Integer, List<String>> scoreTable, String user) {
        Object[] mapkey = scoreTable.keySet().toArray();
        Arrays.sort(mapkey);
        List<String> total = new ArrayList<>();
        for (int key : scoreTable.keySet())
        {
            List<String> candidate = scoreTable.get(key);
            total.addAll(candidate);
        }
        total = removeDuplicate(total);
        total.removeAll(Collections.singleton(user));
        if (total.size() < 5) {
            return total;
        }
        return total.subList(0, 5);
    }

    private static List<String> removeDuplicate(List<String> list) {
        List<String> result = new ArrayList<String>();
        for (String l : list) {
            if(!result.contains(l)) {
                result.add(l);
            }
        }
        return result;
    }
}
