package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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
