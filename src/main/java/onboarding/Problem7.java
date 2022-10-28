package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        FriendGraph friendGraph = new FriendGraph();

        for (List<String> friend : friends) {
            initUserScoreMap(scoreMap, friend.get(0));
            initUserScoreMap(scoreMap, friend.get(1));
            friendGraph.addFriend(friend.get(0),friend.get(1));
            friendGraph.addFriend(friend.get(1),friend.get(0));
        }

        List<String> userFriendList = friendGraph.getFriendList(user);
        updateScoreMapByUserFriendList(friendGraph, scoreMap, userFriendList);
        updateScoreMapByVisitorList(visitors, scoreMap);

        deleteScoreMapMemberByUserFriendList(user, scoreMap, userFriendList);

        return scoreMap.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o2.getValue())
                .map(i -> i.getKey())
                .limit(5)
                .collect(Collectors.toList());
    }


    static class Member {
        private String name;
        private Integer score;

        private List<String> friendList = new ArrayList<>();


        public Member(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public List<String> getFriendList() {
            return friendList;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }

        public void changeScore(Integer score) {
            this.score = score;
        }

    }


    static class MemberRepository {

        private Map<String, Member> store = new HashMap();

        public void addFriend(Member user, String friend) {
            if (!store.containsKey(user.getName())) {
                store.put(user.getName(), user);
            }
            store.get(user.getName()).getFriendList().add(friend);
        }

        public void deleteMember(String user) {
            store.remove(user);
        }

        private boolean containUsername(String user) {
            return store.containsKey(user);
        }


        public Optional<Member> findMemberByUsername(String user) {
            return Optional.ofNullable(store.get(user));
        }

        public List<Member> findAll() {
            return new ArrayList<>(store.values());
        }

        public Optional<List<String>> findFriendListByUsername(String user) {
            Optional<Member> member = findMemberByUsername(user);
            if (!member.isPresent()) {
                return Optional.empty();
            }
            return Optional.ofNullable(member.get().getFriendList());
        }

    }

    static class FriendGraph {
        private Map<String, List<String>> friendMap = new HashMap<>();

        public void addFriend(String user, String friend) {
            if (!friendMap.containsKey(user)) {
                friendMap.put(user,new ArrayList<>());
            }
            friendMap.get(user).add(friend);
        }

        public List<String> getFriendList(String user) {
            return friendMap.get(user);
        }

        public Iterator<String> getIteratorFriendGraph(){
            return friendMap.keySet().iterator();
        }

    }
    private static void initUserScoreMap(Map<String, Integer> scoreMap, String user) {
        if (!scoreMap.containsKey(user)) {
            scoreMap.put(user, 0);
        }
    }

    private static void updateScoreByUserFriendList(MemberRepository memberRepository,
                                                    String user) {

        Optional<List<String>> friendListByUsername = memberRepository.findFriendListByUsername(user);

        if (!friendListByUsername.isPresent()) {
            return;
        }

        for (String userFriend : friendListByUsername.get()) {
            for (Member member : memberRepository.findAll()) {
                if (member.getFriendList().contains(userFriend)) {
                    member.changeScore(member.score + 10);
                }
            }
        }
    }
    
    private static void deleteScoreMapMemberByUserFriendList(String user, Map<String, Integer> scoreMap, List<String> userFriendList) {
        for (String userFriend : userFriendList) {
            scoreMap.remove(userFriend);
        }
        scoreMap.remove(user);
    }

    private static void updateScoreMapByVisitorList(List<String> visitors, Map<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            if (!scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, 0);
            }
            scoreMap.put(visitor, scoreMap.get(visitor) + 1);
        }
    }


}
