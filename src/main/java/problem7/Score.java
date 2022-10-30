package problem7;

import java.util.*;

import static java.util.Collections.*;

public class Score {
    static class FriendScore implements Comparable<FriendScore> {
        String name;
        int score;

        public FriendScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(FriendScore o) {
            return score - o.score != 0 ? -(score - o.score) : name.compareTo(o.name);
        }
    }

    private List<FriendScore> scoreList = new ArrayList<>();
    private Map<String, Integer> scoreMap = new HashMap<>();
    private Set<String> friendSet = new HashSet<>();


    public List<String> getTopFive() {
        List<String> result = new ArrayList<>();

        resultAdd(result, (scoreList.size() > 5 ? scoreList.subList(0,5) : scoreList));

        return result;
    }

    private void resultAdd(List<String> result, List<FriendScore> list) {
        for (FriendScore friendScore : list)
            result.add(friendScore.name);
    }

    public void scoring(String user, Map<String, List<String>> adjacentList, List<String> visitors) {
        addRelativeScore(user, adjacentList);
        addVisitScore(visitors);

        scoreMap.forEach((String name, Integer score) -> {
            scoreList.add(new FriendScore(name, score));
        });

        sort(scoreList);
    }

    private void addVisitScore(List<String> visitors) {
        for (String visitor : visitors) {
            if(!friendSet.contains(visitor))
                addScore(visitor, 1);
        }
    }

    private void addRelativeScore(String user, Map<String, List<String>> adjacentList) {
        for (String userFriend : adjacentList.get(user)) {
            friendSet.add(userFriend);
            for (String userFriendFriend : adjacentList.get(userFriend)) {
                if(userFriendFriend == user) continue;
                addScore(userFriendFriend, 10);
            }
        }
    }

    private void addScore(String userFriendFriend, int point) {
        if (scoreMap.containsKey(userFriendFriend)) scoreMap.put(userFriendFriend, scoreMap.get(userFriendFriend) + point);
        else scoreMap.put(userFriendFriend, point);
    }
}
