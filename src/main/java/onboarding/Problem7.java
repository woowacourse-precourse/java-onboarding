package onboarding;

import java.util.*;

/**
 * 변수 선언
 *      - allUser     : 모든 user set
 *      - friendSet   : user의 friend set
 *      - recommScore : 친구 추천목록의 점수를 저장할 hash map
 *      - noFriend    : 모든 user목록 에서 user의 친구가 아닌 사람들 set
 *      - frFrineds   : 친구들의 친구들을 저장하는 List
 * 변수 초기화
 *      - friendSet 변수 초기화 : getFriendSet() 함수 사용
 *      - allUser 변수 초기화 : 입력받은 friends List 를 순회하며 set에 추가
 *      - noFriend 변수 초기화 : allUser set 에서 user 본인과 friendSet 을 remove 함수와 removeAll 함수로 제거
 *      - frFriends 변수 초기화 : friendSet 을 순회하며 친구들의 친구들을 frFriends에 모두 저장
 * 기능 목록
 * 1. getFriendSet(List<List<String>> friends, String user)
 *      - @param String user 에 해당하는 사람의 친구들 set 을 반환
 * 2. addRecommScore(HashMap<String,Integer> recommScore,int addNum, String name)
 *      - recommScore 에 name 에 해당하는 사람을 addNum 만큼 더한다.
 * 3. 친구의 친구들 frFriends 를 순회하며 이 중 noFriend set 에 있는 사람의 score 를 recommScore 에 10 더한다
 * 4. visitors 들을 순회하며 visitor 가 친구가 아닌경우 recommScore 에 1점을 더한다
 * 5. ArrayList<String> sortingSet(HashMap<java.lang.String,Integer> recommScore)
 *      - 입력받은 hash map 의 key 를 value 기준 내림차순으로 5개까지 list로 반환한다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 변수 선언
        List<String> answer;
        Set<String> allUser = new HashSet<>();
        HashSet<String> friendSet = getFriendSet(friends,user);
        HashMap<String,Integer> recommScore = new HashMap<>();
        Set<String> noFriend;
        List<String> FrFriends;

        //변수 초기화
        for (List<String> friend : friends) {
            allUser.add(friend.get(0));
            allUser.add(friend.get(1));
        }

        noFriend =  new HashSet<>(allUser);
        noFriend.removeAll(friendSet);
        noFriend.remove(user);

        FrFriends = new ArrayList<String>();
        for (String name : friendSet) {
            FrFriends.addAll(getFriendSet(friends, name));
        }

        // 3. 친구의 친구들 frFriends 를 순회하며 이 중 noFriend set 에 있는 사람의 score 를 recommScore 에 10 더한다
        for (String name : FrFriends) {
            if(noFriend.contains(name)){
                addRecommScore(recommScore,10, name);
            }
        }

        // 4. visitors 들을 순회하며 visitor 가 친구가 아닌경우 recommScore 에 1점을 더한다
        for (String name : visitors) {
            if(!friendSet.contains(name)){
                addRecommScore(recommScore,1, name);
            }
        }

        // recommScore
        answer = sortingMap(recommScore);

        return answer;
    }

//  1. getFriendSet(List<List<String>> friends, String user)
//     - @param String user 에 해당하는 사람의 친구들 set 을 반환
    private static HashSet<String> getFriendSet(List<List<String>> friends, String user){
        HashSet<String> friendSet = new HashSet<>();

        for(int i=0; i<friends.size() ; i++){
            if(friends.get(i).get(0).equals(user)){
                friendSet.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                friendSet.add(friends.get(i).get(0));
            }
        }

        return friendSet;
    }

//  2. addRecommScore(HashMap<String,Integer> recommScore,int addNum, String name)
//     - recommScore 에 name 에 해당하는 사람을 addNum 만큼 더한다.
    private static void addRecommScore(HashMap<String,Integer> recommScore,int addNum, String name){
        if (recommScore.containsKey(name)) {
            int oldVal = recommScore.get(name);
            recommScore.replace(name, oldVal + addNum);
        } else {
            recommScore.put(name, addNum);
        }
    }

        return answer;
    }
}
