package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        HashMap<String, User> userTable = friendsToTable(friends);
        HashMap<String, Integer> recomendTable = new HashMap<String, Integer>();

        // 방문자에게 점수 부여
        for(String v : visitors) {
            recomendTable.putIfAbsent(v, 0);  // map에 없는 유저를 등록
            recomendTable.put(v, recomendTable.get(v) + 1);
        }

        // 함께아는 친구에게 점수 부여
        List<String> myFriendList = userTable.get(user).getFriendList();  // 내 친구목록을 확인한다.
        for(String friendName : myFriendList) {
            // 친구가 아는 친구들에게 점수부여
            List<String> friendList = userTable.get(friendName).getFriendList();
            for(String name : friendList) {
                recomendTable.putIfAbsent(name, 0);  // map에 없는 유저를 등록
                recomendTable.put(name, recomendTable.get(name) + 10);
            }
        }

        // 정렬 진행 (점수 DESC, 이름 ASC)
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<>(recomendTable.entrySet());  // Map.Entry 리스트 작성

        list_entries.sort((obj1, obj2) -> {
            // 내림 차순으로 정렬
            int result = obj2.getValue().compareTo(obj1.getValue());
            if (result == 0 && obj1.getKey().compareTo(obj2.getKey()) < 0) { // 점수가 같은 경우 이름이 빠른순으로 적용
                result = -1;
            }
            return result;
        });

        // 결과 정리 (이미 친구인 사람 제외하여 점수 순으로 추가)
        int i = 0;
        for(Map.Entry<String, Integer> entry : list_entries) {
            // 5명이 넘어가면 중단한다. (5명까지만 친구추천)
            if(i++ >= 5)
                break;

            // 친구추천 목록(answer)에 추가
            String name = entry.getKey();
            if(name != user && !userTable.get(user).findFriend(name))
                answer.add(name);
        }

        return answer;
    }

    // 친구 리스트를 HashMap 형태로 변환하는 함수
    public static HashMap<String, User> friendsToTable(List<List<String>> friends) {
        HashMap<String, User> userTable = new HashMap<String, User>();

        for(List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            // 처음 등록되는 유저의 경우 새로 만든다.
            if(userTable.get(user1) == null) {
                List<String> friendList = new ArrayList<String>();
                User u = new User(user1, friendList);
                userTable.put(user1, u);
            }
            if(userTable.get(user2) == null) {
                List<String> friendList = new ArrayList<String>();
                User u = new User(user2, friendList);
                userTable.put(user2, u);
            }

            // 친구 등록
            User u1 = userTable.get(user1);
            User u2 = userTable.get(user2);
            u1.addFriend(user2);
            u2.addFriend(user1);
        }

        return userTable;
    }

    // 유저의 정보(이름 및 친구목록)를 저장하는 클래스
    public static class User {
        private String username;
        private List<String> friendList;  // 친구 목록

        public User(String username, List<String> friendList) {
            this.username = username;
            this.friendList = friendList;
        }

        // 친구 추가
        public void addFriend(String friendName) {
            if(!findFriend(friendName))  // 친구가 아닌경우에만
                friendList.add(friendName);
        }

        // 특정 사용자와 친구인지 확인
        public boolean findFriend(String friendName) {
            return friendList.contains(friendName);
        }

        // 친구목록을 반환
        public List<String> getFriendList() {
            return friendList;
        }

        public void printFriendList() {
            for(String s : friendList) {
                System.out.println(this.username + ": " + s);
            }
        }
    }
}
