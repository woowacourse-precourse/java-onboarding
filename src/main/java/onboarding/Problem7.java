package onboarding;

import java.util.*;

public class Problem7 {

    //모든 {사용자=[사용자의 친구들]} Map
    private static Map<String, List<String>> friendsOfPerson = new HashMap<>();
    //본인과 이미 친구인 사람 목록 List
    private static List<String> alreadyFriends = new ArrayList<>();

    //모르는 사람 = 점수 Map
    private static Map<String, Integer> strangerScoreMap = new HashMap<>();

    private static int friendsPoint = 10;
    private static int visitPoint = 1;


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

    //이미 친구인 목록 제거
    private static List<String> removeAlreadyFriend(List<String> knowMyFriends) {
        List<String> strangerList = new ArrayList<>();
        strangerList.addAll(knowMyFriends);
        strangerList.removeAll(alreadyFriends);
        return strangerList;
    }

    //점수 계산
    private static void calculationScore(List<String> nameList, int point) {
        int score = 0;

        for (String name : nameList) {
            if (strangerScoreMap.containsKey(name)) {
                score = strangerScoreMap.get(name);
            } else {
                score=0;
            }
            score += point;
            strangerScoreMap.put(name, score);
        }
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //점수 계산에 사용할 함께아는 친구, 방문자 List
        List<String> knowMyFriendList = new ArrayList<>();
        List<String> visitorList = new ArrayList<>();

        //결과에 포함되지않는 user, user 친구 제외 list
        alreadyFriends.add(user);
        alreadyFriends.addAll(mapFriendsOfPerson(friends, user).get(user));

        //결과에 포함되지 않는 사용자들(alreadyFriends)을 friendsOfPerson 추가
        for (String alreadyFriend : alreadyFriends) {
            mapFriendsOfPerson(friends, alreadyFriend);
        }

        //alreadyFriends 친구들을 합쳐 점수를 부여할 List
        for (List<String> friendName : friendsOfPerson.values()) {
            knowMyFriendList.addAll(friendName);
        }

        //친구끼리 아는 경우, 본인 등 제외
        knowMyFriendList.removeAll(alreadyFriends);
        visitorList.addAll(removeAlreadyFriend(visitors));

        //점수 계산해서 strangerScoreMap 매핑
        calculationScore(knowMyFriendList, friendsPoint);
        calculationScore(visitorList, visitPoint);

        //

        return answer;
    }
}
