package onboarding.problem7;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Visitors {

    private static final Integer VISITORS_SIZE = 10000;
    private static final Integer VISITOR_SCORE = 1;

    private List<Visitor> visitors;

    protected Visitors() {

    }

    public Visitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public void add(Visitor visitor) {
        validateVisitorsSize();
        visitors.add(visitor);
    }

    private void validateVisitorsSize() {
        if (visitors.size() > VISITORS_SIZE) {
            throw new IllegalStateException("Visitors의 크기는 10000이하어야 합니다.");
        }
    }

    public List<Recommend> getVisitorsRecommend(User user, List<String> myFriendList) {
        return visitors.stream()
                .filter(visitorIsNotMyFriendFilter(myFriendList))
                .filter(visitorIsNotMeFilter(user))
                .map(visitor -> Recommend.create(visitor.getName(), VISITOR_SCORE))
                .collect(Collectors.toUnmodifiableList());
    }

    private Predicate<Visitor> visitorIsNotMeFilter(User user) {
        return visitor -> !visitor.getName().equals(user.getName());
    }

    private Predicate<Visitor> visitorIsNotMyFriendFilter(List<String> myFriendList) {
        return visitor -> !myFriendList.contains(visitor.getName());
    }
}
