package onboarding;

import java.util.*;

/**
 * <기능 목록>
 *     1. 메소드
 *          1) makeFriendMap
 *          : friends 리스트를 바탕으로 친구관계도를 만든다(friendMap(HashMap))
 *          2) calculateScore
 *          : makeFriendMap에서 만든 친구관계도, user, visitors를 바탕으로 friendCount 메소드와 visitorCount 메소드를 실행시켜 멤버별 점수를 계산한다.
 *          3) friendCount
 *          : user의 직접 친구가 아닌 멤버의 친구 목록에서 user와 함께 아는 친구 수를 바탕으로(5. intersection 메소드 활용) 점수를 부여한다.(함께 아는 친구 수 x 10)
 *          4) visitorCount
 *          : user의 피드에 방문한 멤버 중, user와 직접 친구가 아닌 멤버에게 방문 횟수만큼의 점수를 부여한다.
 *          5) intersection
 *          : List1과 List2의 요소 중 공통되는 것들의 수를 구하여 반환한다.
 *          6) solution
 *          : calculateScore에서 반환한 멤버별 점수를 담은 countResult HashMap을 1. value(획득점수) 내림차순, 만약 value같다면 2. key(멤버이름) 오름차순으로 정렬하고, 그 중 최고 점수를 획득한 최대 5명을 반환한다.
 *
 *
 *      2. 흐름
 *          1) friends를 바탕으로 makeFriendMap 메소드에서 친구관계도(friendMap)를 만든다.
 *          2-1) calculateScore에 user, friendMap, visitors를 인자로 넣는다. calculateScore에서는 다음 과정(2-2, 2-3, 2-4)이 진행된다.
 *          2-2) friendCount에서 user, friendMap을 인자로 받아 user와 함께 아는 친구 수를 바탕으로 점수를 부여한다.(intersection 메소드 사용)
 *          2-3) visitorCount에서 user의 피드에 방문한 멤버 중 user와 직접 친구가 아닌 멤버들에게 방문 횟수만큼 점수를 부여한다.
 *          3-1) solution 메소드에서 "멤버이름" : "점수" 가 담긴 HashMap을 정렬한다.(정렬 기준 : 1. 점수 내림차순, 2. 멤버이름 오름차순) 정렬결과는 List에 담긴다.
 *          3-2) 정렬된 List에서 최대 5명의 이름을 뽑아 반환한다.
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, List<String>> friendMap = makeFriendMap(friends);

        Map<String, Integer> resultCount = calculateScore(user, friendMap, visitors);

        // 정렬
        List<Map.Entry<String, Integer>> resultList = new LinkedList<>(resultCount.entrySet());

        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int cValue = o2.getValue() - o1.getValue();
                return cValue == 0? o1.getKey().compareTo(o2.getKey()) : cValue;
            }
        });


        List<String> answer = new ArrayList<>();

        int count = 0;

        for (Map.Entry<String, Integer> member : resultList) {

            answer.add(member.getKey());
            ++count;

            if (count == 5){
                break;
            }

        }

        return answer;
    }


    public static Map<String, List<String>> makeFriendMap(List<List<String>> friends){

        // 친구관계도 HashMap
        Map<String, List<String>> friendMap = new HashMap<>();

        for (List<String> friend : friends) {

            // friendMap에 friends에서 주어진 멤버 A, B의 친구 목록 List가 이미 들어가있는지 체크
            // 들어가 있다면 해당 멤버의 친구 목록 List에 추가
            // 들어가 있지 않다면 해당 멤버의 친구 목록 List를 만들고 거기다가 추가
            boolean firstMember = friendMap.containsKey(friend.get(0));
            boolean secondMember = friendMap.containsKey(friend.get(1));


            // 첫번째 멤버의 친구관계 수정
            if (!firstMember) {
                friendMap.put(friend.get(0), new ArrayList<String>());
                friendMap.get(friend.get(0)).add(friend.get(1));
            } else {
                friendMap.get(friend.get(0)).add(friend.get(1));
            }

            // 두번째 멤버의 친구관계 수정
            if (!secondMember) {
                friendMap.put(friend.get(1), new ArrayList<String>());
                friendMap.get(friend.get(1)).add(friend.get(0));
            } else {
                friendMap.get(friend.get(1)).add(friend.get(0));
            }

        }

        return friendMap;
    }


    // friendCount, visitorCount를 실행시켜 멤버별 점수를 합산하여 얻음
    public static Map<String, Integer> calculateScore(String user,
                                                      Map<String, List<String>> friendMap,
                                                      List<String> visitors) {

        List<String> userFriends = friendMap.get(user);

        Map<String, Integer> friendCountResult = friendCount(user, friendMap);
        Map<String, Integer> result = visitorCount(friendCountResult, userFriends, visitors);


        return result;
    }


    // user와 함께 하는 친구의 수를 바탕으로 점수를 매기고, 멤버와 그에게 매겨진 점수가 든 Map을 반환
    public static Map<String, Integer> friendCount(String user, Map<String, List<String>> friendMap) {

        // "멤버" : (함께 아는 친구의 수를 바탕으로)"멤버에게 매겨진 점수"를 저장할 result Map
        Map<String, Integer> countResult = new HashMap<>();

        List<String> userFriends = friendMap.get(user);

        // 1. friendMap에 저장된 member들 중에서
        for (String member : friendMap.keySet()) {


            // 2. user, 그리고 user와 직접 친구인 member에게는 점수를 매기지 않는다.
            if (!member.equals(user) && !userFriends.contains(member)) {

                List<String> friendsOfMember = friendMap.get(member);

                int count = intersection(userFriends, friendsOfMember);

                // 공통으로 아는 친구가 있을 때에만 countResult에 저장
                if (count > 0) {
                    countResult.put(member, count * 10);
                }
            }
        }

        return countResult;
    }


    // user의 타임라인에 방문한 횟수를 기준으로 점수를 부여
    // 단, user의 친구들에게는 점수를 매기지 않는다.
    public static Map<String, Integer> visitorCount(Map<String, Integer> countResult, List<String> userFriends, List<String> visitors) {

        for (String visitor : visitors){

            // user의 친구 목록에 visitor가 있는지 확인
            boolean isFriend = userFriends.contains(visitor);

            // isFriend가 false일 경우에만 점수를 부여한다.
            if (!isFriend) {

                boolean visitorInResult = countResult.containsKey(visitor);

                // visitor가 countResult에 없는 경우
                if (!visitorInResult) {
                    countResult.put(visitor, 1);
                }
                // visitor가 countResult에 있는 겨우
                else {
                    int count = countResult.get(visitor);
                    countResult.put(visitor, ++count);
                }
            }
        }

        return countResult;
    }


    // 두 리스트의 공통 요소 개수를 반환
    public static int intersection(List<String> list1, List<String> list2){

        int count = 0;

        for (String member : list1) {
            if (list2.contains(member)) {
                ++count;
            }
        }

        return count;
    }
}
