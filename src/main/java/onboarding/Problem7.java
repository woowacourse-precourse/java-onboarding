package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriendList = new ArrayList<>();
        Map<String, Integer> recommendScore = new HashMap<>();
        for (List<String> relation : friends) {
            if(relation.contains(user)){
                addUserFriend(user, userFriendList, relation);
            }
        }

        for (List<String> relation : friends) {
            for (String friend : userFriendList) {
                if(relation.contains(user)){
                    break;
                }
                checkRelationContainUserFriend(userFriendList, recommendScore, relation, friend);
            }
        }
        checkVisitors(visitors, userFriendList, recommendScore);

        List<String> sortedRecommendList = new ArrayList<>(recommendScore.keySet());
        sortByScore(recommendScore, sortedRecommendList);

        extractAnswer(answer, sortedRecommendList);

        return answer;
    }

    private static void extractAnswer(List<String> answer, List<String> sortedRecommendList) {
        Iterator<String> iterator = sortedRecommendList.iterator();
        int k = 0;
        while(iterator.hasNext()){
            if(k == 5) break;
            answer.add(iterator.next());
            k++;
        }
    }

    private static void sortByScore(Map<String, Integer> recommendScore, List<String> sortedRecommendList) {
        Collections.sort(sortedRecommendList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(recommendScore.get(o1) > recommendScore.get(o2)){
                    return -1;
                }
                if(recommendScore.get(o1) < recommendScore.get(o2)) {
                    return 1;
                }
                if(recommendScore.get(o1) == recommendScore.get(o2)){
                    if(o1.charAt(0) > o2.charAt(0)){
                        return 1;
                    }
                    if(o1.charAt(0) < o2.charAt(0)){
                        return -1;
                    }

                }
                return 0;
            }
        });
    }

    private static void checkVisitors(List<String> visitors, List<String> userFriendList, Map<String, Integer> recommendScore) {
        for (String visitor : visitors) {
            if(!userFriendList.contains(visitor)){
                addScore(recommendScore, visitor, 1);
            }
        }
    }

    private static void checkRelationContainUserFriend(List<String> userFriendList, Map<String, Integer> recommendScore, List<String> relation, String friend) {
        if(relation.contains(friend)){
            for (String knownFriend : relation) {
                if(!userFriendList.contains(knownFriend)){
                    addScore(recommendScore, knownFriend, 10);
                    break;
                }
            }
        }
    }

    private static void addScore(Map<String, Integer> recommendScore, String knownFriend, int x) {
        if(recommendScore.containsKey(knownFriend)){
            recommendScore.replace(knownFriend, recommendScore.get(knownFriend) + x);
        }
        if(!recommendScore.containsKey(knownFriend)){
            recommendScore.put(knownFriend, x);
        }
    }

    private static void addUserFriend(String user, List<String> userFriendList, List<String> relation) {
        for (String friend : relation) {
            if(friend != user){
                userFriendList.add(friend);
                break;
            }
        }
    }

}