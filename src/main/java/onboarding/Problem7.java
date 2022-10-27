package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList = new ArrayList<>();
        HashMap<String, Integer> memberList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            friendList = insertFriendToListIfUserFriend(friends.get(i).get(0), friends.get(i).get(1), user, friendList);
            //전체 멤버 리스트 작성 기능
            memberList.put(friends.get(i).get(0), 0);
            memberList.put(friends.get(i).get(1), 0);
        }
        //visitor 추가 입력
        for (int i = 0; i < visitors.size(); i++) {
            memberList.put(visitors.get(i), 0);
        }

        for (int i = 0; i < friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);

            if(friend1.equals(user) || friend2.equals(user)){
                continue;
            }
            memberList = checkUserFriendFriend(friend1, friend2, friendList, memberList);
        }

        for (int i = 0; i < visitors.size(); i++) {
            memberList = visitorsScorePlusOne(visitors.get(i), memberList, friendList);
        }

        //HashMap value 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedMemberList = sortedMapByValue(memberList);
        return answer;
    }
    //user의 친구목록을 작성하는 기능
    public static List<String> insertFriendToListIfUserFriend(String friend1, String friend2, String user, List<String>friendList){
        if (friend1.equals(user)) {
            friendList.add(friend2);
        }
        if (friend2.equals(user)) {
            friendList.add(friend1);
        }
        return friendList;
    }

    //user의 친구의 친구인지 확인, 맞으면 10점 추가하는 기능
    public static HashMap<String, Integer> checkUserFriendFriend(String friend1, String friend2, List<String> friendList, HashMap<String, Integer> memberList){
        if(friendList.contains(friend1)){
            Integer score = memberList.get(friend2);
            memberList.replace(friend2, score + 10);
        }
        if(friendList.contains(friend2)){
            Integer score = memberList.get(friend1);
            memberList.replace(friend1, score + 10);
        }
        return memberList;
    }

    public static HashMap<String, Integer> visitorsScorePlusOne(String visitor, HashMap<String, Integer> memberList, List<String> friendList){
        //user와 친구관계면 점수 X
        if (friendList.contains(visitor)) {
            return memberList;
        }
        //방문자 점수 +1
        if (memberList.containsKey(visitor)) {
            Integer score = memberList.get(visitor);
            memberList.replace(visitor, score + 1);
        }
        return memberList;
    }
    public static List<Map.Entry<String, Integer>> sortedMapByValue(HashMap<String, Integer> memberList){
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(memberList.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        return entryList;
    }
}
