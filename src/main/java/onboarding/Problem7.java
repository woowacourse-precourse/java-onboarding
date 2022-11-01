package onboarding;

import java.util.*;

/*
 * 기능 구현 사항
 * 1. visitor 점수 추가.
 * 2. 각 유저별 친구 HashMap<String, List<String>> 으로 구현.
 * */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        HashMap<String, SNSUser> friendList = new HashMap<>();
        for (List<String> friend :
                friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            addFriend(friendList, firstFriend, secondFriend);
            addFriend(friendList, secondFriend, firstFriend);
        }
        SNSUser myAccount = friendList.get(user);
        for (String opponent :
                friendList.keySet()) {
            if (!Objects.equals(user, opponent)) {
                friendList.get(opponent).compareFriend(myAccount);
            }
        }

        for (String visitor :
                visitors) {
            if (!friendList.containsKey(visitor)) {
                SNSUser newUser = new SNSUser(visitor);
                newUser.addVisitor();
                friendList.put(visitor, newUser);
            } else
                friendList.getOrDefault(visitor, new SNSUser(visitor)).addVisitor();
        }


        List<SNSUser> friendScoreList = new ArrayList<>(friendList.values());
        Collections.sort(friendScoreList);
        for (SNSUser friend:
                friendScoreList.subList(0, 5)) {
            if(!myAccount.getFriendList().contains(friend.getUserName()) && !Objects.equals(friend.getUserName(), user)){
                answer.add(friend.getUserName());
            }
        }

        return answer;
    }

    public static void addFriend(HashMap<String, SNSUser> friendList, String me, String myFriend) {
        SNSUser mySNS = friendList.getOrDefault(me, new SNSUser(me));
        mySNS.addFriend(myFriend);
        friendList.put(me, mySNS);
    }
}

