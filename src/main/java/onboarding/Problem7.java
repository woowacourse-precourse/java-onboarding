package onboarding;

import java.util.*;

/** 구현해야할 기능
 *  구조체 설계 User(이름, 친구 list)
 *  User 생성하기 (매개변수 : String 이름)
 *  User 친구 추가
 *  유저 기준으로 친구 탐색 후 점수 설정(이미 친구인 경우 0, 친구의 친구 10, 방문자 1 * n, 친구이면서 방문자 10 + 1 * n)
 *  탐색을 하기 위해 해시맵 사용 <String, User>
 *  점수를 저장하기 위한 arrayList 필요
 */
public class Problem7 {

    static Map<String, User> userMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        createUser(user);


        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void createUser(String userName){
        if(userMap.containsKey(userName))
            return;
        
        User user = new User();
        user.name = userName;
        userMap.put(userName, user);
    }
    public void addFriend(String friendName) {

    }

    public void calcScore(String userName) {
        //TODO : 점수를 계산하기 위해서는 유저 이름과 스코어를 저장할 수 있는 자료구조가 필요하다.
    }
    public static class User {
        String name;
        ArrayList<String> friends = new ArrayList<>();
    }
}
