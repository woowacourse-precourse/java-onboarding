package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import onboarding.problem7.RecommendationFriend;

import java.util.Collections;
import java.util.List;
import onboarding.problem7.ValueComparator;
import org.mockito.internal.matchers.Null;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String,Integer> result = new HashMap<String,Integer>();


        return answer;
    }
    private  static  List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (int i=0; i < friends.size(); i++) {
            String userA = friends.get(i).get(0);
            String userB = friends.get(i).get(1);

            if (userA == user) {
                result.add(userB);
            }  else if (userB == user) {
                result.add(userA);
            }
        }
        return result;
    }

    private static List<RecommendationFriend> sortRecommendationSocre(Map<String, Integer> recommendationFriends){
        List<RecommendationFriend> result = new ArrayList<>();
        ValueComparator valueComparator =  new ValueComparator(recommendationFriends);
        TreeMap<String,Integer> sortedMap = new TreeMap<>(valueComparator);
        int i = 0;

        sortedMap.putAll(recommendationFriends);
        result.add(new RecommendationFriend("NULL", -1));

        for (Map.Entry<String,Integer> user : sortedMap.entrySet()) {
            int recommendationScore = recommendationFriends.get(user.getKey());

            if (overScoreCount(result.size(), result.get(i).getScore(), recommendationScore)) {
                break;
            }
            i++;
            result.add(new RecommendationFriend(user.getKey(), recommendationScore));
        }
        result.remove(0);

        return result;
    }

    public static boolean overScoreCount(int scoreSize, int beforeScore, int currentScore) {
        if (scoreSize < 6) {
            return false;
        } else if (currentScore != beforeScore) {
            return true;
        }
        return false;
    }

    public static List<String> orderByName(List<RecommendationFriend> sortdRecommendationFriends) {
        boolean equalFlag;
        List<String> result = new ArrayList<>();
        Set<String> equalScore = new TreeSet<>();

        int i = 0;
        sortdRecommendationFriends.add(new RecommendationFriend("NULL", -1));

        for (i = 0; i < sortdRecommendationFriends.size() - 1; i++) {
            int currentScore = sortdRecommendationFriends.get(i).getScore();
            int nextScore = sortdRecommendationFriends.get(i + 1).getScore();
            String currentId = sortdRecommendationFriends.get(i).getId();
            String nextID = sortdRecommendationFriends.get(i + 1).getId();

            if (currentScore == nextScore) {
                equalScore.add(currentId);
                equalScore.add(nextID);
                equalFlag = false;
            } else {
                equalScore.add(currentId);
                equalFlag = true;
            }

            if (equalFlag) {
                result.addAll(equalScore);
                equalScore.clear();
            }
        }
        result.addAll(equalScore);

        return (i > 5) ? result.subList(0, 5) :  result.subList(0, i);
    }

    public static void main(String[] args) {

/*
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        map.put("ab", 50);
        map.put("a", 50);
        map.put("ac", 30);
        map.put("aa", 30);
        map.put("aq", 30);
        map.put("as", 30);


        List<RecommendationFriend> result;


        result = sortRecommendationSocre(map);

        for (RecommendationFriend i : result) {
            System.out.println(i.getId() + " - " + i.getScore());
        }

        List<String> mergeScore = orderByName(result);

        for(String s : mergeScore) {
            System.out.println(s);
        }
*/
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> t;

        t = getUserFriends("mrko" ,friends);

        for (String s : t ){
            System.out.println(s);
        }

    }
}
