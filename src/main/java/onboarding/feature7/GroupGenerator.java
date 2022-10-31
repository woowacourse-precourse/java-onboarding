package onboarding.feature7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupGenerator {
    // 필드
    private String user;

    private List<List<String>> friends = new ArrayList<>();
    private List<String> visitors;

    // 생성자
    public GroupGenerator(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        for (List<String> friend : friends) {
            List<String> friendInArrayList = new ArrayList<>(friend);
            this.friends.add(friendInArrayList);
        }
        this.visitors = new ArrayList<>(visitors);
    }

    // 메소드
    public Set<String> getMyFriends() {
        Set<String> myFriends = new HashSet<>();
        for (List<String> friendships : friends) {
            if (friendships.contains(user)) {
                friendships.removeIf(element -> element.equals(user));
                String myFriend = String.join("", friendships);
                myFriends.add(myFriend);
            }
        }
        return myFriends;
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
    }
}
