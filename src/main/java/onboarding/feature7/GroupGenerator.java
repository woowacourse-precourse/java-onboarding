package onboarding.feature7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupGenerator {
    // 필드
    private int initialScore = 0;
    private String user;

    private List<List<String>> friends;
    private List<String> visitors;
    private Map<String, Integer> recommendationScores;
    private Set<String> myFriends;
    private Set<String> notMyFriends;

    // 생성자
    public GroupGenerator(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = new ArrayList<>();
        for (List<String> friend : friends) {
            List<String> friendInArrayList = new ArrayList<>(friend);
            this.friends.add(friendInArrayList);
        }
        this.visitors = new ArrayList<>(visitors);
    }

    // 메소드
    public Set<String> getMyFriends() {
        myFriends = new HashSet<>();
        for (List<String> friendships : friends) {
            if (friendships.contains(user)) {
                friendships.removeIf(element -> element.equals(user));
                String myFriend = String.join("", friendships);
                myFriends.add(myFriend);
            }
        }
        return myFriends;
    }

    public Set<String> getNotMyFriends() {
        Set<String> meAndMyFriends = new HashSet<>();
        meAndMyFriends.addAll(myFriends);
        meAndMyFriends.add(user);

        Set<String> allThePeople = new HashSet<>();
        allThePeople.add(user);
        for (String visitor : visitors) {
            allThePeople.add(visitor);
        }
        for (List<String> friendships : friends) {
            for (String person : friendships) {
                allThePeople.add(person);
            }
        }

        allThePeople.removeAll(meAndMyFriends);
        notMyFriends = allThePeople;
        return notMyFriends;
    }

    public Map<String, Integer> getRecommendationScores() {
        recommendationScores = new HashMap<>();
        for (String person : notMyFriends) {
            recommendationScores.put(person, initialScore);
        }
        return recommendationScores;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        GroupGenerator groupGenerator = new GroupGenerator(user, friends, visitors);
        Set<String> myFriends = groupGenerator.getMyFriends();
        Set<String> notMyFriends = groupGenerator.getNotMyFriends();
        Map<String, Integer> recommendationScores = groupGenerator.getRecommendationScores();

        System.out.println(myFriends);
        System.out.println(notMyFriends);
        System.out.println(recommendationScores);
    }
}
