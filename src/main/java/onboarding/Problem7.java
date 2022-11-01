package onboarding;

import java.util.*;

class User {
    private String name;
    private int score;
    private List<String> friendList; //친구 목록

    User(String name) {
        this.name = name;
        this.score = 0;
        this.friendList = new ArrayList<String>();
    }

    public String getName() {
        return this.name;
    }

    public void classFriend(String friendName) {//클래스에 넣기
        this.friendList.add(friendName);
    }
}

public class Problem7 {
    public static final HashMap<String, User> classList = new HashMap<>(); //이름과 그 이름에 해당하는 클래스 보관
    public static void makeClass(String name) {
        if (!classList.containsKey(name)) { //class hashmap에 없을 경우 클래스 먼저 만듦
            User user = new User(name);
            classList.put(name, user);
        }
    }

    public static User findClass(String name) {
        return classList.get(name); //User 클래스 리턴
    }

    public static void makeFriend(List<List<String>> friendList) { //친구 목록에 추가하기
        for (int i = 0; i < friendList.size(); i++) {
/*            //클래스 만들기, 멤버변수 Hashmap에 상대방 저장

            User first = findClass(friendList.get(i).get(0)); //i번째 node의 첫 번째 원소
            User second = findClass(friendList.get(i).get(1)); //i번째 node의 두 번째 원소

            //친구 추가하기
            first.classFriend(second.getName());*/
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        makeFriend(friends);


        return answer;
    }
}
