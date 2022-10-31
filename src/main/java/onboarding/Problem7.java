package onboarding;

import org.mockito.internal.util.collections.Sets;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<User> repository = new ArrayList<>();
    public static final int SAME_FRIEND_SCORE = 10;
    public static final int VISIT_SCORE = 1;
    public static final int DEFAULT_SCORE = 0;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initUsers(friends, visitors);
        initFriend(friends);
        User userInstance = getUserFromList(user);
        userInstance.setVisitor(visitors);
        List<User> candidates = getCandidateList(userInstance);
        initScore(candidates, DEFAULT_SCORE);
        calculateScore(userInstance, candidates);
        return getResultFromCandidates(candidates);
    }

    private static List<String> getResultFromCandidates(List<User> candidates) {
        return candidates.stream()
                .filter(candi -> candi.getScore() > 0)
                .sorted(Comparator.comparing(User::getScore).reversed()
                        .thenComparing(Comparator.comparing(User::getName)))
                .map(User::getName)
                .collect(Collectors.toList());
    }

    private static void initUsers (List<List<String>> friends, List<String> visitors) {
        List<String> names = getNamesFromFriends(friends);
        names.addAll(visitors);
        names.stream()
                .distinct()
                .forEach(Problem7::registerNewUser);
    }

    private static List<String> getNamesFromFriends(List<List<String>> friends) {
        return friends.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static User registerNewUser(String name){
        User newUser = new User(name);
        repository.add(newUser);
        return newUser;
    }

    private static void initFriend(List<List<String>> friends) {
        friends.forEach(friend -> {
            User userA = getUserFromList(friend.get(0));
            User userB = getUserFromList(friend.get(1));
            userA.addFriend(userB);
            userB.addFriend(userA);
        });
    }

    private static User getUserFromList(String name){
        return repository.stream()
                .filter(tmpUser -> tmpUser.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("can't find user in repository"));
    }

    private static void initScore(List<User> candidates, int score){
        candidates.forEach(user -> user.setScore(score));
    }

    private static List<User> getCandidateList(User user){
        return repository.stream()
                .filter(tmpUser -> !tmpUser.getName().equals(user.getName()))
                .filter(tmpUser -> !tmpUser.isFriend(user))
                .collect(Collectors.toList());
    }

    private static void calculateScore(User user, List<User> candidates){
        candidates.forEach(tmpUser -> {
            int score = 0;
            score += user.getSameFriendCount(tmpUser) * SAME_FRIEND_SCORE;
            score += user.getVisitCount(tmpUser) * VISIT_SCORE;
            tmpUser.setScore(score);
        });
    }

    static class User{
        private final String name;
        private List<User> friends;
        private List<String> visitor;
        private int score;

        public User(String name) {
            this.name = name;
            this.friends = new ArrayList<>();
            this.visitor = new ArrayList<>();
            this.score = 0;
        }

        public boolean isFriend(User name){
            if (friends.contains(name)){
                return true;
            }
            return false;
        }

        public void addFriend(User name){
            friends.add(name);
        }

        public void setVisitor(List<String> visitor) {
            this.visitor = visitor;
        }

        public List<User> getFriends() {
            return friends;
        }

        //
        public int getSameFriendCount(User srcUser) {
            return (int)srcUser.getFriends().stream()
                    .filter(friend -> this.isFriend(friend))
                    .count();
        }

        public int getVisitCount(User srcUser){
            return (int)this.visitor.stream()
                    .filter(visitor -> visitor.equals(srcUser.getName()))
                    .count();
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
