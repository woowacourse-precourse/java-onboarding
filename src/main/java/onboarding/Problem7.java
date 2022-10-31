package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    static HashMap<String, List<String>> friendList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();
        return answer;
    }

    //각 아이디의 친구인 관계를 저장
    static void saveFriendById(String idA, String idB) {

        if (friendList.get(idA) == null) {
            ArrayList<String> list = new ArrayList<>();
            list.add(idB);
            friendList.put(idA, list);

        } else {
            friendList.get(idA).add(idB);
        }
        if (friendList.get(idB) == null) {
            ArrayList<String> list = new ArrayList<>();
            list.add(idA);
            friendList.put(idB, list);

        } else {
            friendList.get(idB).add(idA);
        }

        System.out.println(friendList.toString());
    }

    //사용자와 함께 아는 친구의 수의 점수 저장
    static void saveFriendScoreByUser(String user) {

    }

    //방문한 횟수의 점수 저장
    static void saveVisitScore(String id) {

    }
}
