package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static Map<String, Integer> hashmap;
    public static Map<String, List<String>> graph;
    public static List<String> userFriend;
    public static String userName;

    public static void init(String user, List<List<String>> friends) {
        hashmap = new HashMap<>();
        graph = new HashMap<>();
        graph.put(user, new ArrayList<>());
        for (List<String> friend : friends) {
            graph.put(friend.get(0), graph.getOrDefault(friend.get(0), new ArrayList<>()));
            graph.put(friend.get(1), graph.getOrDefault(friend.get(1), new ArrayList<>()));
        }
    }

    public static void makeGraph(List<List<String>> friends) {
        userFriend = new ArrayList<>();
        for (List<String> friend : friends) {
            if(friend.get(0).equals(userName))
                userFriend.add(friend.get(1));
            if (friend.get(1).equals(userName)) {
                userFriend.add(friend.get(0));
            }
            graph.get(friend.get(0)).add(friend.get(1));
            graph.get(friend.get(1)).add(friend.get(0));
        }
    }

    // 방문자는 점수 1점
    public static void visit(List<String> visitors) {
        for (String visitor : visitors) {
            hashmap.put(visitor, hashmap.getOrDefault(visitor, 0) + 1);
        }
    }

    public static class User {
        private String name;
        private Integer score;

        public User(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userName = user;
        List<String> answer = new ArrayList<>();
        init(user, friends);
        makeGraph(friends);
        List<String> friend = graph.get(user);

        // user 의 친구들
        for (String s : friend) {
            List<String> strings = graph.get(s);
            // user 의 친구들의 친구들은 플러스 10점
            for (String string : strings) {
                hashmap.put(string, hashmap.getOrDefault(string, 0) + 10);
            }
        }

        // 방문자는 플러스 1점
        visit(visitors);

        PriorityQueue<User> priorityQueue = new PriorityQueue<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.score == o2.score) {
                    return o1.name.compareTo(o2.name);
                } else {
                    return o2.score - o1.score;
                }
            }
        });

        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            priorityQueue.add(new User(entry.getKey(), entry.getValue()));
        }

        int reps = 5;
        while (!priorityQueue.isEmpty()) {
            if(reps==0)
                break;

            if (priorityQueue.peek().name.equals(user)||priorityQueue.peek().score==0) {
                priorityQueue.poll();
                continue;
            }

            answer.add(priorityQueue.poll().name);
            reps--;
        }
        answer.removeAll(userFriend);
        return answer;
    }
}
