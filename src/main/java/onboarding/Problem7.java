package onboarding;

import java.util.*;

public class Problem7 {

    //{인간=[이 인간의 친구들]} 매핑
    private static Map<String, List<String>> friendsOfPerson = new HashMap<>();



    private static Map<String, List<String>> mapFriendsOfPerson(List<List<String>> friends, String person) {
        List<String> friendsList = new ArrayList<>();

        for(List<String> friend : friends){
            if (friend.indexOf(person) == 0) {
                friendsList.add(friend.get(1));
            } else if (friend.indexOf(person) == 1) {
                friendsList.add(friend.get(0));
            }else{
                continue;
            }
        }
        friendsOfPerson.put(person, friendsList);
        return friendsOfPerson;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();


        return answer;
    }
}
