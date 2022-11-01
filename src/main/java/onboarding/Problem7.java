package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        //최대 5명까지 점수 높은 순으로 정렬하여 리턴
        //점수가 0이면 추천하지 않음
        //점수가 같으면 이름 순으로 정렬
        List<String> userFriends = getUserFriends(user, friends);

        return answer;
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> relation : friends) {

            if (relation.get(0).equals(user)) {
                userFriends.add(relation.get(1));
            }

            if (relation.get(1).equals(user)) {
                userFriends.add((relation.get(0)));
            }

        }

        return userFriends;
    }

}
