package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> recommendMap = new HashMap<>();
        List<String> friendList = new ArrayList<>();

        for (List<String> strings : friends) {
            if (strings.contains(user)) {
                int idx = strings.indexOf(user);
                String friend = strings.get(1 - idx);

                friendList.add(friend);
            }
        }

        for (String s : friendList) {
            for (List<String> friend : friends) {
                if (friend.contains(s) && !friend.contains(user)) {
                    int idx = friend.indexOf(s);
                    String recommend = friend.get(1 - idx);

                    if (recommendMap.containsKey(recommend)) {
                        Integer val = recommendMap.get(recommend);
                        recommendMap.put(recommend,val+10);
                    }
                    else{
                        recommendMap.put(recommend, 10);
                    }

                }
            }
        }

        for (String visitor : visitors) {
            if (recommendMap.containsKey(visitor)) {
                Integer val = recommendMap.get(visitor);
                recommendMap.put(visitor,val+1);
            }
            else{
                recommendMap.put(visitor, 1);
            }
        }

        List<Friend> list = new ArrayList<>();

        for (String s : recommendMap.keySet()) {
            list.add(new Friend(s,recommendMap.get(s)));
        }

        list = list.stream().filter(x->!friendList.contains(x.name)).collect(Collectors.toList());

        list.sort(new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                return o2.score-o1.score;
            }
        });

        answer = list.stream().map(x->x.name).collect(Collectors.toList());

        return answer.size()>=5?answer.subList(0,5):answer;
    }

    private static class Friend {
        private String name;
        private Integer score;

        public Friend(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }
}
