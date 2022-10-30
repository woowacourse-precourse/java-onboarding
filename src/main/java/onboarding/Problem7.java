package onboarding;

import java.util.*;
import onboarding.domain.Problem7.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Relation relation = new Relation(friends);
        ScoreTable scoreTable = new ScoreTable(user, relation);

        for (String visitor : visitors) {
            scoreTable.report(visitor);
        }
        return scoreTable.topFiveFriends();
    }

}
