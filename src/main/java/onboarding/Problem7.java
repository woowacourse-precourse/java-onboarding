package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String, User> map = new HashMap<>();
    static PriorityQueue<User> pq = new PriorityQueue<>();
    static User visitor;
    static User root;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        for(List<String> relationship : friends){
            User user1 = User.findUser(relationship.get(0));
            User user2 = User.findUser(relationship.get(1));

            user1.addFriend(user2);
            user2.addFriend(user1);
        }

        root = User.findUser(user);
        List<User> friendList = root.getFriends();

        for(User friend : friendList){
            User.calcFriendsScore(friend);
        }

//        friends 리스트에 없는 경우를 대비
        for(String visitorName : visitors) {
            visitor = User.findUser(visitorName);
            if(!friendList.contains(visitor)){
                User.calcVisitorsScore(visitor);
            }
        }

        Iterator<String> keyIt = map.keySet().iterator();
        while(keyIt.hasNext()){
            String key = keyIt.next();
            User tmpUser = User.findUser(key);
            if(tmpUser.getScore() > 0){
                pq.add(tmpUser);
            }
        }

        while(!pq.isEmpty()){
            User nextUser = pq.poll();
            answer.add(nextUser.getName());
        }

        return answer;
    }


    static class User implements Comparable<User>{

        private String name;
        private int score = 0;
        private List<User> friends = new ArrayList<>();

        public User(String name){
            this.name = name;
        }

        public boolean addFriend(User user){
            return this.friends.add(user);
        }

        public void addScore(int score){
            this.score += score;
        }

        public static User findUser(String name){

            if(!map.containsKey(name)){
                User newUser = new User(name);
                map.put(name, newUser);
                return newUser;
            }

            return map.get(name);
        }

        // 사용자와 함께 아는
        public static void calcFriendsScore(User userFriend){

            List<User> friends = userFriend.getFriends();

            for(User friend : friends){
                if(!friend.equals(root)) {
                    friend.addScore(10);
                }
            }
        }

        // 타임라인에 방문한 경우의 점수 계산 
        public static void calcVisitorsScore(User user){
            user.addScore(1);
        }

        @Override
        public int compareTo(User other) {
            return -1 * (this.score - other.getScore());
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof User && ((User) obj).getName().equals(name));
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public List<User> getFriends() {
            return friends;
        }
    }
}
