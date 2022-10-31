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
        for (List<String> friendship : friends) {
            List<String> friendshipInArrayList = new ArrayList<>(friendship);
            this.friends.add(friendshipInArrayList);
        }
        this.visitors = new ArrayList<>(visitors);
    }

    // 메소드
    public void updateMyFriends() {
        myFriends = new HashSet<>();
        for (List<String> friendship : friends) {
            if (friendship.contains(user)) {
                friendship.removeIf(element -> element.equals(user));
                String myFriend = String.join("", friendship);
                myFriends.add(myFriend);
                friendship.add(user);
            }
        }
    }

    public void updateNotMyFriends() {
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
    }

    public Map<String, Integer> getRecommendationScores() {
        updateMyFriends();
        updateNotMyFriends();
        recommendationScores = new HashMap<>();
        for (String person : notMyFriends) {
            recommendationScores.put(person, initialScore);
        }
        return recommendationScores;
    }

    public void updateRecommendationScores() {
        for (String notMyFriend : notMyFriends) {
            for (String myFriend : myFriends) {
                checkFriendship(notMyFriend, myFriend);
            }
            checkVisit(notMyFriend);
        }
    }

    public void checkFriendship(String notMyFriend, String myFriend) {
        Set<String> friendship = new HashSet<>(List.of(notMyFriend, myFriend));
        for (List<String> validFriendship :friends) {
            Set<String> validFriendshipInHashSet = new HashSet<>(validFriendship);
            if (validFriendshipInHashSet.equals(friendship)) {
                int currentScore = recommendationScores.get(notMyFriend);
                currentScore += 10;
                recommendationScores.replace(notMyFriend, currentScore);
            }
        }
    }

    public void checkVisit(String notMyFriend) {
        for (String visitor : visitors) {
            if (visitor.equals(notMyFriend)) {
                int currentScore = recommendationScores.get(notMyFriend);
                currentScore++;
                recommendationScores.replace(notMyFriend, currentScore);
            }
        }
    }
}
