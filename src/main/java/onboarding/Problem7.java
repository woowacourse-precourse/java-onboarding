package onboarding;


import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> friendMember = new ArrayList<>();
        HashMap<String,Integer> friendScore = new HashMap<>();


        friendMember = friendList(user, friendMember, friends);

        return answer;
    }

    private static List friendList(String user, List<String> friendMember, List<List<String>> friends){
        for(int i=0; i<friends.size(); i++) {
            if (user.equals(friends.get(i).get(0))) {
                friendMember.add(friends.get(i).get(1));
            } else if (user.equals(friends.get(i).get(1))) {
                friendMember.add(friends.get(i).get(0));
            }
        }
        return friendMember;
    }

}
