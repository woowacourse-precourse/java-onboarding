package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final HashMap<String, List<String>> friends_relation = new HashMap<>();
    private static final HashMap<String, Integer> recommendation_score = new HashMap<>();
    private static final HashSet<String> already_friend = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeRelationGraph(friends);

        Bfs.findRelatedUserByBfs(user);

        findVisitors(visitors);

        return recommendation_score.entrySet()
                .stream()
                .filter(entry -> !already_friend.contains(entry.getKey()))
                .sorted(
                        Comparator
                        .comparing(Map.Entry<String, Integer>::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static void findVisitors(List<String> visitors) {
        visitors.forEach(name->{
                    recommendation_score.merge(name, 1, Integer::sum);
                });
    }

    private static void makeRelationGraph(List<List<String>> friends) {
        friends.forEach(Problem7::addFriendsRelation);
    }

    private static void addFriendsRelation(List<String> relation) {
        addRelationEdge(relation.get(0), relation.get(1));
        addRelationEdge(relation.get(1), relation.get(0));
    }

    private static void addRelationEdge(String friend1, String friend2) {
        List<String> friend1_list = friends_relation.getOrDefault(friend1, new ArrayList<>());
        friend1_list.add(friend2);
        friends_relation.put(friend1, friend1_list);
    }

    static class Bfs{
        private static final Queue<String> bfs_queue = new LinkedList<>();
        private static final Queue<Integer> cnt_queue = new LinkedList<>();
        private static final HashSet<String> visited = new HashSet<>();

        private static void findRelatedUserByBfs(String user) {
            bfs_queue.add(user);
            cnt_queue.add(0);
            visited.add(user);

            while (!bfs_queue.isEmpty()) {
                String now = bfs_queue.poll();
                int level = cnt_queue.poll();

                if (isLevelTwo(now, level)) continue;

                findNextLevelFriend(now, level);
            }
        }

        private static boolean isLevelTwo(String now, int level) {
            if (level == 2) {
                recommendation_score.merge(now, 10, Integer::sum);
                return true;
            }
            return false;
        }

        private static void findNextLevelFriend(String now, int level) {
            for (String next : friends_relation.get(now)) {
                isAlreadyFriendWithUser(level, next);
                willVisitOrNot(level, next);
            }
        }

        private static void isAlreadyFriendWithUser(int level, String next) {
            if (level == 0) {
                already_friend.add(next);
            }
        }

        private static void willVisitOrNot(int level, String next) {
            if (!visited.contains(next)) {
                bfs_queue.add(next);
                cnt_queue.add(level + 1);

                if (level > 1) {
                    visited.add(next);
                }
            }
        }
    }
}
