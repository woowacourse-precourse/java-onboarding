package onboarding;

import java.util.*;

public class Problem7 {


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Sns sns = new Sns(user, friends, visitors);
        Calculator<Sns, List<String>> recommendCalculator =
                new RecommendCalculator();
        recommendCalculator.setVariable(sns);

        return recommendCalculator.calculation();
    }

    private static class Sns{
        String user;
        List<List<String>> friends;
        List<String> visitors;

        public Sns(String user, List<List<String>> friends, List<String> visitors) {
            this.user = user;
            this.friends = friends;
            this.visitors = visitors;
        }
    }

    private static class Connect {
        String to;
        int depth;

        public Connect(String to, int depth) {
            this.to = to;
            this.depth = depth;
        }
    }

    public enum Each {
        EACH_1(0), EACH_2(1);

        private int info;

        Each(int info) {
            this.info = info;
        }

        public int getInfo() {
            return info;
        }
    }

    public enum Point{
        INIT(0),
        VISITOR(1),
        DEPTH(2),
        FRIENDS(10);

        private int value;

        Point(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static class RecommendCalculator implements Calculator<Sns, List<String>>{
        private static Map<String, List<String>> connectMap;
        private static Map<String, Integer> distance;
        private static final int DEFAULT_VALUE = 0;
        private static final int VISIT = 1;
        private static final int LIMIT = 5;
        private static final int NOT_VISITED = -1;
        private String user;
        private List<List<String>> friends;
        private List<String> visitors;

        @Override
        public void setVariable(Sns sns) {
            this.user = sns.user;
            this.friends = sns.friends;
            this.visitors = sns.visitors;
        }

        @Override
        public List<String> calculation(){
            connectMap = new HashMap<>();
            distance = new HashMap<>();

            makeConnection();
            initDistance();
            searchFriends();
            visitorPoint();
            makeAnswer();

            return makeAnswer();
        }

        /*
         * 연결 관계를 Map에 저장한다.
         * */
        private void makeConnection(){
            for (List<String> friend : this.friends) {
                String f1 = friend.get(Each.EACH_1.getInfo());
                String f2 = friend.get(Each.EACH_2.getInfo());

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
        private void initDistance(){
            for (String key : connectMap.keySet()) {
                distance.put(key, 0);
            }
        }

        /*
         * 둘 사이의 공통 친구를 찾아 점수를 부여한다.
         * */
        private void searchFriends() {
            Queue<Connect> qu = new LinkedList<>();
            qu.add(new Connect(user, Point.INIT.getValue()));
            distance.put(user, NOT_VISITED);

            while (!qu.isEmpty()) {
                Connect cn = qu.poll();
                String to = cn.to;

                if (cn.depth >= Point.DEPTH.getValue()) continue;

                for (int i = 0; i < connectMap.get(to).size(); i++) {
                    String next = connectMap.get(to).get(i);

                    if(to.equals(user)){
                        distance.put(next, NOT_VISITED);
                    }

                    addCommonFriend(to, next);

                    qu.add(new Connect(next, cn.depth + VISIT));
                }
            }
        }

        /*
        * 공통 친구인 경우 점수를 더한다.
        * */
        private static void addCommonFriend(String to, String next){
            if(distance.get(to).equals(NOT_VISITED)
                    && !distance.get(next).equals(NOT_VISITED)) {
                distance.put(next, distance.getOrDefault(next, DEFAULT_VALUE)
                        + Point.FRIENDS.getValue());
            }
        }

        /*
         * user와 친구가 아닌 방문객의 점수를 더한다.
         * */
        private void visitorPoint(){
            for (String visitor : visitors) {
                addVisitorPoint(visitor);
            }
        }

        /*
        * 방문객의 점수를 더한다.
        * */
        private void addVisitorPoint(String visitor){
            if(!connectMap.get(user).contains(visitor)) {
                distance.put(visitor, distance.getOrDefault(visitor, DEFAULT_VALUE)
                        + Point.VISITOR.getValue());
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

        /*
         * 정렬된 거리 순으로 정답에 추가한다.
         * */
        private static List<String> makeAnswer(){
            List<String> result = new ArrayList<>();
            int cnt = 0;
            for (Map.Entry<String, Integer> entry : sortDescDistance()) {
                if(entry.getValue() <= 0) break;

                result.add(entry.getKey());
                cnt++;
                if(cnt>=LIMIT-1) break;
            }
            return result;
        }
    }
}
