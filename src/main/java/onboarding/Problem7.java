package onboarding;

import java.util.*;

public class Problem7 {

    private static HashSet<String> friendsList;
    private static HashSet<String> notFriendsList;
    private static Map<String, Integer> recommend;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsList = new HashSet<>();
        notFriendsList = new HashSet<>();
        recommend = new HashMap<>();

        //모든 사람 리스트
        HashSet<String> allList = new HashSet<>();

        //모든 사람 리스트와 친구리스트 생성
        for(int i = 0 ; i < friends.size(); i++) {
            //주어진 friends의 전체를 모든사람 리스트에 중복없이 추가하는 기능
            allList.add(friends.get(i).get(0));
            allList.add(friends.get(i).get(1));

            //주어진 friends의 전체 중 사용자의 친구들만 중복없이 추가하는 기능
            if (friends.get(i).get(0).contains(user) || friends.get(i).get(1).contains(user)) {
                friendsList.add(friends.get(i).get(0));
                friendsList.add(friends.get(i).get(1));
            }
        }


        //5개이하만 출력하기 위한 정답List
        List<String> answer = new ArrayList<>();

        return answer;
    }

}
