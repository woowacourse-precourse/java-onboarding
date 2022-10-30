package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> scoreList = new HashMap<>();
        HashSet<String> friendList = makeFriendList(friends, user);

        for(int i = 0; i < friends.size(); i++){
            List<String> pair = friends.get(i);

            if(pair.get(0).equals(user) || pair.get(1).equals(user)){
                continue;
            }

            if(friendList.contains(pair.get(0))){
                String friendOfFriend = pair.get(1);
                scoreList = accumulateRecommendedScore(scoreList, friendOfFriend, 10);
            }else if(friendList.contains(pair.get(1))){
                String friendOfFriend = pair.get(0);
                scoreList = accumulateRecommendedScore(scoreList, friendOfFriend, 10);
            }
        }

        for(int i = 0; i < visitors.size(); i++){
            String visitor = visitors.get(i);
            if(friendList.contains(visitor)){
                continue;
            }
            scoreList = accumulateRecommendedScore(scoreList, visitor, 1);
        }

        answer = makeRecommendedFriendList(scoreList);
        return answer;
    }

    private static  HashSet<String> makeFriendList(List<List<String>> friends, String user){
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).get(0).equals(user)){
                set.add(friends.get(i).get(1));
            }else if(friends.get(i).get(1).equals(user)){
                set.add(friends.get(i).get(0));
            }
        }
        return set;
    }

    private static HashMap<String, Integer> accumulateRecommendedScore(HashMap<String, Integer> scoreList, String recommendedFriend, int score){
        if(scoreList.containsKey(recommendedFriend)){
            int sum = scoreList.get(recommendedFriend) + score;
            scoreList.put(recommendedFriend, sum);
        }else{
            scoreList.put(recommendedFriend, score);
        }
        return scoreList;
    }

    private static List<String> makeRecommendedFriendList(HashMap<String, Integer> scoreList){
        List<String> recommendedFriendList = new ArrayList<>();
        List<Map.Entry<String, Integer>> descendingScoreList = new ArrayList<>(scoreList.entrySet());
        Collections.sort(descendingScoreList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                int res = b.getValue().compareTo(a.getValue());
                if(res == 0){
                    res = a.getKey().compareTo(b.getKey());
                }
                return res;
            }
        });
        for(int i = 0; i < descendingScoreList.size(); i++){
            if(i == 5){
                break;
            }
            if(descendingScoreList.get(i).getValue() == 0){
                break;
            }else{
                recommendedFriendList.add(descendingScoreList.get(i).getKey());
            }
        }
        return recommendedFriendList;
    }

}
