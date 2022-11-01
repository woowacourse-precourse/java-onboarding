package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 유저의 친구 찾아서 List에 저장하는 기능
 * 2. 유저의 피드에 방문한 친구 찾아서 Map에 저장하는 기능
 * 3. 유저의 친구와 친구인 사람 찾아서 Map에 저장하는 기능
 * 4. 유저와 유저 친구는 Map에서 삭제하는 기능
 * 5. 친구 이름과 추천 점수를 정렬하기 위해 class 구현 후 정렬하는 기능
 */
public class Problem7 {

    static Map<String, Integer> friendsMap = new HashMap<>();
    static List<String> friendsOfUser = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        findFriendsOfUser(user, friends);

        findFriendVisitedFeed(visitors);

        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);

            if (firstFriend.equals(user) || secondFriend.equals(user)) {
                continue;
            }

            findFriendOfUserFriends(firstFriend, secondFriend);
        }

        deleteUserAndUserFriends(user);

        List<FriendInfomation> friendInfomations = new ArrayList<>();

        for (String key : friendsMap.keySet()) {
            int value = friendsMap.get(key);
            friendInfomations.add(new FriendInfomation(key, value));
        }

        for (FriendInfomation friendInfomation : friendInfomations){
            if(friendInfomation.score != 0 && answer.size() <= 5){
                answer.add(friendInfomation.name);

            }
        }

        return answer;
    }

    public static void findFriendOfUserFriends(String firstFriend, String secondFriend){
        for (String friendOfUser : friendsOfUser) {
            int score = 0;

            if (firstFriend.equals(friendOfUser)) {
                if (friendsMap.containsKey(secondFriend)) {
                    score = friendsMap.get(secondFriend);
                }
                friendsMap.put(secondFriend, score + 10);
            }

            if (secondFriend.equals(friendOfUser)) {
                if (friendsMap.containsKey(firstFriend)) {
                    score = friendsMap.get(firstFriend);
                }

                friendsMap.put(firstFriend, score + 10);
            }
        }
    }

    public static void deleteUserAndUserFriends(String user){
        for (String friendOfUser : friendsOfUser) {
            friendsMap.remove(friendOfUser);
        }
        friendsMap.remove(user);
    }

    public static void findFriendVisitedFeed(List<String> visitors){
        // 내 타임라인에 방문한 사람 찾고 map에 넣어주기
        for (String friend : visitors) {

            if (friendsMap.containsKey(friend)) {
                int score = friendsMap.get(friend);
                friendsMap.put(friend, score + 1);
                continue;
            }

            friendsMap.put(friend, 1);
        }
    }

    public static void findFriendsOfUser(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);

            if (firstFriend.equals(user)) {
                friendsOfUser.add(secondFriend);
            }
            if (secondFriend.equals(user)) {
                friendsOfUser.add(firstFriend);
            }
        }
    }

    static class FriendInfomation implements Comparable<FriendInfomation>{
        String name;
        int score;

        FriendInfomation(String name, int score){
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(FriendInfomation o) {
            if(this.score != o.score){
                return this.score - o.score;
            }

            return this.name.compareTo(o.name);
        }
    }
}
