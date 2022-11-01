package onboarding;

import java.util.*;

public class Problem7 {

    public static class User implements Comparable<User>{
        String id;
        int score;

        public User(String id, int score) {
            this.id = id;
            this.score = score;
        }

        public void addScore10(){
            this.score += 10;
        }

        public void addScore1(){
            this.score += 1;
        }

        public String getId() {
            return id;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(User o) {
            return o.score == this.score
                    ? this.id.compareTo(o.id)
                    : o.score - this.score;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> friendMap = new HashMap<>();
        Set<String> userSet = new HashSet<>();

        // 친구 관계 입력
        for (List<String> friend : friends) {
            String front = friend.get(0);
            String back = friend.get(1);
            userSet.add(front);
            userSet.add(back);

            List<String> frontFriendList = friendMap.getOrDefault(front, new ArrayList<>());
            if(!frontFriendList.contains(back))
                frontFriendList.add(back);
            friendMap.put(front, frontFriendList);

            List<String> backFriendList = friendMap.getOrDefault(back, new ArrayList<>());
            if(!backFriendList.contains(front))
                backFriendList.add(front);
            friendMap.put(back, backFriendList);
        }

        Map<String, User> scoreMap = new HashMap<>();
        List<String> userFriends = friendMap.get(user);

        // 함께 아는 친구의 수 점수 Up
        for (String u : userSet) {
            if (userFriends.contains(u) || u.equals(user)) {
                continue;
            }
            User newUser = new User(u, 0);
            List<String> friendsOfFriend = friendMap.get(u);
            for (String f : friendsOfFriend) {
                if (userFriends.contains(f)) {
                    newUser.addScore10();
                }
            }

            scoreMap.put(u, newUser);
        }

        // 방문객 점수 증가
        for (String visitor : visitors) {
            User newUser = scoreMap.getOrDefault(visitor, new User(visitor, 0));
            newUser.addScore1();
            scoreMap.put(visitor, newUser);
        }

        PriorityQueue<User> pq = new PriorityQueue<>();
        for (String userId : scoreMap.keySet()) {
            pq.add(scoreMap.get(userId));
        }


        for (int i = 0; i < 5 && !pq.isEmpty(); i++) {
            User poll = pq.poll();
            if (userFriends.contains(poll.getId())) {
                continue;
            }
            if(poll.getScore() == 0) {
                break;
            }
            answer.add(poll.getId());
        }

        return answer;
    }
}
