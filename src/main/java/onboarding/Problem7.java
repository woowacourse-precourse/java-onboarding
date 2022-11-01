package onboarding;

import java.util.*;

/**
 * user : String
 * friends : [["ID A", "ID B"],...]
 * visitors : 사용자 타임 라인 방문기록 list/배열
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();

        HashMap<String, HashSet<String>> friend_list = new HashMap<>();
        addFriendList(user,friends,friend_list);
        for (String friend: friend_list.keySet()) {
            GetShareFriendsScore(user, friend, friend_list, scoreMap);
        }
        for (String visitor: visitors) {
            HashSet<String> userFriendList = friend_list.get(user);
            getVisitorScore(scoreMap, userFriendList, visitor);
        }
        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(scoreMap.entrySet());
        scoreList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() > o1.getValue())
                    return 1;
                if (o2.getValue() < o1.getValue())
                    return -1;
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        int MAX_LOOP_SIZE = 5;
        int loopSize = Math.min(MAX_LOOP_SIZE, scoreList.size());
        for (int i=0; i<loopSize; i++) {
            Map.Entry<String, Integer> entry = scoreList.get(i);
            addNameToAnswer(answer, entry);
        }
        return answer;
    }
    public static void addNameToAnswer(List<String> answer,
                                       Map.Entry<String, Integer> entry) {
        if (entry.getValue() != 0)
            answer.add(entry.getKey());
    }

    public static void addFriendList(
            String user,
            List<List<String>> friends,
            HashMap<String, HashSet<String>> friend_list
    ){
        friend_list.put(user,new HashSet());
        for (List<String> friend : friends){
            for (int i=0; i<2;i++){
                if (friend_list.get(friend.get(i))==null){
                    friend_list.put(friend.get(i),new HashSet());
                }
                if (i==0) {
                    friend_list.get(friend.get(i)).add(friend.get(1));
                }else {
                    friend_list.get(friend.get(i)).add(friend.get(0));
                }
            }
        }
    }

    public static void GetShareFriendsScore(
            String user,
            String friend,
            HashMap<String, HashSet<String>> friendList,
            HashMap<String, Integer> scoreMap
    ){
        HashSet<String> userFriendList = friendList.get(user);
        HashSet<String> friendFriendList = friendList.get(friend);

        if (user.equals(friend) || userFriendList.contains(friend)) return;
        scoreMap.put(friend, 0);
        for (String userFriendName: userFriendList) {
            checkAddScore(friend, userFriendName,friendFriendList,scoreMap);
        }
    }
    public static void checkAddScore(
            String user,
            String friend,
            HashSet<String> friendFriendList,
            HashMap<String, Integer> scoreMap
    ) {
        final int SCORE_BY_FRIEND = 10;
        if (friendFriendList.contains(friend)) {
            int newScore = scoreMap.get(user) + SCORE_BY_FRIEND;
            scoreMap.replace(user, newScore);
        }
    }
    public static void getVisitorScore(HashMap<String, Integer> scoreMap,
                                       HashSet<String> userFriendList,
                                       String visitor) {
        if (userFriendList.contains(visitor))
            return;
        if (!scoreMap.containsKey(visitor))
            scoreMap.put(visitor, 0);
        int newScore = scoreMap.get(visitor) + 1;
        scoreMap.replace(visitor, newScore);
    }
}
