package onboarding;

import java.awt.image.ImageProducer;
import java.util.*;

public class Problem7 {
    static String user = "mrko";
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        user = user;
        return answer;
    }

    /**
     * friends의 목록중 user와 같은 리스트에 안에 포함된 유저들의 리스트 반환, friends에서는 user가 포함된 리스트 삭제
     * @param {List<List<String>>} friends
     * @param {String} user
     * @return userFriendList
     */
    public static List<String> makeUserFriendList(List<List<String>> friends) {
        List<String> userFriendList = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).get(0) == user) userFriendList.add(friends.get(i).get(1));
            else if(friends.get(i).get(1) == user) userFriendList.add(friends.get(i).get(0));
        }
        return userFriendList;
    }

    /**
     * friends 목록중 user와 user 친구들을 제외한 Map 반환
     * @param {List<List<String>>}friends
     * @param {List<String>>}userFriendList
     * @return recommendList
     */
    public static Map<String, Integer> makeRecommendList(List<List<String>> friends, List<String> userFriendList) {
        Map<String, Integer> recommendList = new LinkedHashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                if(!userFriendList.contains(name) && !name.equals(user)) recommendList.put(name, 0);
            }
        }
        return recommendList;
    }

    /**
     * visitors에 포함된 사람들중 user와 user의 친구를 제외한 사람들 recommendList에 추가
     * @param {List<String>>} visitors
     * @param {List<String>>} userFriendList
     * @param {Map<String, Integer>}recommendList
     * @return recommendList
     */
    public static Map<String, Integer> updateRecommendList(List<String> visitors, List<String> userFriendList ,Map<String, Integer> recommendList) {
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if(!userFriendList.contains(name) && name != user) recommendList.put(name, 0);
        }
        return recommendList;
    }

    /**
     * userFriendList에 포함된 친구와 함께 friends에서 쌍을 이루는 사람의 추천점수를 10 증가시킴
     * @param {List<List<String>>} friends
     * @param {List<String>} userFriendList
     * @param {Map<String, Integer>}recommendList
     * @return
     */
    public static Map<String, Integer> addScoreByFriends(List<List<String>> friends, List<String> userFriendList ,Map<String, Integer> recommendList) {
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String firstName = friends.get(i).get(j);
                String secondName = friends.get(i).get(1-j);

                if(userFriendList.contains(firstName) && !secondName.equals(user)) recommendList.put(secondName, recommendList.get(secondName) + 10);
            }
        }
        return recommendList;
    }

    /**
     * visitors의 목록중 userFriendList에 포함되지 않은 요소는 recommendList에서 조회하여 추천점수 1 증가시킴
     * @param {List<String>} visitors
     * @param {List<String>} userFriendList
     * @param {Map<String, Integer>} recommendList
     * @return recommendList
     */
    public static Map<String, Integer> addScoreByVisitor(List<String> visitors, List<String> userFriendList,Map<String, Integer> recommendList) {
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if(!userFriendList.contains(name)) recommendList.put(name, recommendList.get(name) + 1);
        }
        return recommendList;
    }


}
