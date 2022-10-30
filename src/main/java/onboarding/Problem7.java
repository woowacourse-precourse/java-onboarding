package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Problem7 {
    final static int LEFT_FRIEND = 0;
    final static int RIGHT_FRIEND = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // user와 친구가 아닌것을 걸러야된다.
        ArrayList<String> notFriendUserList = new ArrayList<>();
        ArrayList<String> friendUserList = new ArrayList<>();
        ArrayList<String> personList = new ArrayList<>();
        List<String> listAtNow = null;
        String leftFriendsInList = "";
        String rightFriendsInList = "";
        String namePersonAtNow = "";

        int endFistSize = friends.size();
        int endSecondSize = friends.get(0).size();
        for (int firstListIndex = 0; firstListIndex < endFistSize; firstListIndex++) {
            // friends 리스트 안의 리스트 작업
            listAtNow = friends.get(firstListIndex);

            leftFriendsInList = listAtNow.get(LEFT_FRIEND);
            rightFriendsInList = listAtNow.get(RIGHT_FRIEND);

            // user의 친구면? FriendUserListdp 넣는다.
            if (Objects.equals(user, leftFriendsInList)) {
                friendUserList.add(rightFriendsInList);
            }
            if (Objects.equals(user, rightFriendsInList)) {
                friendUserList.add(leftFriendsInList);
            }
            personList.add(leftFriendsInList);
            personList.add(rightFriendsInList);
        }

        personList = (ArrayList<String>) personList.stream().distinct().collect(Collectors.toList());
        System.out.println("personList.toString() = " + personList.toString());

        friendUserList = (ArrayList<String>) friendUserList.stream().distinct().collect(Collectors.toList());
        System.out.println("friendUserList.toString() = " + friendUserList.toString());

        // 친구가 아닌 리스트를 만든다.
        boolean isFriend = true;
        int endPersonList = personList.size();
        for (int personIndex = 0; personIndex < endPersonList; personIndex++) {
            isFriend = false;
            namePersonAtNow = personList.get(personIndex);

            // 현재 사람이 친구인지 판별
            for (int friendUserIndex = 0; friendUserIndex < friendUserList.size(); friendUserIndex++) {
                String nameFriendUserAtNow = friendUserList.get(friendUserIndex);
                if (namePersonAtNow.equals(nameFriendUserAtNow)) {
                    isFriend = true;
                }
            }

            if (!isFriend) {
                notFriendUserList.add(namePersonAtNow);
            }
        }

        notFriendUserList = (ArrayList<String>) notFriendUserList.stream().distinct().collect(Collectors.toList());
        System.out.println("notFriendUserList.toString() = " + notFriendUserList.toString());
        return answer;
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
        List<String> result = List.of("andole", "jun", "bedi");

        solution(user, friends, visitors);
    }
}
