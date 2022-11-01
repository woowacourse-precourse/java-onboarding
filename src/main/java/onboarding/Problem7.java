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
    public List<String> getFriendList() {
        return this.friendList;
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

    public static void makeFriend(List<List<String>> friendList) { //친구 맺기
        for (int i = 0; i < friendList.size(); i++) {

            //i번째 node의 각 원소에 대한 클래스 가져오기
            User first = findClass(friendList.get(i).get(0)); //i번째 node의 첫 번째 원소
            User second = findClass(friendList.get(i).get(1)); //i번째 node의 두 번째 원소

            //User 멤버변수 classFriend에 없는 String(name)일 경우 추가하기
            if (!first.getFriendList().contains(second.getName()))
                first.classFriend(second.getName());
            if (!second.getFriendList().contains(first.getName()))
                second.classFriend(first.getName());
        }
    }

    public static void friendScore() {
        
    }
    public static void visitorScore() {

    }
    public static List<Integer> scoreManage() {

        friendScore();
        visitorScore();
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //1. 친구 맺기
        makeFriend(friends);

        //2. scoreManage - 추천 점수 매기기

        //3. 추천 점수 상위 5명 담긴 리스트 리턴받기

        return answer;
    }
}
