package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> fr_info = getFriendsList(friends);
        Map<String, Integer> points = getFriendofFriend(user, fr_info);

        List<String> userFriend = fr_info.get(user);

        for (String visitor : visitors) {
            if (!userFriend.contains(visitor)) {
                if (points.get(visitor) != null) {
                    Integer point = points.get(visitor);
                    point += 1;
                    points.put(visitor, point);
                } else {
                    points.put(visitor, 1);
                }
            }
        }

        //정렬
        List<String> keySet = new ArrayList<>(points.keySet());
        Collections.sort(keySet);
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return points.get(o2).compareTo(points.get(o1));
            }
        });

        for (var i = 0; i < keySet.size() && i < 5; i++) {
            answer.add(keySet.get(i));
        }

        return answer;
    }

    private static Map<String, Integer> getFriendofFriend(String user, Map<String, List<String>> fr_info) {
        Map<String, Integer> points = new HashMap<>();

        Queue<Person> queue = new LinkedList<>();
        List<String> done = new ArrayList<String>();

        queue.offer(new Person(user, 0));
        done.add(user);

        while (!queue.isEmpty()) {
            Person person = queue.poll();

            for (String f : fr_info.get(person.getName())) {
                if (!done.contains(f)) {
                    Person newPerson = new Person(f, person.space + 1);
                    queue.offer(newPerson);
                    done.add(f);
                    if (newPerson.getSpace() == 2) {
                        points.put(newPerson.getName(), 10);
                    }
                }
            }
        }
        
        return points;
    }

    private static class Person {
        private String name;
        private int space;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSpace() {
            return space;
        }

        public void setSpace(int space) {
            this.space = space;
        }

        public Person(String name, int space) {
            this.name = name;
            this.space = space;
        }
    }

    private static Map<String, List<String>> getFriendsList(List<List<String>> friends) {
        Map<String, List<String>> fr_info = new HashMap<String, List<String>>();

        for (List<String> friend : friends) {
            List<String> AFriends = new ArrayList<String>();
            if (fr_info.containsKey(friend.get(0))) {
                AFriends = fr_info.get(friend.get(0));
                AFriends.add(friend.get(1));
            } else {
                AFriends = new ArrayList<>();
                AFriends.add(friend.get(1));
            }
            fr_info.put(friend.get(0), AFriends);

            List<String> BFriends = new ArrayList<String>();
            if (fr_info.containsKey(friend.get(1))) {
                BFriends = fr_info.get(friend.get(1));
                BFriends.add(friend.get(0));
            } else {
                BFriends = new ArrayList<>();
                BFriends.add(friend.get(0));
            }
            fr_info.put(friend.get(1), BFriends);
        }

        return fr_info;
    }
}
