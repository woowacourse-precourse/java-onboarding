package onboarding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static Map<String, List<String>> friendsMap;
    public static Map<String, Integer> scoreMap;

    public static List<String> makeFriends(String friend1,String friend2)
    {
        List<String> relationShip;
        if (friendsMap.containsKey(friend1))
             relationShip = friendsMap.get(friend1);
        else
            relationShip = new ArrayList<>();
        relationShip.add(friend2);
        return relationShip;
    }

    public static boolean IsFriends(String user, String MatchedUser){
        if (user.equals(MatchedUser)) return true;
        List<String> userFriends = friendsMap.get(user);
        for (int i = 0 ; i<userFriends.size(); i++){
            if (userFriends.get(i).equals(MatchedUser)) return true;
        }
        return false;
    }

    public static void AddScoreToMap (List<String> friendsCandidate, String user, int score){
        for (String candidate : friendsCandidate)
        {
            if (!IsFriends(user,candidate)) {
                if (scoreMap.containsKey(candidate))
                    scoreMap.put(candidate, scoreMap.get(candidate) + score);
                else
                    scoreMap.put(candidate, score);
            }
        }
    }

    public static void MakeScore(List<String> visitors, String user)
    {
        AddScoreToMap(visitors,user, 1);

        List<String> userFriends = friendsMap.get(user);
        for (int i = 0 ; i< userFriends.size() ; i++){
            AddScoreToMap(friendsMap.get(userFriends.get(i)),user, 10);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        friendsMap = new HashMap<>();
        scoreMap = new HashMap<>();

        for (int i = 0 ; i< friends.size(); i++)
        {
            friendsMap.put(friends.get(i).get(0),makeFriends(friends.get(i).get(0), friends.get(i).get(1)));
            friendsMap.put(friends.get(i).get(1),makeFriends(friends.get(i).get(1), friends.get(i).get(0)));
        }

        MakeScore(visitors,user);

        List<String> scoreList = new ArrayList<>(scoreMap.keySet());
        scoreList.sort((o1, o2) -> {
            if (scoreMap.get(o1).equals(scoreMap.get(o2))) return o1.compareTo(o2);
            return scoreMap.get(o2) - scoreMap.get(o1);
        });

        List<String> answer = new ArrayList<>();
        for (int i = 0 ; i< scoreList.size() ; i++){
            answer.add(scoreList.get(i));
            if (answer.size() == 5 )
                break;
        }
        return answer;
    }
}
