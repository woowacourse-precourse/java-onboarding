package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        class User implements Comparable<User>{
            public String name;
            public List<String> list = new ArrayList<>();
            public int score;

            User(String userName, List<List<String>> friends) {
                this.name = userName;
                this.setList(friends);
                this.score = 0;
            }


            public void setScore(User user, List<String> visitors) {
                for(String friend : user.list) {
                    if(this.list.contains(friend)){
                        this.score += 10;
                    }
                }
                if(user.list.contains(this.name)) return;
                long cnt = visitors.stream()
                        .filter(visitor -> visitor == this.name)
                        .count();
                this.score += cnt;
            }

            public void setList(List<List<String>> friends) {
                for(List<String> friend : friends) {
                    String f1 = friend.get(0);
                    String f2 = friend.get(1);
                    if(this.name.equals(f1)) this.list.add(f2);
                    if(this.name.equals(f2)) this.list.add(f1);
                }
            }

            @Override
            public int compareTo(User user) {
                int flag = 0;
                if(this.score == user.score) {
                    flag = this.name.compareTo(user.name);
                    if(flag == 0) return 0;
                    else if(flag < 0) return -1;
                    else return 1;
                }
                else {
                    return (this.score > user.score ? -1 : 1);
                }
            }
        }

        List<String> answer = new ArrayList<>();
        User realUser = new User(user, friends);
        List<User> userList = new ArrayList<>();


        for(List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            if(!f1.equals(realUser.name) && userList.stream().noneMatch(user1 -> user1.name.equals(f1)))
                userList.add(new User(f1, friends));
            if(!f2.equals(realUser.name) && userList.stream().noneMatch(user1 -> user1.name.equals(f2)))
                userList.add(new User(f2, friends));
        }

        for(String visitor : visitors)
            if(!visitor.equals(realUser.name) && userList.stream().noneMatch(user1 -> user1.name.equals(visitor)))
                userList.add(new User(visitor, friends));

        for(User tUser : userList) tUser.setScore(realUser, visitors);

        Collections.sort(userList);

        for(int i=0; i<5; i++) {
            User tUser = userList.get(i);
            if(tUser.score != 0) answer.add(tUser.name);
        }
        return answer;
    }
}

