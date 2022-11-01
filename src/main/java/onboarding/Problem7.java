package onboarding;

import java.util.*;

public class Problem7 {

    private static final int USER_IDX = 0;
    private static final int FRIEND_IDX = 1;
    Map<String, ArrayList<String>> friendInfoTable = new HashMap<>();
    Map<String, Integer> scoreInfoTable = new HashMap<>();
    ArrayList<String> RecommendedUsers = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private void fillFriendInfoTable(List<List<String>> friends){
        for(List<String> friendInfo : friends){
            makeAandBFriend(friendInfo.get(USER_IDX), friendInfo.get(FRIEND_IDX));
            makeAandBFriend(friendInfo.get(FRIEND_IDX), friendInfo.get(USER_IDX));
        }
    }

    private void makeAandBFriend(String A,String B){
        ArrayList<String> userFriends = friendInfoTable.getOrDefault(A,new ArrayList<>());
        userFriends.add(B);
        friendInfoTable.put(A,userFriends);
    }
}
