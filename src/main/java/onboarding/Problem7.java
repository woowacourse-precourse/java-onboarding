package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        class User implements Comparable<User>{
            public String userName;
            public List<String> friendList = new ArrayList<>();
            public int score = 0;

            User(String userName, List<List<String>> friends) {
                this.userName = userName;
                this.setFriendList(friends);
                this.score = 0;
            }

            public void setFriendList(List<List<String>> friends) {
                for(List<String> friend : friends) {
                    String f1 = friend.get(0);
                    String f2 = friend.get(1);
                    if(this.userName.equals(f1)) this.friendList.add(f2);
                    if(this.userName.equals((f2))) this.friendList.add(f1);
                }
            }

            public void calcScore(User mainUser, List<String> visitors) {
                for(String mainFriend : mainUser.friendList) {
                    if(this.friendList.contains(mainFriend)) this.score += 10;
                }
                if(mainUser.friendList.contains(this.userName)) return;
                long cnt = visitors.stream()
                        .filter(visitor -> visitor == this.userName)
                        .count();
                this.score += cnt;
            }

            @Override
            public int compareTo(User o) {
                int chk = 0;
                if(this.score == o.score) {
                    chk = this.userName.compareTo(o.userName);
                    if(chk < 0) return -1;
                    if(chk == 0) return 0;
                    else return 1;
                }
                return this.score > o.score ? -1 : 1;
            }
        }

        List<String> answer = new ArrayList<>();
        User mainUser = new User(user, friends);
        List<User> userList = new ArrayList<>();

        // 친구 관계 세팅
        for(List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            if(!f1.equals(mainUser.userName) && userList.stream().noneMatch(user1 -> user1.userName.equals(f1)))
                userList.add(new User(f1, friends));
            if(!f2.equals(mainUser.userName) && userList.stream().noneMatch(user1 -> user1.userName.equals(f2)))
                userList.add(new User(f2, friends));
        }
        for(String visitor : visitors)
            if(!visitor.equals(mainUser.userName) && userList.stream().noneMatch(user1 -> user1.userName.equals(visitor)))
                userList.add(new User(visitor, friends));

        // 점수 부여
        for(User tUser : userList) tUser.calcScore(mainUser, visitors);


        // 점수순 정렬
        Collections.sort(userList);

        // String 배열로 포맷 변경
        for(int i=0; i<5; i++) {
            User tUser = userList.get(i);
            if(tUser.score != 0) answer.add(tUser.userName);
        }

        return answer;
    }
}
