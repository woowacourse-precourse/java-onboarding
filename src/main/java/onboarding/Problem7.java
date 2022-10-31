package onboarding;

import java.util.*;

public class Problem7 {

    public static void updateMyFriend(ArrayList<String> myFriends, String newFriend){
        myFriends.add(newFriend);
    }

    public static ArrayList<String> setMyFriend(String newFriend){
        ArrayList<String> myNewFriends = new ArrayList<>();
        myNewFriends.add(newFriend);
        return myNewFriends;
    }

    public static HashMap<String, ArrayList<String>> createFriendConnection (List<List<String>> friends){
        HashMap<String, ArrayList<String>> friendConnection = new HashMap<>();

        for (List<String> friend : friends){
            ArrayList<String> arrList = new ArrayList<>(friend);
            String friend1 = arrList.get(0);
            String friend2 = arrList.get(1);

            if (friendConnection.containsKey(friend1)){
                ArrayList<String> myFriends = friendConnection.get(friend1);
                updateMyFriend(myFriends, friend2);
                friendConnection.replace(friend1, myFriends);
            } else{
                ArrayList<String> myFriend = setMyFriend(friend2);
                friendConnection.put(friend1, myFriend);
            }

            if (friendConnection.containsKey(friend2)){
                ArrayList<String> myFriends = friendConnection.get(friend2);
                updateMyFriend(myFriends, friend1);
                friendConnection.replace(friend2, myFriends);
            } else{
                ArrayList<String> myFriend = setMyFriend(friend1);
                friendConnection.put(friend2, myFriend);
            }
        }

        return friendConnection;
    }

    public static void setMutualFriendScore(ArrayList<String> friends, HashMap<String, Integer> scoreTable,
                                            HashSet<String> notRecommended){
        for (String friend: friends){
            if (notRecommended.contains(friend))
                continue;

            if (scoreTable.containsKey(friend)){
                int score = scoreTable.get(friend);
                score += 10;
                scoreTable.replace(friend, score);
            } else {
                int score = 10;
                scoreTable.put(friend, score);
            }

        }
    }

    public static void setVisitorScore(Map<String, Integer> scoreTable, List<String> visitors,
                                       HashSet<String> notRecommended){
        for (String visitor: visitors){
            if (notRecommended.contains(visitor))
                continue;

            if (scoreTable.containsKey(visitor)){
                int score = scoreTable.get(visitor);
                score += 1;
                scoreTable.replace(visitor, score);
            } else {
                int score = 1;
                scoreTable.put(visitor,score);
            }
        }
    }

    public static Map<String, Integer> createScoreTable(String user, Map<String, ArrayList<String>> friendConnection,
                                                        List<String> visitors){
        ArrayList<String> userFriends = friendConnection.get(user);
        HashSet<String> notRecommended = new HashSet<>(userFriends);
        HashMap<String, Integer> scoreTable = new HashMap<>();
        notRecommended.add(user);


        for (String userFriend: userFriends){
            ArrayList<String> friendsOfFriend = friendConnection.get(userFriend);
            setMutualFriendScore(friendsOfFriend, scoreTable, notRecommended);
        }

        setVisitorScore(scoreTable, visitors, notRecommended);

        return scoreTable;
    }

    public static List<Map.Entry<String,Integer>> createSortedScore(Map<String, Integer> scoreTable){
        List<Map.Entry<String, Integer>> sortedByScore = new LinkedList<>(scoreTable.entrySet());
        sortedByScore.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        return sortedByScore;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, ArrayList<String>> friendConnection = createFriendConnection(friends);
        Map<String, Integer> scoreTable = createScoreTable(user, friendConnection, visitors);
        List<Map.Entry<String,Integer>> sortedByScore = createSortedScore(scoreTable);

        List<String> answer = new ArrayList<>();
        for (int i = 0; i<5 && i < sortedByScore.size(); i++){
            answer.add(sortedByScore.get(i).getKey());
        }
        return answer;
    }
}
