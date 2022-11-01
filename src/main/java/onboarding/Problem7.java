package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> friendsOfUser = new ArrayList<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        findFriendsOfUser(friends, friendsOfUser, user); // user의 친구 찾기
        return answer;
    }

    public static void findFriendsOfUser(List<List<String>> friends, ArrayList<String> friendsOfUser, String user) {
        String firstPerson;
        String secondPerson;
        for (int i = 0; i < friends.size(); i++) {
            firstPerson = friends.get(i).get(0);
            secondPerson = friends.get(i).get(1);

            if (firstPerson == user) friendsOfUser.add(secondPerson);
            else if (secondPerson == user) friendsOfUser.add(firstPerson);
        }
    }

}
