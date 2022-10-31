package onboarding.problem7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {

    private String name;

    private Friends friends;

    private Visitors visitors;

    public User(String name) {
        NameValidator.validateName(name);
        this.name = name;
        this.friends = new Friends(new ArrayList<>());
        this.visitors = new Visitors(new ArrayList<>());
    }

    public static User create(String name) {
        return new User(name);
    }

    public List<String> getMyFriendList() {
        return friends.getFriendList();
    }

    public List<String> getRecommendFriendList() {
        final List<String> myFriendList = getMyFriendList();

        final List<Recommend> friendsRecommends = friends.getFriendsRecommend(this, myFriendList);
        final List<Recommend> visitorsRecommends = visitors.getVisitorsRecommend(this, myFriendList);

        final List<Recommend> recommendList = Stream.of(friendsRecommends, visitorsRecommends)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableList());

        return RecommendFactory.getRecommendFriendList(recommendList);

    }

    public void addFriend(Friend newFriend) {
        friends.add(newFriend);
    }

    public void addVisitor(Visitor newVisitor) {
        visitors.add(newVisitor);
    }

    public String getName() {
        return name;
    }
}
