package onboarding;

import problem7.Graph;
import problem7.Score;
import problem7.Validation;

import java.util.List;

public class Problem7 {
    private static Graph graph;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        validate(friends, visitors);

        return getAnswer(user, friends, visitors);
    }

    private static void validate(List<List<String>> friends, List<String> visitors) {
        try {
            for (List<String> pair : friends) {
                Validation.validate(pair.get(0));
                Validation.validate(pair.get(1));
            }
            for (String visitor : visitors) {
                Validation.validate(visitor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static List<String> getAnswer(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        graph = new Graph(friends);

        Score score = new Score();
        score.scoring(user, graph.getAdjacentList(), visitors);
        answer = score.getTopFive();
        return answer;
    }
}
