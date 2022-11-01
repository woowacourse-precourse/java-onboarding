package onboarding;

import java.util.*;

/*
    요구사항 분석
    사용자와 함꼐 아는 친구의 수 = 10점 -> friends 에 user가 들어가 있는 경우 해당 친구에 10점 부여
    사용자의 타임라인에 방문한 횟수 = 1점 -> visitor에 들어가 있는 사람에 1점씩부여

    추천점수가 0인 경우 제외, 점수가 같은 경우 이름순으로 정렬

    제한사항
    동일한 친구 관계가 중복해서 주어지지 않는다. (A ,B) , (B, A) => X
    추천할 친구가 없는 경우는 없다

    프로그램 구현
    Map 자료구조를 사용하여 해당 이름에 대한 점수 부여할것
    Step1. Map 자료구조 만들기
    Step2. user의 친구 목록 만들기
    Step3. friends를 탐색하며 friendList의 friend가 들어가있는 경우 친구 이름을 Map 넣고 점수 10점 부여
    Step4. visitors 를 탐색하며 해당 친구이름을 Map 에 넣고 1점부여    단, 이미 친구인 사람에게는 점수부여를 해서는 안된다
    Step5. Map을 value 기준 오름차순 정렬 -> 점수가 같은 경우 이름순으로 정렬
    Step6. 위에서 부터 하나씩 answer에 넣되 점수가 0인 경우에는 넣지 않고, answer 리턴
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //Step1. Map 자료구조 만들기
        Map<String, Integer> recommendPoint = new HashMap<>();

        //Step2. user의 친구 목록 만들기
        List<String> friendList = makeFriendList(friends, user);
        //Step2. friends를 탐색하며 user가 들어가있는 경우 친구 이름을 Map 넣고 점수 10점 부여
        for (List<String> friend : friends) {
            scoreFriendPoint(recommendPoint, friend, friendList, user);
        }
        //Step3. visitors 를 탐색하며 해당 친구이름을 Map 에 넣고 1점부여
        for (String visitor : visitors) {
            scoreVisitorPoint(recommendPoint, visitor, friendList);
        }
        //Step4. Map을 value 기준 오름차순 정렬 -> 점수가 같은 경우 이름순으로 정렬
        List<Map.Entry<String, Integer>> recommendPointRank = new LinkedList<>(recommendPoint.entrySet());
        recommendPointRank.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        //Step5. 위에서 부터 하나씩 answer에 넣되 점수가 0인 경우에는 넣지 않고, answer 리턴
        int count = 0;
        for (Map.Entry<String, Integer> friend : recommendPointRank) {
            if (friend.getValue() == 0 || count > 5) {
                break;
            } else {
                answer.add(friend.getKey());
                count++;
            }
        }

        return answer;
    }

    private static List<String> makeFriendList(List<List<String>> friends, String user) {

        List<String> friendList = new LinkedList<>();
        int count = 0;

        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                friendList.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                friendList.add(friend.get(0));
            }
            count++;
        }
        return friendList;
    }

    private static void scoreVisitorPoint(Map<String, Integer> recommendRank, String visitor, List<String> friendList) {

        boolean visitorValid = myVisitorCheck(friendList, visitor);

        if (visitorValid == true) {
            recommendRank.put(visitor, recommendRank.getOrDefault(visitor, 0) + 1);
        }
    }

    private static boolean myVisitorCheck(List<String> friendList, String visitor) {

        boolean result = true;

        for (String myFriend : friendList) {
            if (visitor.equals(myFriend)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static void scoreFriendPoint(Map<String, Integer> recommendRank, List<String> friend, List<String> friendList, String user) {

        String friendName1 = friend.get(0);
        String friendName2 = friend.get(1);
        boolean isFriendName1MyFriend;
        boolean isFriendName2MyFriend;

        if (friendName1.equals(user) || friendName2.equals(user)) {
            return;
        }

        isFriendName1MyFriend = myFriendCheck(friendName1, friendList);
        isFriendName2MyFriend = myFriendCheck(friendName2, friendList);

        if (isFriendName1MyFriend == true && isFriendName2MyFriend == true) {
            return;
        } else if (isFriendName1MyFriend == true) {
            recommendRank.put(friendName2, recommendRank.getOrDefault(friendName2, 0) + 10);
        } else if (isFriendName2MyFriend == true) {
            recommendRank.put(friendName1, recommendRank.getOrDefault(friendName1, 0) + 10);
        }

    }

    private static boolean myFriendCheck(String friendName, List<String> friendList) {

        for (String myFriend : friendList) {
            if (friendName.equals(myFriend)) {
                return true;
            }
        }
        return false;
    }

}
