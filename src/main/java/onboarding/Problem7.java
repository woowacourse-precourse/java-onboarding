package onboarding;

import java.util.*;

/**
 * 친구 추천 문제
 * <p>
 * 문제 설명 :
 * 레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다.
 * 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.
 * 1. 사용자와 함께 아는 친구의 수 = 10점
 * 2. 사용자의 타임 라인에 방문한 횟수 = 1점
 * 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
 * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
 * 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
 * <p>
 * 제한사항 :
 * - user는 길이가 1 이상 30 이하인 문자열이다.
 * - friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
 * - friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
 * - A와 B는 친구라는 의미이다.
 * - 아이디는 길이가 1 이상 30 이하인 문자열이다.
 * - visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
 * - 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
 * - 동일한 친구 관계가 중복해서 주어지지 않는다.
 * - 추천할 친구가 없는 경우는 주어지지 않는다.
 *
 * @author scyllacore
 * @version 1.1 2022/11/01
 */

public class Problem7 {
    /**
     * 구현 사항
     * 1. setFriendsGraph : friends정보를 가지고 친구 관계 그래프를 만든 후, 사용자와 친구관계인 다른 친구에 대한 정보는 삭제.
     * 2. setFriendsScore : setFriendsGraph의 관계 정보를 가지고 추천 친구들에 대한 각각의 score를 산출하여 저장.
     * 3. getFriendRecommendation : setFriendsScore에서 받은 친구 name과 score정보를 UserInformation 객체에 저장하고 정렬.
     *    그리고 추천할 친구 목록 반환.
     * 4. solution : 최종적으로 추천할 친구 목록 반환.
     */

    /**
     * 1-1. 친구 관계 그래프 정보를 저장할 hashMap
     */
    private static Map<String, Set<String>> friendsGraph = new HashMap<>();
    /**
     * 2-1. 각 친구의 score를 저장할 hashMap
     */
    private static Map<String, Integer> friendsScore = new HashMap<>();

    /**
     * 3-1. 각 user name과 score정보를 저장할 객체
     */
    static class UserInformation {
        String name;
        Integer score;

        public UserInformation(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }
    }


    /**
     * 1. friends정보를 가지고 친구 관계 그래프를 만든 후, 사용자와 친구관계인 다른 친구에 대한 정보는 삭제.
     *
     * @param friends 친구 관계 list.
     * @param user    친구 추천을 받을 사용자.
     */
    private static void setFriendsGraph(List<List<String>> friends, String user) {

        /* 1-2. 모든 친구 관계를 따져 그래프를 만듬. */
        for (int i = 0; i < friends.size(); i++) {

            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            Set<String> innerSetA = new HashSet<>();
            Set<String> innerSetB = new HashSet<>();    // 똑같은 객체를 참조하지 않도록 Set을 2개 생성.


            if (!friendsGraph.containsKey(friendA)) {
                friendsGraph.put(friendA, innerSetA);
            }
            if (!friendsGraph.containsKey(friendB)) {
                friendsGraph.put(friendB, innerSetB);
            }

            friendsGraph.get(friendA).add(friendB);
            friendsGraph.get(friendB).add(friendA);
        }

        /* 1-3 . 이 중 이미 사용자와 친구인 user는 추천 친구로 볼 수 없으니, 이에 대한 정보 삭제. */
        friendsGraph.get(user).forEach((removedFriendUser) -> {
            friendsGraph.remove(removedFriendUser);
        });


    }


    /**
     * 2. setFriendsGraph의 관계 정보를 가지고 추천 친구들에 대한 각각의 score를 산출하여 저장.
     *
     * @param visitors 친구 추천을 받을 사용자의 sns에 방문한 다른 user list.
     * @param user     친구 추천을 받을 사용자.
     */
    private static void setFriendsScore(List<String> visitors, String user) {
        
        /* 2-2. 방문 친구(visitors) 중 사용자와 친구 관계인 다른 user가 있을 수 있기 때문에
                score 산출 후 사용자와 친구 관계인 user를 삭제할 때 쓸 임시 Set. */
        Set<String> userFriendSet = friendsGraph.get(user);
        friendsGraph.remove(user); // friendsGraph을 가지고 score를 산출할 때 있으면 안 되는 user임으로 미리 제거.

        /* 2-3. 사용자와 함께 아는 친구에 대해 10점 계산. */
        friendsGraph.forEach((anotherUser, friends) -> {

            friendsScore.put(anotherUser, 0);

            int size = friends.size();
            int score = size * 10;

            friendsScore.put(anotherUser, friendsScore.get(anotherUser) + score);

        });

        /* 2-4. 방문한 친구에 대해 1점 계산. */
        visitors.forEach((anotherUser) -> {
            if (!friendsScore.containsKey(anotherUser)) {
                friendsScore.put(anotherUser, 0);
            }
            friendsScore.put(anotherUser, friendsScore.get(anotherUser) + 1);

        });

        /* 2-5. 사용자와 친구 관계인 user 삭제 */
        userFriendSet.forEach((anotherUser) -> {
            friendsScore.remove(anotherUser);
        });

    }

    /**
     * 3. setFriendsScore에서 받은 친구 name과 score정보를 UserInformation 객체에 저장하고 정렬. 그리고 추천할 친구 목록 반환.
     *
     * @return 최종적으로 추천할 친구 목록.
     */
    private static List<String> getFriendRecommendation() {

        /* 3-2. 추천 정보 객체 저장. */
        List<UserInformation> friendRecommendation = new ArrayList<>();

        friendsScore.forEach((name, score) -> {
            friendRecommendation.add(new UserInformation(name, score));
        });

        /* 3-3. 정렬 */
        Collections.sort(friendRecommendation, (friendA, friendB) -> {
            if (friendA.getScore() != friendB.getScore()) {
                return friendB.getScore() - friendA.getScore();         // 가장 높은 점수의 user부터 나열.
            }
            return friendA.getName().compareTo(friendB.getName());      // score가 같을 시 이름 순으로 나열.
        });


        /* 3-4. 정렬 후 최대 5명 까지만 추천 친구 목록에 포함. */
        List<String> nameList = new ArrayList<>();

        for (int i = 0; i < friendRecommendation.size() && i < 5; i++) {
            nameList.add(friendRecommendation.get(i).getName());
        }

        return nameList;

    }

    /**
     * 4. 최종적으로 추천할 친구 목록 반환.
     *
     * @param user     친구 추천을 받을 사용자.
     * @param friends  친구 관계 list.
     * @param visitors 친구 추천을 받을 사용자의 sns에 방문한 다른 user list
     * @return 최종 추천 친구 목록.
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        setFriendsGraph(friends, user);
        setFriendsScore(visitors, user);
        List<String> answer = getFriendRecommendation();
        return answer;
    }

}
