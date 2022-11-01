package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {
    public String name;
    public List<String> friends = new ArrayList<>();
    public List<String> visitors = new ArrayList<>();
    public int score;

    public User(String name) {
        this.name = name;
    }

    public int getScore(User target) {
        this.score = 0;
        for(String targetfname : target.friends ) {
            if(this.friends.contains(targetfname)) this.score += 10;
        }
        for(String targetvname : target.visitors ) {
            if(targetvname == this.name) this.score++;
        }
        return this.score;
    }
}

public class Problem7 {
    public static List<User> users = new ArrayList<>();

    public static int findUser(String name) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).name == name) {
                return i;
            }
        }
        return -1;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<User> tmpans = new ArrayList<>();
        users.add(new User(user));

        User u1, u2;
        for(List<String> fpair : friends) {
            if(findUser(fpair.get(0)) == -1) users.add(new User(fpair.get(0)));
            if(findUser(fpair.get(1)) == -1) users.add(new User(fpair.get(1)));
            u1 = users.get(findUser(fpair.get(0)));
            u2 = users.get(findUser(fpair.get(1)));
            u1.friends.add(u2.name);
            u2.friends.add(u1.name);
        }

        u1 = users.get(0);
        for(String vname : visitors) {
            if(findUser(vname) == -1) users.add(new User(vname));
            u1.visitors.add(vname);
        }

        for(User u : users) {
            if(u != u1 && !u1.friends.contains(u.name) && u.getScore(u1) != 0) tmpans.add(u); // 자기 자신이거나 이미 친구인 경우, 점수가 0인 경우 제외
        }

        tmpans.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if(o1.score < o2.score) return 1;
                else if(o1.score > o2.score) return -1;
                else return o1.name.compareTo(o2.name);
            }
        });

        for(int i = 0; i < 5 && i < tmpans.size(); i++) {
            answer.add(tmpans.get(i).name);
        }
        return answer;
    }
}
