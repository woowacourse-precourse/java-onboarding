package onboarding.problem7.collections;

import onboarding.problem7.wrapper.User;

import java.util.List;

public class VisitorList {
    private final List<User> visitorList;

    public VisitorList(List<User> visitors) {
        validateVisitorListLength(visitors);
        this.visitorList = visitors;
    }

    private void validateVisitorListLength(List<User> visitors) {
        int friendsLength = visitors.size();
        if (friendsLength > 10000 || friendsLength < 1) {
            throw new IllegalArgumentException("visitors 길이는 1이상 10000이하여야 합니다.");
        }
    }
}
