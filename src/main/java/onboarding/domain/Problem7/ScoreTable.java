package onboarding.domain.Problem7;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreTable {

    private Map<String, Integer> scoreTable;
    private List<String> userFriends;

    public ScoreTable(String user, Relation relation) {
        userFriends = relation.friendOf(user);
        scoreTable = makeScoreTable(user,relation);
    }

    private Map<String, Integer> makeScoreTable(String user,Relation relation) {
        Map<String,Integer> score = new HashMap<>();
        List<String> others = relation.nameList().stream()
                .filter(name -> !name.equals(user) && !userFriends.contains(name))
                .collect(Collectors.toList());
        for (String other: others) {
            score.put(other, relation.countAcquaintance(user,other)*10);
        }
        return score;
    }
    public int report(String name) {
        if (userFriends.contains(name))
            return 0;
        if (!scoreTable.containsKey(name))
            scoreTable.put(name,0);
        int updateScore = scoreTable.get(name) + 1;
        scoreTable.put(name, updateScore);
        return updateScore;
    }

    public List<String> topFiveFriends() {
        return  new ArrayList<>(scoreTable.keySet()).stream()
                .sorted((o1,o2)->(scoreTable.get(o2).compareTo(scoreTable.get(o1))))
                .filter(friend -> scoreTable.get(friend) > 0)
                .limit(5)
                .collect(Collectors.toList());
    }
}
