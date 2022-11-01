package onboarding.problem7;

import java.util.HashMap;
import java.util.List;

public class Recommendation {

    public List<String> getBestRecommendList(String user, List<List<String>> friends, List<String> visitors) {
        Score score = new Score();
        Validator validator = new Validator();

        validator.validate(user,friends,visitors);
        HashMap<String, Person> map = score.makeScoreMap(user, friends, visitors);
        score.giveFriendsScore(user, map);
        score.giveVisitorsScore(map, visitors);

        return score.getRecommendList(user, map);
    }

}
