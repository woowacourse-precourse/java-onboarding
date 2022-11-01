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

    public void scoreAdd(int score) {
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }


    public void setFriendList(String friendName) {//클래스에 넣기
        this.friendList.add(friendName);
    }
}

public class Problem7 {
    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static final HashMap<String, User> hashMap = new HashMap<>(); //이름과 그 이름에 해당하는 클래스 보관

    //1. 친구 맺기
    public static void makeUserClass(String name) {
        if (!hashMap.containsKey(name)) { //class hashmap에 없을 경우 클래스 먼저 만듦
            User user = new User(name);
            hashMap.put(name, user);
        }
    }

    public static void makeFriend(List<List<String>> friends) { //친구 맺기
        for (int i = 0; i < friends.size(); i++) {
            //i번째 node의 각 원소 이름 및 클래스 없을 경우 생성
            String left = friends.get(i).get(0);
            String right = friends.get(i).get(1);
            makeUserClass(left);
            makeUserClass(right);

            //i번째 node의 각 원소에 대한 클래스 가져오기
            User first = hashMap.get(left); //i번째 node의 첫 번째 원소
            User second = hashMap.get(right); //i번째 node의 두 번째 원소

            //User 멤버변수 friendList에 없는 String(name)일 경우 추가하기
            if (!first.getFriendList().contains(right))
                first.setFriendList(right);
            if (!second.getFriendList().contains(left))
                second.setFriendList(left);
        }
    }

    public static void friendScore(String name) {
        User user = hashMap.get(name); //user 클래스 가져오기
        for (int i = 0; i < user.getFriendList().size(); i++) {
            User friendUser = hashMap.get(user.getFriendList().get(i));
            for (int j = 0; j < friendUser.getFriendList().size(); j++) {
                String newFriendName = friendUser.getFriendList().get(j);

                //friendUser의 친구가 user 친구 목록에도 없는 친구라면 점수 추가
                if (!user.getFriendList().contains(newFriendName) && newFriendName != name) {
                    User newFriend = hashMap.get(newFriendName);
                    newFriend.scoreAdd(FRIEND_SCORE);
                }
            }
        }
    }
    public static void visitorScore(List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            User user = hashMap.get(visitors.get(i));
            user.scoreAdd(VISITOR_SCORE);
        }
    }
    public static void scoreManage(String user, List<String> visitors) {
        friendScore(user);
        visitorScore(visitors);
    }

    public static List<String> score() {
        List<String> answer = new ArrayList<>();
        HashMap<Integer, String> scoreList = new HashMap<>();

        for (Map.Entry<String, User> entry : hashMap.entrySet()) {
            User user = entry.getValue();
            scoreList.put(user.getScore(), user.getName());
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        Object[] mapKey = scoreList.keySet().toArray();
        Arrays.sort(mapKey);

        for (int i = 0; i < 5; i++) {
            
        }

        return answer;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //1. 친구 맺기
        makeFriend(friends);

        //2. scoreManage - 추천 점수 매기기
        scoreManage(user, visitors);

        //3. 추천 점수 상위 5명 담긴 리스트 리턴받기
        score();

        return answer;
    }
}
