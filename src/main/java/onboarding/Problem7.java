package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
    // 점수 계산기
    public static HashMap<String, Integer> scoreCal(List<String> justList, int score) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (int i = 0; i < justList.size(); i++) {
            Integer count = result.get(justList.get(i));
            if (count == null) result.put(justList.get(i), score);
            else result.put(justList.get(i), count + score);
        }
        return result;
    }
    //user의 친구 구하기
    public static Set<String> trueFriends(String user, List<List<String>> friends) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < friends.size(); i++) {

            if (user.equals(friends.get(i).get(0))) {
                result.add(friends.get(i).get(1));
            }
            if (user.equals(friends.get(i).get(1))) {
                result.add(friends.get(i).get(0));
            }
        }
        System.out.println(result);
        return result;
    }

}
