package custom.problem7;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ScoreResolver {

    private final Network network;
    private final Map<String, Long> visitFrequency;

    public ScoreResolver(Network network, List<String> visitors) {
        this.network = network;
        this.visitFrequency = visitors.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int calculateTargetUserScore(String user, String targetUser) {
        int score = 0;
        score += 10 * countAdjBetweenUserAndTargetAdj(user, targetUser);
        score += countVisit(targetUser);
        return score;
    }

    private int countAdjBetweenUserAndTargetAdj(String user, String targetUser) {
        int cnt = 0;
        List<String> targetAdj = network.getAdj(targetUser);
        for (String adjUser : targetAdj) {
            if (network.getAdj(user).contains(adjUser)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private int countVisit(String targetUser) {
        return visitFrequency.getOrDefault(targetUser, 0L).intValue();
    }

}
