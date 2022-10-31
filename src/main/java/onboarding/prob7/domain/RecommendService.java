package onboarding.prob7.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RecommendService {

    private final String user;
    private final List<List<String>> friends;
    private final List<String> visitors;

    public RecommendService(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
    }

    public List<String> solve() {
        InitProcessor initProcessor = new InitProcessor();
        List<String> candidates = initProcessor.getCandidates(user, friends, visitors);
        List<String> sortedFriends = initProcessor.getSortedFriends(user, friends);
        RecommendScoreCalculator calculator = new RecommendScoreCalculator();
        return getTopFive(candidates, sortedFriends, calculator);
    }

    private List<String> getTopFive(List<String> candidates, List<String> sortedFriends,
        RecommendScoreCalculator calculator) {
        PriorityQueue<User> candidatantPriorityQueue = getSortedUsers(
            candidates, sortedFriends, calculator);

        return pickFive(candidatantPriorityQueue);
    }

    final List<String> pickFive(PriorityQueue<User> candidatantPriorityQueue) {
        List<String> answer = new ArrayList<>();
        while (!candidatantPriorityQueue.isEmpty()) {
            if (isSame(answer.size(), 5)) {
                break;
            }
            User polled = candidatantPriorityQueue.poll();
            if (isZero(polled.getScore())) break;
            answer.add(polled.getName());
        }
        return new ArrayList<>(answer);
    }

    private boolean isZero(int x) {
        return isSame(x, 0);
    }

    private boolean isSame(int x, int y) {
        return x == y;
    }

    private PriorityQueue<User> getSortedUsers(List<String> candidates, List<String> sortedFriends,
        RecommendScoreCalculator calculator) {
        PriorityQueue<User> candidatantPriorityQueue = new PriorityQueue<>();
        for (String candidate : candidates) {
            int score = calculator.getRecommendScore(candidate, friends, sortedFriends, visitors);
            User candidatant = new User(candidate, score);
            candidatantPriorityQueue.add(candidatant);
        }
        return candidatantPriorityQueue;
    }
}
