package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        int lenVisitors = visitors.size();
        int lenMyFriends = myFriends(user, friends).size();
        HashMap<String, Integer> scoreBoard = new HashMap<String, Integer>();
        resetHashMap(scoreBoard, friends, visitors);
        scoreFriends(myFriends(user, friends), friends, user, scoreBoard);
        for (int i=0;i<lenVisitors;++i)
            scoreBoard.put(visitors.get(i), scoreBoard.get(visitors.get(i)) + 1);
        for (int i=0;i<lenMyFriends;++i)
            scoreBoard.put(myFriends(user, friends).get(i), 0);
        List<Map.Entry<String, Integer>> list = new LinkedList<>(scoreBoard.entrySet());
        Collections.sort(list, new Comparator <Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        int lenList = list.size();
        for (int i=0;i<lenList&&i<5;++i)
            if (list.get(i).getValue() > 0)
                answer.add(list.get(i).getKey());
        return answer;
    }

    public static HashMap<String, Integer> resetHashMap(HashMap<String, Integer> scoreBoard,
                                                        List<List<String>> friends,
                                                        List<String> visitors) {
        int lenVisitors = visitors.size();
        int lenFriends = friends.size();
        for (int i=0;i<lenVisitors;++i)
            scoreBoard.put(visitors.get(i), 0);
        for (int i=0;i<lenFriends;++i)
            scoreBoard.put(friends.get(i).get(1), 0);
        for (int i=0;i<lenFriends;++i)
            scoreBoard.put(friends.get(i).get(0), 0);
        return scoreBoard;
    }

    public static List<String> myFriends(String user, List<List<String>> friends) {
        int sizeFriends = friends.size();
        List<String> temp = new ArrayList<>();
        for (int i=0;i<sizeFriends;++i) {
            if (user == friends.get(i).get(0))
                temp.add(friends.get(i).get(1));
            else if (user == friends.get(i).get(1))
                temp.add(friends.get(i).get(0));
        }
        return (temp);
    }

    public static HashMap<String, Integer> scoreFriends(List<String> myFriend,
                                            List<List<String>> friends,
                                            String user,
                                            HashMap<String, Integer> scoreBoard) {
        int sizeMyFriends = myFriend.size();
        int sizeFriends = friends.size();
        for (int i=0;i<sizeMyFriends;++i) {
            for (int j=0;j<sizeFriends;++j) {
                if (myFriendIsNotUser(myFriend.get(i), friends.get(j).get(0), friends.get(j).get(1), user) == true)
                    scoreBoard.put(friends.get(j).get(1), scoreBoard.get(friends.get(j).get(1)) + 10);
                else if (myFriendIsNotUser(myFriend.get(i), friends.get(j).get(1), friends.get(j).get(0), user) == true)
                    scoreBoard.put(friends.get(j).get(0), scoreBoard.get(friends.get(j).get(0)) + 10);
            }
        }
        return scoreBoard;
    }
    private static boolean myFriendIsNotUser(String myFriend, String leftFriends, String rightFriend, String user) {
        if ((myFriend == leftFriends) && (rightFriend != user))
            return true;
        else
            return false;
    }
}
