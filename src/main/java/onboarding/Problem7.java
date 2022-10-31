package onboarding;

import java.util.*;

public class Problem7 {
    private static class User implements Comparable<User> {
        int score;
        String name;

        public User(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(User o) {
            if(this.score==o.score) return -this.name.compareTo(o.name);
            return -Integer.compare(this.score, o.score);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, User> users = new HashMap<>();

        List<String> userFriends = findFriends(user, friends);

        for(String userFriend: userFriends){
            for(String userFriendOfFriend: findFriends(userFriend, friends)){
                users.put(userFriendOfFriend, new User(userFriendOfFriend, 10));
            }
        }

        for(String visitor: visitors){
            users.put(visitor, new User(visitor, users.get(visitor).score+1));
        }

        List<User> recommendUser = new ArrayList<>();
        for(String key: users.keySet()){
            if(!isMeOrUserFriends(users.get(key).name, user, userFriends)){
                recommendUser.add(users.get(key));
            }
        }

        Collections.sort(recommendUser);

        for(int i=0;i<recommendUser.size()&&i<5;i++){
            answer.add(recommendUser.get(i).name);
        }

        return answer;
    }

    private static List<String> findFriends(String userName, List<List<String>> friends){
        List<String> ret = new ArrayList<>();

        for(List<String> friend: friends){
            if(friend.get(0).equals(userName)){
                ret.add(friend.get(1));
                break;
            }

            if(friend.get(1).equals(userName)){
                ret.add(friend.get(0));
                break;
            }
        }

        return ret;
    }

    private static boolean isMeOrUserFriends(String userName, String user, List<String> userFriends){
        for(String userFriend: userFriends){
            if(userName.equals(userFriend))
                return true;
        }

        return userName.equals(user);
    }

    private static List<String> getTop5(Map<String, User> users){

    }
}
