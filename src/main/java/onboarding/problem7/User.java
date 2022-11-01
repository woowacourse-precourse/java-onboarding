package onboarding.problem7;

import java.util.*;

public class User {

    private String name;
    private List<String> friendsOfMyFriends = new ArrayList<>();


    public User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameLength(name);
        validateLowerCase(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 30) {
            throw new IllegalArgumentException("user의 길이는 30이하 입니다.");
        }
    }

    private void validateLowerCase(String name) {
        for (char character : name.toCharArray()) {
            if (!Character.isLowerCase(character)) {
                throw new IllegalArgumentException("사용자 아이디는 알파벳 소문자로만 이루어져 있어야합니다.");
            }
        }
    }

    public Map<String, Integer> getVisitStatistics(List<String> visitors) {
        Map<String, Integer> visitStatistics = new HashMap<>();
        for (String visit : visitors) {
            visitStatistics.put(visit, Collections.frequency(visitors, visit));
        }
        return visitStatistics;
    }

    public List<String> getMyFriends(List<List<String>> friends) {
        List<String> myFriends = new ArrayList<>();
        for (List<String> friend : friends ) {
            if(isMyFriend(friend)){
                myFriends.add((friend.get(0)));
            }
        }
        return myFriends;
    }

    private boolean isMyFriend(List<String> friend) {
        return this.name.equals(friend.get(1));
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
