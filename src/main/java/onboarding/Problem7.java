package onboarding;

import java.util.*;

public class Problem7 {

    public static class ScoreFriends {
        private String name;
        private int score;
        public ScoreFriends(){}
        public ScoreFriends(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String getName() {
            return name;
        }
        public int getScore() {
            return score;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        // find already friend with user
        List<String> alreadyFriends = getFriendWithUser(user, friends);

        // set recommend score
        Map<String, Integer> ScoreFriendsMap = setTenScore(user, alreadyFriends, friends);
        ScoreFriendsMap = setOneScore(alreadyFriends, visitors, ScoreFriendsMap);

        // sorting recommend list
        List<ScoreFriends> ScoreFriends = mapToScoreFriends(ScoreFriendsMap);
        ScoreFriends = sortByScoreReverseThenName(ScoreFriends);

        // return 5(at most) recommending friend list
        answer = setRecommendList(ScoreFriends);
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
    public static Map<String, Integer> setOneScore(List<String> alreadyFriends,
                                                   List<String> visitors,
                                                   Map<String, Integer> ScoreFriendsMap){
        for (int i=0; i<visitors.size(); i++){
            String tmpUser = visitors.get(i);

            if (!alreadyFriends.contains(tmpUser)){

                if (ScoreFriendsMap.containsKey(tmpUser)){
                    int tmpScore = ScoreFriendsMap.get(tmpUser);
                    ScoreFriendsMap.replace(tmpUser, tmpScore+1);
                } else {
                    ScoreFriendsMap.put(tmpUser, 1);
                }
            }
        }
        return ScoreFriendsMap;
    }
    public static List<ScoreFriends> mapToScoreFriends(Map<String, Integer> map){
        List<ScoreFriends> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(new ScoreFriends(entry.getKey(), entry.getValue()));
        }
        return list;
    }
    public static List<ScoreFriends> sortByScoreReverseThenName(List<ScoreFriends> list){
        list.sort(Comparator.comparing(ScoreFriends::getScore).reversed()
                            .thenComparing(ScoreFriends::getName));
        return list;
    }
    public static List<String> setRecommendList(List<ScoreFriends> list){
        List<String> answer = new ArrayList<>();
        for (int i=0; i<5; i++){
            if (i >= list.size()) break;
            answer.add(list.get(i).getName());
        }
        return answer;
    }
}