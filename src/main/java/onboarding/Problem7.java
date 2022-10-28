package onboarding;

import java.util.*;

public class Problem7 {

    //모든 {사용자=[사용자의 친구들]} Map
    private static Map<String, List<String>> friendsOfPerson = new HashMap<>();
    //본인과 이미 친구인 사람 목록 List
    private static List<String> alreadyFriends = new ArrayList<>();


    //{사용자=[사용자의 친구들]} friends 목록과 대조해 만들기
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

        //점수 부여에 사용 할 함께아는 친구, 방문자 List
        List<String> knowMyFriendList = new ArrayList<>();
        List<String> visitorList = new ArrayList<>();

        //결과에 포함되지않는 user, user 친구 제외 list
        alreadyFriends.add(user);
        alreadyFriends.addAll(mapFriendsOfPerson(friends, user).get(user));

        //제외 List 사용자들을 friendsOfPerson 추가
        for (String alreadyFriend : alreadyFriends) {
            mapFriendsOfPerson(friends, alreadyFriend);
        }

        //제외 List의 사용자들의 친구들을 합쳐 점수를 부여할 List
        for (List<String> friendName : friendsOfPerson.values()) {
            knowMyFriendList.addAll(friendName);
        }




        return answer;
    }
}
