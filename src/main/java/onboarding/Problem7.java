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

    private void give10ScoreForNumberOfFriendsKnowWithUser(String user){
        Set<String> personsInFriendInfoTable =  friendInfoTable.keySet();

        for(String person : personsInFriendInfoTable){
            if(IsUserOrUserFriend(user,person)) continue;

            scoreInfoTable.put(person,(calculateNumberOfFriendsKnowWithUser(user,person)*10));
        }
    }

    private boolean IsUserOrUserFriend(String userName, String personName){
        return friendInfoTable.get(userName).contains(personName) || personName.equals(userName);
    }

    private int calculateNumberOfFriendsKnowWithUser(String user, String person){
        int numberOfFriendsKnowWithUser = 0;

        for(String userFriend : friendInfoTable.get(user)){
            for(String personFriend : friendInfoTable.get(person)){
                if(userFriend.equals(personFriend)){
                    numberOfFriendsKnowWithUser++;
                    break;
                }
            }
        }
        return numberOfFriendsKnowWithUser;
    }

    private void give1ScoreForNumberOfVisitToUserTimeline(String user,List<String> visitors){
        for(String person : visitors){
            if(IsUserOrUserFriend(user,person)) continue;

            scoreInfoTable.put(person, scoreInfoTable.getOrDefault(person,0)+1);
        }
    }


}
