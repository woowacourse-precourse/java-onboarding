package onboarding;

import java.util.*;

public class Problem7 {
    static String username;
    static List<String> userFriendList;
    static Map<String, Integer> recommendList;
    static LinkedList<Map.Entry<String, Integer>> recommendEntryList;


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        username = user;
        userFriendList = makeUserFriendList(friends);
        recommendList = makeRecommendList(friends);

        addVisitorsInRecommendList(visitors);

        addScoreByFriends(friends);
        addScoreByVisitor(visitors);

        sortByScore();
        sortByName();

        answer = filterRecommendEntryList();
        return answer;
    }

    /**
     * friends의 목록중 user와 같은 리스트에 안에 포함된 유저들의 리스트 반환, friends에서는 user가 포함된 리스트 삭제
     * @param {List<List<String>>} friends
     * @return userFriendList
     */
    public static List<String> makeUserFriendList(List<List<String>> friends) {
        List<String> userFriendList = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).get(0) == username) userFriendList.add(friends.get(i).get(1));
            else if(friends.get(i).get(1) == username) userFriendList.add(friends.get(i).get(0));
        }
        return userFriendList;
    }

    /**
     * friends 목록중 user와 user 친구들을 제외한 Map 반환
     * @param {List<List<String>>}friends
     * @return recommendList
     */
    public static Map<String, Integer> makeRecommendList(List<List<String>> friends) {
        Map<String, Integer> recommendList = new LinkedHashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                if(!userFriendList.contains(name) && !name.equals(username)) recommendList.put(name, 0);
            }
        }
        return recommendList;
    }

    /**
     * visitors에 포함된 사람들중 user와 user의 친구를 제외한 사람들 recommendList에 추가
     * @param {List<String>>} visitors
     * @return recommendList
     */
    public static Map<String, Integer> addVisitorsInRecommendList(List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if(!userFriendList.contains(name) && name != username) recommendList.put(name, 0);
        }
        return recommendList;
    }

    /**
     * userFriendList에 포함된 친구와 함께 friends에서 쌍을 이루는 사람의 추천점수를 10 증가시킴
     * @param {List<List<String>>} friends
     * @return recommendList
     */
    public static Map<String, Integer> addScoreByFriends(List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String firstName = friends.get(i).get(j);
                String secondName = friends.get(i).get(1-j);

                if(userFriendList.contains(firstName) && !secondName.equals(username)) recommendList.put(secondName, recommendList.get(secondName) + 10);
            }
        }
        return recommendList;
    }

    /**
     * visitors의 목록중 userFriendList에 포함되지 않은 요소는 recommendList에서 조회하여 추천점수 1 증가시킴
     * @param {List<String>} visitors
     * @return recommendList
     */
    public static Map<String, Integer> addScoreByVisitor(List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if(!userFriendList.contains(name)) recommendList.put(name, recommendList.get(name) + 1);
        }
        return recommendList;
    }

    /**
     * recommendList를 comparator를 사용하여 추천점수가 높은순으로 정렬한 뒤 recommendEntryList를 반환합니다.
     * @return recommendEntryList
     */
    public static LinkedList<Map.Entry<String, Integer>> sortByScore() {
        recommendEntryList = new LinkedList<>(recommendList.entrySet());
        recommendEntryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return recommendEntryList;
    }

    /**
     * recommendEntryList를 comparator를 사용하여 추천점수가 같으면 이름순으로 정렬한 뒤 recommendEntryList를 반환합니다
     * @return recommendEntryList
     */
    public static LinkedList<Map.Entry<String, Integer>> sortByName() {
        recommendEntryList.sort((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
            else return 0;
        });
        return recommendEntryList;
    }

    /**
     *  입력받은 recommendEntryList가 5명을 초과하면 5명까지만 잘라 result 리스트에 넣고 반환합니다.
     * @return result
     */
    public static List<String> filterRecommendEntryList() {
        List<String> result = new ArrayList<>();
        int length = recommendEntryList.size();

        if(length <= 5) addList(result, length);
        else addList(result, 5);
        return result;
    }

    /**
     * length가 5를 초과하면 5명까지만 name을 result에 넣습니다. 단 score가 0점이면 result에 넣지 않습니다.
     * @param {LinkedList<Map.Entry<String, Integer>> recommendEntryList} recommendEntryList
     * @param {List<String>} result
     * @param {int} length
     */
    public static void addList(List<String> result, int length) {
        for (int i = 0; i < length; i++) {
            String name = recommendEntryList.get(i).getKey();
            int score = recommendEntryList.get(i).getValue();

            if(score > 0) result.add(name);
        }
    }

}
