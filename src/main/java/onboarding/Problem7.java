package onboarding;

import java.util.*;
import java.util.function.Predicate;

public class Problem7 {

    //유저 정보를 다루는 클래스 자료형
    static class userInfo implements Comparable<userInfo> {
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

        public void plusPoint() {
            this.point++;
        }

        //회원 정보를 저장.
        public void addFriends(String friendsName) {
            friends.add(friendsName);
        }

        public userInfo(String name, String friend) {
            this.name = name;
            friends = new HashSet<>();
            friends.add(friend);
            point = 0;
        }

        @Override
        public String toString() {
            return name + "::" + point + "::" + friends;
        }


        @Override
        public int compareTo(userInfo o) {
            if (Integer.compare(o.point, this.point) == 0) {
                return this.name.compareTo(o.name);
            }
            return Integer.compare(o.point, this.point);
        }
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, userInfo> users = new HashMap<>();

        //유저별 친구를 클래스 자료형으로 생성..
        for (List<String> list : friends) {
            String nameA = list.get(0);
            String nameB = list.get(1);
            // Map<String,userInfo> infos = getNames(users);

            //없을 경우 객체 생성.
            if (!users.containsKey(nameA)) users.put(nameA, new userInfo(nameA, nameB));
            else users.get(nameA).addFriends(nameB);
            if (!users.containsKey(nameB)) users.put(nameB, new userInfo(nameB, nameA));
            else users.get(nameB).addFriends(nameA);
        }

        //다 만들어진 자료형에서 사용자의 이름과 다른 사용자들의 친구를 바교해 점수를 증가 한다.

        // myFreinds 비교해야되는 친구 목록을 추출
        Set<String> myFreinds = users.get(user).getFriends();

        //같은 친구가 있는지 확인.
        for (String key : users.keySet()) {
            //나 일 경우에는 제외
            if (key.equals(user)) continue;

            //나 이외의 사용자들의 친구 목록들을 꺼낸다. 두 리스트중 동일한 값이 있는지 확인.
            Set<String> friendsList = users.get(key).getFriends();
            int point = matchsName(myFreinds, friendsList);
            users.get(key).setPoint(point);
        }

        //이제 조회한 사람들을 반복해 확인
        for (String s : visitors) {
            if (!users.containsKey(s)) {
                users.put(s, new userInfo(s, ""));
                users.get(s).plusPoint();
            }
        }

        //마지막으로 포인트가 1 이상인 사람들만 answer에 저장한다.
        //이 때 정렬이 필요하다


        //배열을 정렬한다.
        // 1.포인트 순으로
        // 1.2 이름순으로

        List<String> keySet = new ArrayList<>(users.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return users.get(o1).compareTo(users.get(o2));
            }
        });

        //0포인트 이상인 유저를 저장
        for (String key : keySet) {
            int point = users.get(key).getPoint();
            if (point > 0) {
                answer.add(users.get(key).getName());
            }
        }
        return answer;
    }

    //두 친구 목록들을 비교해 점수를 저장하는 기능
    public static int matchsName(Set<String> myFreinds, Set<String> friendsList) {

        long point = 0;

        long result = myFreinds.stream()
                .filter(old -> friendsList.stream()
                        .anyMatch(Predicate.isEqual(old))).count();

        point = result * 10;

        return (int) point;
    }
}
