package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem7 {
    public static List<String> checkUserFriend(String user, List<List<String>> friends){
        List<String> userFriend = new ArrayList<>();
        List<List<String>> checkF = friends.stream()
                .filter(strings -> strings.contains(user))
                .collect(Collectors.toList());
        for (int i = 0; i < checkF.size(); i++) {
            for (int j = 0; j < checkF.get(i).size(); j++) {
                String name = checkF.get(i).get(j);
                if(!userFriend.contains(name) && !name.contains(user))
                    userFriend.add(name);
            }
        }
        return userFriend;
    }
    public static Map<String,Integer> recommendScore(String user, List<List<String>> friends,List<String> userFriend) {
        List<String> friendScoreCheck = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                String name = friends.get(i).get(j);
                if (!user.contains(name) && !userFriend.contains(name))
                    friendScoreCheck.add(name);
            }
        }
        Set<String> set = new HashSet<String>(friendScoreCheck);
        Map<String,Integer> score = new HashMap<>();
        for (String str:set) {
           score.put(str,10 * Collections.frequency(friendScoreCheck,str));
        }
        return score;
    }
    public static Map<String, Integer> viewScore(List<String> userFriend, List<String> visitors){
        List<String> tmpVisitors = new ArrayList<String>(visitors);

        for (String uf: userFriend) {
            tmpVisitors.remove(uf);
        }
        Set<String> set = new HashSet<String>(tmpVisitors);
        Map<String,Integer> score = new HashMap<>();
        for (String str:set) {
            score.put(str, Collections.frequency(tmpVisitors,str));
        }
        return score;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
