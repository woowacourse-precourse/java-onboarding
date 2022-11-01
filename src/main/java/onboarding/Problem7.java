package onboarding;

import java.util.*;

public class Problem7 {

    static Map<String, User> duplicationCheckingMap = new HashMap<>();
    static PriorityQueue<User> pq = new PriorityQueue<>();
    static User visitor;
    static User rootUser;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        for(List<String> relationship : friends){
            User user1 = User.findUser(relationship.get(0));
            User user2 = User.findUser(relationship.get(1));

            user1.addFriend(user2);
            user2.addFriend(user1);
        }

        rootUser = User.findUser(user);
        Friends rootUserFriends = rootUser.getFriends();
        List<User> friendsList = rootUserFriends.getFriendsList();

        Friends.calcFriendsScore(rootUser);



//        friends 리스트에 없는 경우를 대비
        for(String visitorName : visitors) {
            visitor = User.findUser(visitorName);

            if(!friendsList.contains(visitor)){
                User.calcVisitorsScore(visitor);
            }
        }

        Iterator<String> keyIt = duplicationCheckingMap.keySet().iterator();

        while(keyIt.hasNext()){
            String key = keyIt.next();
            User tmpUser = User.findUser(key);

            if(tmpUser.getScore() > 0){    // 0점 이상인 유저만 우선순위 큐에 add
                pq.add(tmpUser);
            }
        }

        // 우선순위 큐에 들어있는 User 인스턴스의 String 값만 answer에 넣어 반환
        while(!pq.isEmpty()){
            User nextUser = pq.poll();
            String userName = nextUser.getName();
            answer.add(userName);
        }

        return answer;
    }


    static class User implements Comparable<User>{
        private static final int VISITOR_SCORE = 1;
        private static final int MIN_USER_NAME_LENGTH = 1;
        private static final int MAX_USER_NAME_LENGTH = 30;

        private String name;
        private int score = 0;
//        private List<User> friends = new ArrayList<>();

        private Friends friends = new Friends();

        public User(String name){
            validateNameLength(name);
            validateNameLowerCase(name);

            this.name = name;
        }

        public void addFriend(User user){
            this.friends.addFriend(user);
        }

        public void addScore(int score){
            this.score += score;
        }

        public static User findUser(String name){

            if(!duplicationCheckingMap.containsKey(name)){
                User newUser = new User(name);
                duplicationCheckingMap.put(name, newUser);
                return newUser;
            }

            return duplicationCheckingMap.get(name);
        }


        // 타임라인에 방문한 경우의 점수 계산 
        public static void calcVisitorsScore(User user){
            user.addScore(VISITOR_SCORE);
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

        public Friends getFriends() {
            return friends;
        }

        void validateNameLength(String name){
            if(MIN_USER_NAME_LENGTH > name.length() || name.length() > MAX_USER_NAME_LENGTH){
                throw new IllegalArgumentException("길이가 " +
                        MIN_USER_NAME_LENGTH + " 이상 " + MAX_USER_NAME_LENGTH + " 이하인 문자열이어야 한다.");
            }
        }

        void validateNameLowerCase(String name){
            for(int i = 0; i < name.length(); i++){
                char c = name.charAt(i);
                if(Character.isUpperCase(c)){
                    throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로만 이루어져 있어야 한다.");
                }
            }
        }
    }

    // 일급 컬렉션 적용
    static class Friends{
        private static final int FRIEND_SCORE = 10;

        private List<User> friends = new ArrayList<>();

        public List<User> getFriendsList() {
            return friends;
        }

        public void addFriend(User friend){
            this.friends.add(friend);
        }


        // 인자로 받은 유저의 직접적인 친구들의 친구들을 방문하며 점수계산한다.
        public static void calcFriendsScore(User user){

            Friends friendList = user.getFriends();

            for(User friend : friendList.getFriendsList()){
                Friends friendsOfFriend = friend.getFriends();

                for(User friendOfFriend : friendsOfFriend.getFriendsList()){

                    if(!friendOfFriend.equals(rootUser)) {
                        friendOfFriend.addScore(FRIEND_SCORE);
                    }
                }
            }
        }
    }
}