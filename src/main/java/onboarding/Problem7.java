package onboarding;

import java.util.*;

public class Problem7 {

    // SNS의 친구 추천 알고리즘을 구현 하고 싶다.

    // 사용자가 함께 아는 친구의 수 == 10점
    // 사용자의 타임라인에 방문한 횟수 == 1점
    /*
     * 사용자 아이디 user와 친구 관계 정보 friends,
     * 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
     *
     * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여
     * 최대 5명을 return 하도록 solution 메서드를 완성하라.
     * 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
     */

    //유저 정보를 다루는 클래스 자료형
    static class userInfo {
        //유저의 이름을 저장
        private String name;
        //유저의 친구관계들을 저장
        private Set<String> friends;
        //유저의 점수를 저장
        private int point;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<String> getFriends() {
            return friends;
        }

        public void setFriends(Set<String> friends) {
            this.friends = friends;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        //회원 정보를 저장.
        public void addFriends(String friendsName){
            friends.add(friendsName);
        }

        public userInfo(String name,String friend) {
            this.name = name;
            friends = new HashSet<>();
            friends.add(friend);
            point = 0;
        }

        @Override
        public String toString() {
            return   name +"::"+ friends;
//                    ", point=" + point +
//                    '}';
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /*
        andole  [donut , shakevan]
        jun     [donut,  shakevan]
        mrko    [donut,  shakevan]

        "bedi : ["bedi", "bedi", "bedi"] 방문을 3번 == 3점
        */

        List<String> answer = Collections.emptyList();
        List<userInfo> users = new LinkedList<>();

        //유저별 친구를 클래스 정보로 생성..
        for(List<String> list : friends){
            String nameA = list.get(0);
            String nameB = list.get(1);
            Map<String,userInfo> infos = getNames(users);

            //없을 경우 객체 생성.
            if(! infos.keySet().contains(nameA)) users.add(new userInfo(nameA,nameB));
            else  infos.get(nameA).addFriends(nameB);
            if(! infos.keySet().contains(nameB)) users.add(new userInfo(nameB,nameA));
            else  infos.get(nameB).addFriends(nameA);

        }

        for(userInfo s : users) System.out.println(s);

//        System.out.println("user = " + user);
//        System.out.println("friends = " + friends);
//        System.out.println("visitors = " + visitors);
        return answer;
    }

    //클래스 리스트에서 이름만 추출해 반환하는 메서드.
    private static Map<String,userInfo> getNames(List<userInfo> users) {
        Map<String,userInfo> names = new HashMap<>();
        for(userInfo u : users) names.put(u.getName(),u);
        return names;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        List<String> result = List.of("andole", "jun", "bedi");

        solution(user, friends, visitors);
    }
}
