package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relationshipMap = new HashMap<>();
        Map<String, Integer> scoreBoard = new HashMap<>();

        for (List<String> relationship : friends) {
            String a = relationship.get(0);
            String b = relationship.get(1);

            if (relationshipMap.get(a) == null) {
                List<String> aFriends = new ArrayList<>();
                aFriends.add(b);
                relationshipMap.put(a, aFriends);
            } else {
                relationshipMap.get(a).add(b);
            }

            if (scoreBoard.get(a) == null) {
                scoreBoard.put(a, 0);
            }

            if (relationshipMap.get(b) == null) {
                List<String> bFriends = new ArrayList<>();
                bFriends.add(a);
                relationshipMap.put(b, bFriends);
            } else {
                relationshipMap.get(b).add(a);
            }

            if (scoreBoard.get(b) == null) {
                scoreBoard.put(b, 0);
            }

        }

        for (String a : visitors) {

            if (scoreBoard.get(a) == null) {
                scoreBoard.put(a, 0);
            }

            scoreBoard.put(a, scoreBoard.get(a) + 1);

            if (relationshipMap.get(a) == null) {
                relationshipMap.put(a, new ArrayList<>());
            }
        }

        List<String> pivotFriends = relationshipMap.get(user);
        relationshipMap.remove(user);
        scoreBoard.remove(user);

        if (pivotFriends != null) {
            Set<Map.Entry<String, List<String>>> entries = relationshipMap.entrySet();

            for (Map.Entry<String, List<String>> entry : entries) {
                String key = entry.getKey();
                List<String> value = entry.getValue();

                value.retainAll(pivotFriends);
                scoreBoard.put(key, scoreBoard.get(key) + value.size() * 10);
            }
        }

        List<Result> before = new ArrayList<>();

        for (Map.Entry<String, Integer> score : scoreBoard.entrySet()) {
            String key = score.getKey();
            Integer value = score.getValue();

            if (pivotFriends != null) {
                if (!pivotFriends.contains(key) && scoreBoard.get(key) != 0) {
                    before.add(new Result(key, value));
                }
            } else {
                if (scoreBoard.get(key) != 0) {
                    before.add(new Result(key, value));
                }
            }

        }

        for (Result result : before) {
            System.out.println(result.name + " " + result.score);
        }

        before.sort(new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if (o1.score > o2.score) {
                    return -1;
                } else if (o1.score < o2.score) {
                    return 1;
                } else if (o1.score == o2.score) {
                    return (o1.name.compareTo(o2.name));
                }
                return 0;
            }
        });

        if (before.size() > 5) {
            return before.subList(0, 4).stream().map(result -> result.name).collect(Collectors.toList());
        } else {
            return before.stream().map(result -> result.name).collect(Collectors.toList());
        }
    }

    static class Result {
        String name;
        Integer score;

        public Result(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }
}
