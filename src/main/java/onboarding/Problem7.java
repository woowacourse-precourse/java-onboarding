package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    private void addMemberList(List<String> memberList, String user, List<List<String>> friends, List<String> visitors) {
        addList(memberList, user);

        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            addList(memberList, firstFriend);
            addList(memberList, secondFriend);
        }

        for (String visitor : visitors) {
            addList(memberList,visitor);
        }
    }

    private void addList(List<String> memberList, String member) {
        if (!memberList.contains(member)) memberList.add(member);
    }

    private void friendsToFriendList(List<List<String>> friends, List<String> memberList, List<List<String>> friendList) {
        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            int firstIdx = memberList.indexOf(firstFriend);
            int secondIdx = memberList.indexOf(secondFriend);
            friendList.get(firstIdx).add(secondFriend);
            friendList.get(secondIdx).add(firstFriend);
        }
    }

    private boolean checkFriendOrOwn(String user, List<List<String>> friendList, int memberIdx, String visitor) {
        return visitor == user || friendList.get(memberIdx).contains(visitor);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Problem7 problem7 = new Problem7();

        List<String> memberList = new ArrayList<>();
        List<List<String>> friendList =new ArrayList<>();

        problem7.addMemberList(memberList, user, friends, visitors);

        for (int i = 0; i < memberList.size(); i++) {
            friendList.add(new ArrayList<>());
        }

        problem7.friendsToFriendList(friends, memberList, friendList);

        int memberIdx = memberList.indexOf(user);
        List<String> selectedMemberList = friendList.get(memberIdx);
        HashMap<String, Integer> friendScoreMap = new HashMap<>();

        for (String member : memberList) {
            if (problem7.checkFriendOrOwn(user, friendList, memberIdx, member)) continue;

            int findMemberIdx = memberList.indexOf(member);
            List<String> findMemberList = friendList.get(findMemberIdx);

            for (String findMember : findMemberList) {
                if (selectedMemberList.contains(findMember)) {
                    friendScoreMap.put(member, friendScoreMap.getOrDefault(member, 0) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (problem7.checkFriendOrOwn(user, friendList, memberIdx, visitor)) continue;
            friendScoreMap.put(visitor, friendScoreMap.getOrDefault(visitor, 0) + 1);
        }

        List<String> answer = new ArrayList<>(friendScoreMap.keySet());
        Collections.sort(answer, (o1, o2) -> {
            if (friendScoreMap.get(o1) == friendScoreMap.get(o2)) return o1.compareTo(o2);
            else return friendScoreMap.get(o2) - friendScoreMap.get(o1);
        });
        return answer;
    }
}
