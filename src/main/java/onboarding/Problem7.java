package onboarding;

import java.util.*;

public class Problem7 {
    public static TreeMap<String, Integer> score = new TreeMap<>();
    public static Set<String> alreadyFriends = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setFriendsNetwork(user, friends);
        scoreBasedOnFriends(user, friends);
        scoreBasedOnVisitors(user, visitors);
        List<String> answer = returnAnswer();
        return answer;
    }

    public static void setFriendsNetwork(String user, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            if(friendA.equals(user)) {
                alreadyFriends.add(friendB);
                continue;
            }
            if(friendB.equals(user)) {
                alreadyFriends.add(friendA);
            }
        }
    }

    public static void scoreBasedOnFriends(String user, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            if (friendA.equals(user) || friendB.equals(user)) {
                continue;
            }
            if (alreadyFriends.contains(friendA) && !alreadyFriends.contains(friendB)) {
                score.put(friendB, score.getOrDefault(friendB, 0) + 10);
                continue;
            }
            if (alreadyFriends.contains(friendB) && !alreadyFriends.contains(friendA)) {
                score.put(friendA, score.getOrDefault(friendA, 0) + 10);
            }
        }
    }

    public static void scoreBasedOnVisitors(String user, List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String friend = visitors.get(i);
            if(alreadyFriends.contains(friend) || friend.equals(user)) {
                continue;
            }
            score.put(friend, score.getOrDefault(friend, 1) + 1);
        }
    }

    public static List<String> returnAnswer() {
        List<TopScorer> topScored = new ArrayList<>();

        while(!score.isEmpty() && topScored.size() < 5) {
            Map.Entry<String, Integer> curr = score.lastEntry();
            topScored.add(new TopScorer(curr.getValue(), curr.getKey()));
            score.remove(curr.getKey());
        }

        return sortTopScored(topScored);
    }

    public static List<String> sortTopScored(List<TopScorer> topScored) {
        List<String> answer = new ArrayList<>();
        Collections.sort(topScored, new Comparator<TopScorer>() {
            @Override
            public int compare(TopScorer o1, TopScorer o2) {
                if(o2.score < o1.score || o2.score > o1.score) {
                    return Integer.compare(o2.score, o1.score);
                }

                return o1.name.compareTo(o2.name);
            }
        });
        for(TopScorer curr : topScored) {
            answer.add(curr.name);
        }
        return answer;
    }

    static class TopScorer {
        int score;
        String name;

        public TopScorer(int score, String name) {
            this.score = score;
            this.name = name;
        }
    }
}
