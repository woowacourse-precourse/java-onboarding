package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String>> connectMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        connectMap = new HashMap<>();

        makeConnection(friends);

        return answer;
    }

    /*
    * 연결 관계를 Map에 저장한다.
    * */
    private static void makeConnection(List<List<String>> friends){
        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);

            List<String> con = connectMap.getOrDefault(f1, new ArrayList<>());
            con.add(f2);
            connectMap.put(f1, con);

            con = connectMap.getOrDefault(f2, new ArrayList<>());
            con.add(f1);
            connectMap.put(f2, con);
        }
    }
}
