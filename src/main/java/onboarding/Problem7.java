package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String, User> map = new HashMap<>();
    static PriorityQueue<User> pq = new PriorityQueue<>();
    static User visitor, root;
    static List<String> result = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        for(List<String> relationship : friends){
            User user1 = findUser(relationship.get(0));
            User user2 = findUser(relationship.get(1));

            user1.addFriend(user2);
            user2.addFriend(user1);
        }

        root = findUser(user);
        List<User> userFriends = root.getFriends();

        for(User userFriend : userFriends){
            calcFriendsScore(userFriend);
        }

//        friends 리스트에 없는 경우를 대비
        for(String visitorName : visitors) {
            visitor = findUser(visitorName);
            if(!userFriends.contains(visitor)){
                calcVisitorsScore(visitor);
            }
        }


        Iterator<String> keyIt = map.keySet().iterator();
        while(keyIt.hasNext()){
            String key = keyIt.next();
            User tmpUser = findUser(key);
            if(tmpUser.getScore() > 0){
                pq.add(tmpUser);
            }
        }

        while(!pq.isEmpty()){
            User nextUser = pq.poll();
            result.add(nextUser.getName());
        }
//
//        answer = result;
//        return answer;
        return result;
    }

//    public static void addUserAtPq(User user){
//        if(!pq.contains(user)){
//           pq.add(user);
//        }
//    }
    public static User findUser(String name){
        if(!map.containsKey(name)){
            User newUser = new User(name);
            map.put(name, newUser);
            return newUser;
        }
        return map.get(name);
    }

    public static void calcFriendsScore(User user){

        List<User> friends = user.getFriends();

        for(User friend : friends){
            if(!friend.equals(root)) {
                friend.addScore(10);
            }
        }
    }

    public static void calcVisitorsScore(User user){
        user.addScore(1);
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

        @Override
        public int compareTo(User other) {
            return -1 * (this.score - other.getScore());
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof User && ((User) obj).getName().equals(name);
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
