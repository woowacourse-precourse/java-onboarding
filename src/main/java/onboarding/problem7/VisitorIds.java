package onboarding.problem7;

import onboarding.problem7.exception.FriendsException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VisitorIds {

    private static final int MAX = 10_000;
    private final List<SnsId> visitors;

    public VisitorIds(List<String> visitors) {
        checkMaxVisit(visitors);
        this.visitors = convertVisitorIds(visitors);
    }

    private static List<SnsId> convertVisitorIds(List<String> visitors) {
        return visitors.stream().map(SnsId::new).collect(Collectors.toList());
    }

    private static void checkMaxVisit(List<String> visitors) {
        if (visitors.size() > MAX) {
            throw new FriendsException("처리할 수 있는 방문자 정보보다 더 많습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitorIds visitors1 = (VisitorIds) o;
        return Objects.equals(visitors, visitors1.visitors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitors);
    }

    public List<SnsId> getVisitors() {
        return visitors;
    }

}
