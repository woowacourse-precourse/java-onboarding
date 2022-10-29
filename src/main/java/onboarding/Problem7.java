package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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

    private static ArrayList<RecommendationFriend> sortRecommendationSocre(Map<String, Integer> recommendationFriends){
        ArrayList<RecommendationFriend> result = new ArrayList<>();
        ValueComparator valueComparator =  new ValueComparator(recommendationFriends);
        TreeMap<String,Integer> sortedMap = new TreeMap<>(valueComparator);
        int i = 0;

        sortedMap.putAll(recommendationFriends);

        for (Map.Entry<String,Integer> entry : sortedMap.entrySet()) {
            result.add(new RecommendationFriend(entry.getKey(), recommendationFriends.get(entry.getKey())));
        }
        return result;
    }

    public static void main(String[] args) {


        HashMap<String,Integer> map = new HashMap<String,Integer>();

        map.put("a", 50);
        map.put("aa", 50);
        map.put("ab", 50);
        map.put("c", 30);
        map.put("d", 20);

        ArrayList<RecommendationFriend> result;


        result = sortRecommendationSocre(map);

        for (RecommendationFriend i : result) {
            System.out.println(i.getId() + " - " + i.getScore());
        }



    }
}
