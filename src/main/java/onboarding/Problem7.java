package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, User> userMap = new HashMap<>();
        userMap.put(user, new User(user));
        List<String> answer = new ArrayList<>();
        List<User> users = new ArrayList<>();


        for (int i = 0; i < friends.size(); i++) {
            if (userMap.containsKey(friends.get(i).get(0))) { //0번 객체가 map에 있음
                if (userMap.containsKey((friends.get(i).get(1)))) {//1번 객체가 map에 있음
                    userMap.get(friends.get(i).get(0)).addFriend(userMap.get(friends.get(i).get(1)));
                    userMap.get(friends.get(i).get(1)).addFriend(userMap.get(friends.get(i).get(0)));
                } else { //1번 객체가 없음
                    userMap.put(friends.get(i).get(1), new User(friends.get(i).get(1)));
                    userMap.get(friends.get(i).get(0)).addFriend(userMap.get(friends.get(i).get(1)));
                    userMap.get(friends.get(i).get(1)).addFriend(userMap.get(friends.get(i).get(0)));
                }
            } else { //0번 객체가 없음
                if (userMap.containsKey(friends.get(i).get(1))) {//0번 객체는 없고 1번 객체는 있음;
                    userMap.put(friends.get(i).get(0), new User(friends.get(i).get(0)));
                    userMap.get(friends.get(i).get(0)).addFriend(userMap.get(friends.get(i).get(1)));
                    userMap.get(friends.get(i).get(1)).addFriend(userMap.get(friends.get(i).get(0)));
                } else {//0번객체도 없고 1번 객체도 없는경우
                    userMap.put(friends.get(i).get(0), new User(friends.get(i).get(0)));
                    userMap.put(friends.get(i).get(1), new User(friends.get(i).get(1)));
                    userMap.get(friends.get(i).get(0)).addFriend(userMap.get(friends.get(i).get(1)));
                    userMap.get(friends.get(i).get(1)).addFriend(userMap.get(friends.get(i).get(0)));
                }
            }
            for (String str : visitors) {
                if (userMap.containsKey(str)) { // 유저맵에 들어오는 키가 있음
                    userMap.get(str).add1Point();
                    List<User> friendUser = userMap.get(str).getFriendList();
                    for (int j = 0; j < friendUser.size(); j++) {
                        friendUser.get(j).add10Point();
                    }
                } else { // 유저맵에 들어오는 키가 없음
                    userMap.put(str, new User(str));
                    userMap.get(str).add1Point();
                }
            }
        }


        for (String key : userMap.keySet()) { //유저의 키를 꺼내서 리스트에 add하기
            users.add(userMap.get(key));
        }
        Collections.sort(users);

        for (User user1 : users) {
            if (answer.size() < 6) {
                if (!user1.getUserName().equals(user) && !userMap.get(user).getFriendList().contains(user1) &&
                        user1.getPoint() != 0) {

                    answer.add(user1.getUserName());
                }
            }
        }
        return answer;
    }
}


class User implements Comparable {

    @Override
    public int compareTo(Object o) {
        User u = (User) o;
        if (this.getPoint() > u.getPoint()) {
            return -1;
        } else if (this.getPoint() == u.getPoint()) {
            return this.getUserName().compareTo(u.getUserName());
        } else {
            return 1;
        }
    }

    public User(String userName) {
        this.userName = userName;
    }

    private String userName;
    private int point = 0;
    private List<User> friendList = new ArrayList<>();

    public List<User> getFriendList() {
        return friendList;
    }

    public String getUserName() {
        return userName;
    }

    public int getPoint() {
        return point;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public void addFriend(User user) {
        friendList.add(user);
    }

    public void add1Point() {
        point++;
    }

    public void add10Point() {
        point += 10;
    }


}
