package onboarding;

import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        List<String> visitorsList;
        Map<String,Integer> recommendationFriendsMap;

        visitorsList = friendsInVisitorsRemover(getUserFriends(user,friends), visitors);

        recommendationFriendsMap = getRecommendationFriendsMap(visitorsList,getUserFriends(user,friends),excludingUserList(user,friends));

        answer = topFiveRankCalculator(recommendationFriendsScoreManagement(recommendationFriendsMap,visitorsList,getUserFriends(user,friends),excludingUserList(user,friends)));

        return answer;
    }//public static List<String> solution

    public static List<String> getUserFriends(String user, List<List<String>> friends){
        List<String> userFriendsList = new ArrayList<>();

        for (List<String> friend : friends) {
            if (Objects.equals(user, friend.get(0))) {
                userFriendsList.add(friend.get(1));
            } else if (Objects.equals(user, friend.get(1))) {
                userFriendsList.add(friend.get(0));
            }
        }
        return userFriendsList;
    }//public static List<String> getUserFriends

    public static List<List<String>> excludingUserList (String user, List<List<String>> friends){
        List<List<String>> excludingUserList = new ArrayList<>();

        for (List<String> friend : friends) {
            if (!Objects.equals(user, friend.get(0))
                    && !Objects.equals(user, friend.get(1))) {
                excludingUserList.add(friend);
            }
        }
        return excludingUserList;
    }//public static List<List<String>> excludingMeList

    public static List<String> friendsInVisitorsRemover(List<String> getUserFriends, List<String> visitors){
        List<String> visitorsList = new ArrayList<>(visitors);

        for (String getUserFriend : getUserFriends) {
            for (int j = 0; j < visitorsList.size(); j++) {
                if (Objects.equals(getUserFriend, visitorsList.get(j))) {
                    visitorsList.remove(j);
                }
            }
        }
        return visitorsList;
    }//public static List<String> friendsInVisitorsRemover

    public static Map<String,Integer> getRecommendationFriendsMap(List<String> visitorsList, List<String> getUserFriends
            ,List<List<String>> excludingUserList){
        Map<String,Integer> recommendationFriendsMap = new HashMap<>();


        for(List<String> list : excludingUserList) {
            if(getUserFriends.contains(list.get(0))
                    && !getUserFriends.contains(list.get(1))) {
                recommendationFriendsMap.put(list.get(1),0);
            } else if(getUserFriends.contains(list.get(1))
                    && !getUserFriends.contains(list.get(0))){
                recommendationFriendsMap.put(list.get(0),0);
            }
        }

        for (String s : visitorsList) {
            recommendationFriendsMap.put(s, 0);
        }
        return recommendationFriendsMap;
    }//public static Map<String,Integer> getRecommendationFriendsMap

    public static Map<String,Integer> recommendationFriendsScoreManagement (Map<String,Integer> recommendationFriendsMap,List<String> visitorsList
            , List<String> getUserFriends ,List<List<String>> excludingUserList) {
        int score;

        for(List<String> list : excludingUserList){
            if(getUserFriends.contains(list.get(0))
                    && !getUserFriends.contains(list.get(1))){
                score = recommendationFriendsMap.get(list.get(1));
                score += 10;
                recommendationFriendsMap.put(list.get(1), score);
            } else if(getUserFriends.contains(list.get(1))
                    && !getUserFriends.contains(list.get(0))){
                score = recommendationFriendsMap.get(list.get(0));
                score += 10;
                recommendationFriendsMap.put(list.get(0), score);
            }

        }
        for (String s : visitorsList) {
            score = recommendationFriendsMap.get(s);
            score += 1;
            recommendationFriendsMap.put(s, score);
        }
        return recommendationFriendsMap;
    }//public static void scoreManagement

    public static List<String> topFiveRankCalculator(Map<String,Integer> recommendationFriendsMap){
        List<String> topFiveRanker = new ArrayList<>();
        Entry<String, Integer> maxEntry;

        while(true) {
            maxEntry = maxEntryCalculator(recommendationFriendsMap);
            recommendationFriendsMap.remove(maxEntry.getKey());

            topFiveRanker.add(maxEntry.getKey());

            if(topFiveRanker.size() == 5
                    || recommendationFriendsMap.isEmpty()) {
                break;
            }
        }
        return topFiveRanker;
    }//public static List<String> topFiveRankCalculator

    public static Entry<String, Integer> maxEntryCalculator(Map<String,Integer> recommendationFriendsMap){
        Entry<String, Integer> maxEntry = null;
        Set<Entry<String, Integer>> entrySet = recommendationFriendsMap.entrySet();

        for(Entry<String,Integer> entry : entrySet) {
            if(maxEntry == null
                    || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
            if(Objects.equals(entry.getValue(), maxEntry.getValue())
                    && entry.getKey().compareTo(maxEntry.getKey())<0) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }//public static Entry<String, Integer> maxEntryCalculator


}