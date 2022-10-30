package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> alreadyFriends = getFriendWithUser(user, friends);
        Map<String, Integer> ScoreFriends = setTenScore(user, alreadyFriends, friends);

        for (int i=0; i<visitors.size(); i++){
            String tmpUser = visitors.get(i);

            if (!alreadyFriends.contains(tmpUser)){

                if (ScoreFriends.containsKey(tmpUser)){
                    int tmpScore = ScoreFriends.get(tmpUser);
                    ScoreFriends.replace(tmpUser, tmpScore+1);
                } else {
                    ScoreFriends.put(tmpUser, 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entryList = sortList(ScoreFriends);
        answer = setRecommendList(entryList);
        /**
         * 1. user랑 친구(1차)인 애들을 먼저 찾기
         * 2. 1차랑 친구인 애들 찾아서 10점씩 주기
         * 3. visitor한테 1점씩 주기
         * 4. 점수대로 정렬하기
         * */
        return answer;
    }

    public static List<String> getFriendWithUser(String user, List<List<String>> friends){
        List<String> alreadyFriends = new ArrayList<>();
        for (int i=0; i<friends.size(); i++){
            if (friends.get(i).contains(user)) {
                int userIndex = friends.get(i).indexOf(user);
                if (userIndex==0) alreadyFriends.add(friends.get(i).get(1));
                else alreadyFriends.add(friends.get(i).get(0));
            }
        }
        return alreadyFriends;
    }
    public static Map<String, Integer> setTenScore(String user, List<String> alreadyFriends, List<List<String>> friends){
        Map<String, Integer> TenScoreFriends = new HashMap<>();
        String tmpUser = null;

        for (int i=0; i<alreadyFriends.size(); i++){
            String checkUser = alreadyFriends.get(i);
            for (int j=0; j<friends.size(); j++){
                if (friends.get(j).contains(checkUser)) {
                    int userIndex = friends.get(j).indexOf(checkUser);

                    if (userIndex==0) tmpUser = friends.get(j).get(1);
                    else tmpUser = friends.get(j).get(0);

                    if (tmpUser!=user) {
                        if (TenScoreFriends.containsKey(tmpUser)){
                            int tmpScore = TenScoreFriends.get(tmpUser);
                            TenScoreFriends.replace(tmpUser, tmpScore+10);
                        } else {
                            TenScoreFriends.put(tmpUser, 10);
                        }
                    }
                }
            }
        }
        return TenScoreFriends;
    }
    public static List<Map.Entry<String, Integer>> sortList(Map<String, Integer> ScoreFriends){
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(ScoreFriends.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        return entryList;
    }
    public static List<String> setRecommendList(List<Map.Entry<String, Integer>> entryList){
        List<String> answer = new ArrayList<>();
        for (int i=0; i<5; i++){
            if (i>entryList.size()) break;
            answer.add(entryList.get(i).getKey());
        }
        return answer;
    }
}
/**제한 사항
 * 1. 추천 점수가 0점이면 5명이 채 되지 않더라도 리턴하지 않을 것
 * */
