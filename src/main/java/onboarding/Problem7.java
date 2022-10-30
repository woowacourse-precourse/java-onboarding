package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String>> connectMap;
    private static Map<String, Integer> distance;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        connectMap = new HashMap<>();
        distance = new HashMap<>();

        makeConnection(friends);
        initDistance();
        searchFriends(user);
        visitorPoint(user, visitors);

        return answer;
    }

    private static class Connect {
        String to;
        int depth;

        public Connect(String to, int depth) {
            this.to = to;
            this.depth = depth;
        }
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

    /*
     * 거리를 초기화 한다.
     * */
    private static void initDistance(){
        for (String key : connectMap.keySet()) {
            distance.put(key, 0);
        }
    }


    /*
     * 둘 사이의 공통 친구를 찾아 점수를 부여한다.
     * */
    private static void searchFriends(String user) {
        Queue<Connect> qu = new LinkedList<>();
        qu.add(new Connect(user, 0));
        distance.put(user, -1);

        while (!qu.isEmpty()) {
            Connect cn = qu.poll();
            String to = cn.to;

            if (cn.depth >= 2) continue;

            for (int i = 0; i < connectMap.get(to).size(); i++) {
                String nn = connectMap.get(to).get(i);

                if(to.equals(user)){
                    distance.put(nn, -1);
                }

                if(distance.get(to).equals(-1) && !distance.get(nn).equals(-1)) {
                    distance.put(nn, distance.getOrDefault(nn, 0) + 10);
                }

                qu.add(new Connect(nn, cn.depth + 1));
            }
        }
    }

    /*
     * user와 친구가 아닌 방문객의 점수를 더한다.
     * */
    private static void visitorPoint(String user, List<String> visitors){
        for (String visitor : visitors) {
            if(!connectMap.get(user).contains(visitor)) {
                distance.put(visitor, distance.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    /*
     * 내림차순으로 거리를 정렬한다.
     * */
    private static List<Map.Entry<String, Integer>> sortDescDistance(){
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(distance.entrySet());
        entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return entries;
    }

}
