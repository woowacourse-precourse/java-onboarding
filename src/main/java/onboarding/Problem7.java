package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        System.out.println(friends);
        ArrayList<String> exFriends = new ArrayList<String>();

        for (int k=0;friends.size()>k;k++){
            if(Objects.equals(friends.get(k).get(0), user)) {
                exFriends.add(friends.get(k).get(1));
            }
            else if(Objects.equals(friends.get(k).get(1), user)) {
                exFriends.add(friends.get(k).get(0));
            }
        }

        System.out.println("기존친구"+exFriends);
///친구목록에서 이미 user와 친구를 exFriends로 분리///

        ArrayList<String> scoreTen = new ArrayList<String>();

        for (int s=0;friends.size()>s;s++){
            for (int k=0;exFriends.size()>k;k++){
                if(Objects.equals(friends.get(s).get(0), exFriends.get(k)) || Objects.equals(friends.get(s).get(1), exFriends.get(k))){
                    scoreTen.add(friends.get(s).get(0));
                    scoreTen.add(friends.get(s).get(1));
                }
            }
        }
        System.out.println("10점리스트"+scoreTen);
//// exFriends의 친구, 10점을 받아야하는 리스트를 scoreTen으로 출력




        List<String> answer = Collections.emptyList();
        return answer;
    }
}
