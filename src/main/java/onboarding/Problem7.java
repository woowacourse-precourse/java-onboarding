package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/*
0. friends 를 순회하면서 친구점수 리스트를 만듦(중복x) [name, score] + user_info 클래스 정의
1. friends 리스트를 순회하면서 user, user와 이미 친구인 사람은 추천목록에서 제외(친구제외 리스트에 추가, 친구 점수 리스트에는 점수를 -1점으로 설정)
2. user와 함께 아는사이(친구제외 리스트에 있는 사람) 과 친구이면 + 10
3. visitors에 들어있는 횟수만큼 + 1
4. 람다식을 이용하여 friends 리스트를 점수 내림차순, 이름 오름차순 정렬 후 answer 리스트에 추가(점수가 -1은 추가하지 앟는다)
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        HashMap<String, Integer> friends_score = makeFriendsScore(friends);
        List<String> exception_list = makeFriendsException(user, friends);
        initFriendsScore(friends_score, exception_list, user);
        setScore(friends, friends_score, exception_list, user);
        return answer;
    }
    public static HashMap<String, Integer> makeFriendsScore(List<List<String>> friends) {
        List<String> name_list = new ArrayList<String>();
        HashMap<String, Integer> friends_score = new HashMap<String, Integer>();
        for (List<String> friend : friends) {
            for (String name : friend) {
                if (!name_list.contains(name))
                    name_list.add(name);
            }
        }
        for (String name : name_list) {
            friends_score.put(name, 0);
        }
        return friends_score;
    }
    public static List<String> makeFriendsException(String user, List<List<String>> friends) {
        List<String> exception_list = new ArrayList<String>();
        for (List<String> friend_relation : friends) {
            if (friend_relation.contains(user)) {
                // user와 친구관계이면 제외리스트에 추가
                for (String friend : friend_relation) {
                    if (friend != user)
                        exception_list.add(friend);
                }
            }
        }
        return exception_list;
    }
    public static void initFriendsScore(HashMap<String, Integer> friends_score, List<String> exception_list, String user) {
        for (String name : exception_list) {
            friends_score.put(name, -1);
        }
        friends_score.put(user, -1); // 유저 자신도 추천하면 안됨
    }
    public static void setScore(List<List<String>> friends, HashMap<String, Integer> friends_score, List<String> exception_list, String user) {

    }
}
