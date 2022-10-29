package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;
import onboarding.problem7.RecommendationFriend;

import java.util.Collections;
import java.util.List;
import onboarding.problem7.ValueComparator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();


        return answer;
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

    public static void main(String[] args) {


        HashMap<String,Integer> map = new HashMap<String,Integer>();

        map.put("a", 50);
        map.put("aa", 50);
        map.put("ab", 50);
        map.put("c", 30);
        map.put("d", 20);
        map.put("da", 20);
        map.put("dc", 20);
        map.put("de", 19);

        List<RecommendationFriend> result;


        result = sortRecommendationSocre(map);

        for (RecommendationFriend i : result) {
            System.out.println(i.getId() + " - " + i.getScore());
        }



    }
}
