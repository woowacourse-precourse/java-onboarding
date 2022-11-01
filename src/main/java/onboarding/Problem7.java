package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> F_F_sub = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) { // 친구 구하기 F_F_sub
            if (user.equals(friends.get(i).get(0))) {
                F_F_sub.add(friends.get(i).get(1));
            }
            if (user.equals(friends.get(i).get(1))) {
                F_F_sub.add(friends.get(i).get(0));
            }
        }
        List<String> F_F = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) { // 함께 아는 친구 구하기
            for (int j = 0; j < F_F_sub.size(); j++) {
                if (F_F_sub.get(j).equals(friends.get(i).get(0))) {

                    F_F.add(friends.get(i).get(1));

                    if (F_F_sub.get(j).equals(friends.get(i).get(1))) {

                        F_F.add(friends.get(i).get(0));
                    }
                }
            }
        }
        Set<String> set = new HashSet<String>(F_F);
        List<String> FF = new ArrayList<String>(set); // 중복제거

        FF.remove(user); // 본인제거
        HashMap<String, Integer> map = new HashMap<>();
        for (int q = 0; q < FF.size(); q++) { // 10점 친구들 추가
            map.put(FF.get(q), 10);
        }
        for (int w = 0; w < visitors.size(); w++) { // 1점 친구들 추가
            if (map.containsKey(visitors.get(w)) == false) { // 리스트에 이름이 없다면 추가
                map.put(visitors.get(w), 1);
            } else if (map.containsKey(visitors.get(w)) == true) { // 리스트에 이름이 있으면 1점 추가
                map.replace(visitors.get(w), map.get(visitors.get(w)) + 1);
            }
        }
        for (int z = 0; z < F_F_sub.size(); z++) { // USER와 친구 제거
            map.remove(F_F_sub.get(z));
        }
        

        answer = List.copyOf(map.keySet());
        return answer;
    }

    public static void main(String[] args) {
        String USER = "mrko";
        List<String> VISITOR = new ArrayList<>();
        VISITOR.add("bedi");
        VISITOR.add("bedi");
        VISITOR.add("donut");
        VISITOR.add("bedi");
        VISITOR.add("shakevan");
        List<List<String>> FRIENDS = Arrays.asList(
                Arrays.asList("donut", "andole"),
                Arrays.asList("donut", "jun"),
                Arrays.asList("donut", "mrko"),
                Arrays.asList("shakevan", "andole"),
                Arrays.asList("shakevan", "jun"),
                Arrays.asList("shakevan", "mrko"));

        System.out.println(solution(USER, FRIENDS, VISITOR));
    }
}
