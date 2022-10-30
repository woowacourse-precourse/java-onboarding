package onboarding;

import java.util.*;

public class Problem7 {
    // 아이디와 추천 점수를 매핑한 자료
    static Map<String, Integer> answerMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriendList = getUserFriendList(user, friends);

        getFriendScore(user, userFriendList, friends);
        getVisitScore(userFriendList, visitors);

        List<String> answerList = new ArrayList<>(answerMap.keySet());

        return sortAndResize(answerList);
    }

    /**
     * 사용자와 함께 아는 친구의 수당, 10점을 얻는 알고리즘.
     * 결과는 answerMap에 저장된다.
     * @param user
     * @param userFriendList
     * @param friends
     */
    private static void getFriendScore(String user, List<String> userFriendList, List<List<String>> friends) {
        for(int i=0;i<userFriendList.size();i++){
            String friend = userFriendList.get(i);
            // 친구 관계 정보에 대해서 반복
            for(int j=0;j<friends.size();j++){
                List<String> relation = friends.get(j);
                //if(isUserFriend)
                if(relation.contains(user))
                    continue;
                // 해당 friend가 현재 relation에 속해있는지 확인
                if(!relation.contains(friend)) {
                    continue;
                }

                String recommend = null;
                // index 0에 friend가 있으면 1에 있는 원소를 저장
                if(relation.get(0).equals(friend))
                    recommend = relation.get(1);
                else
                    recommend = relation.get(0);

                // 이미 존재하는 원소라면 +10
                if(answerMap.containsKey(recommend))
                    answerMap.replace(recommend, answerMap.get(recommend) + 10);
                else
                    answerMap.put(recommend, 10);
            }
        }
    }

    /**
     * 사용자와 타임 라인에 방문한 횟수당, 1점을 얻는 알고리즘.
     * 결과는 answerMap에 저장된다.
     * @param userFriendList
     * @param visitors
     */
    private static void getVisitScore(List<String> userFriendList, List<String> visitors) {
        for (String visitor: visitors){
            if(userFriendList.contains(visitor))
                continue;

            if(answerMap.containsKey(visitor))
                answerMap.replace(visitor, answerMap.get(visitor) + 1);
            else
                answerMap.put(visitor, 1);
        }
    }

    /**
     * 점수가 높은 순으로 + 이름순으로 정렬시키는 알고리즘
     * @param answerList
     * @return List: 정렬된 리스트
     */
    private static List<String> sortAndResize(List<String> answerList){
        answerList.sort((o1, o2) -> {
            if (answerMap.get(o1) > answerMap.get(o2))
                return -1;
            else if (answerMap.get(o1) < answerMap.get(o2))
                return 1;
            else {
                if (o1.compareTo(o2) < 1)
                    return -1;
                else
                    return 1;
            }
        });

        if(answerList.size() > 5){
            return answerList.subList(0, 5);
        }
        return answerList;
    }

    /**
     * user와 직접적인 친구 리스트를 반환
     * @param user
     * @param userFriends
     * @return List: user의 친구 리스트
     */
    private static List<String> getUserFriendList(String user, List<List<String>> userFriends) {
        Set<String> set = new HashSet<>();
        for(List<String> relation: userFriends){
            if(relation.contains(user)){
                if(relation.get(0).equals(user)){
                    set.add(relation.get(1));
                }
                else{
                    set.add(relation.get(0));
                }
            }
        }
        return new ArrayList<>(set);
    }
}
