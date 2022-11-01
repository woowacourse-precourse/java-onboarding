package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7_Functions func = new Problem7_Functions();

        List<String> usersFriendsList = func.getUsersFriendsList(user, friends);

        HashMap<String, List<String>> usersFriendsRelationMap = func.getUsersFriendsRelationMap(
                user,
                usersFriendsList,
                friends);

        HashMap<String, Integer> UsersRecommandFriendsPointsMap = func.getUsersRecommandFriendsPointsMap(
                usersFriendsList,
                usersFriendsRelationMap,
                visitors);

        List<String> answer = new ArrayList<>(UsersRecommandFriendsPointsMap.keySet());

        Collections.sort(answer, (r, l) -> {
            int r_score = UsersRecommandFriendsPointsMap.get(r);
            int l_score = UsersRecommandFriendsPointsMap.get(l);

            /*
             * 점수가 같을경우 추천 친구의 아이디 오름차순 정렬
             * 점수 내림차순 정렬
             */
            return (r_score == l_score
                    ? r.compareTo(l)
                    : l_score - r_score);

        });

        return answer;
    }

    /**
     * 추천 친구 목록을 구하기 위한 기능들을 구현한 클래스
     */
    public static class Problem7_Functions {
        /**
         * 사용자의 모든 친구목록을 반환한다.
         * 
         * @param user    친구를 추천받을 사용자 아이디
         * @param friends 친구관계정보
         * @return {@code List<String>}사용자의 친구목록
         */
        public List<String> getUsersFriendsList(String user, List<List<String>> friends) {

            HashSet<String> res = new HashSet<>();

            for (List<String> relation : friends) {
                String friend = relation.get(0);
                res.add(friend);
            }

            res.remove(user);

            return List.copyOf(res);
        }

        /**
         * 사용자의 친구목록에서 모든 친구에 대한 관계정보를 Map으로 반환한다.
         * 
         * @param user        친구를 추천받을 사용자 아이디
         * @param userFriends 사용자의 모든 친구목록
         * @param friends     친구관계정보
         * @return {@code HashMap}user를 제외한 user의 1:N의 모든 친구관계정보
         */
        public HashMap<String, List<String>> getUsersFriendsRelationMap(String user,
                List<String> userFriends,
                List<List<String>> friends) {

            HashMap<String, List<String>> res = new HashMap<>();

            for (List<String> relation : friends) {
                String friend = relation.get(0);
                String withWho = relation.get(1);

                List<String> friendsList = res.getOrDefault(friend, new ArrayList<>());

                friendsList.add(withWho);
                friendsList.remove(user);

                res.put(friend, friendsList);
            }

            return res;
        }

        /**
         * 사용자를 제외한 사용자의 친구관계목록에서 사용자에게 추천할 친구({@code Key}) 와
         * 함께 아는 친구의 수에 따라 부여된 점수({@code} Value}) 정보를 담은 {@code HashMap} 을 반환한다.
         * 
         * @param usersFriendsList        사용자의 친구목록
         * @param usersFriendsRelationMap 사용자를 제외한 사용자의 친구관계목록
         * @param visitors                사용자 타임 라인 방문 기록
         * @return {@code}HashMap<String, Integer>}추천친구별 점수 정보
         */
        public HashMap<String, Integer> getUsersRecommandFriendsPointsMap(
                List<String> usersFriendsList,
                HashMap<String, List<String>> usersFriendsRelationMap,
                List<String> visitors) {

            HashMap<String, Integer> usersRecommandFriendsPointsMap = new HashMap<>();

            List<String> recommandList = getUsersRecommandFriendsList(usersFriendsRelationMap, usersFriendsList);

            for (String recommandFriend : recommandList) {
                int score = usersRecommandFriendsPointsMap.getOrDefault(recommandFriend, 0);
                score += 10;
                usersRecommandFriendsPointsMap.put(recommandFriend, score);
            }

            HashMap<String, Integer> res = addVisitPointsToRecommandFriends(usersRecommandFriendsPointsMap,
                    usersFriendsList, visitors);

            return res;
        }

        /**
         * 방문 기록을 토대로 사용자의 친구를 제외한 방문자에 대해
         * 추천친구 점수를 방문 횟수당 1점을 부여한 추천친구별 점수 정보를 새로 반환한다.
         * 
         * @param UsersRecommandFriendsPointsMap 추천친구별 점수 정보
         * @param usersFriendsList               사용자의 친구목록
         * @param visitors                       사용자 타임 라인 방문 기록
         * @return {@code}HashMap<String, Integer>}방문 점수가 반영된 추천친구별 점수 정보
         */
        private HashMap<String, Integer> addVisitPointsToRecommandFriends(
                HashMap<String, Integer> UsersRecommandFriendsPointsMap,
                List<String> usersFriendsList,
                List<String> visitors) {

            for (String visitor : visitors) {
                int score = UsersRecommandFriendsPointsMap.getOrDefault(visitor, 0);
                score++;
                UsersRecommandFriendsPointsMap.put(visitor, score);
            }

            for (String usersFriend : usersFriendsList) {
                UsersRecommandFriendsPointsMap.remove(usersFriend);
            }

            return UsersRecommandFriendsPointsMap;
        }

        /**
         * 추천 친구별 점수 정보를 바탕으로 사용자의 추천 친구 목록을 반환한다.
         * 
         * @param usersFriendsRelationMap 추천 친구별 점수 정보
         * @param usersFriendsList        사용자의 친구목록
         * @return {@code}List<String>} 사용자의 추천 친구 목록
         */
        public List<String> getUsersRecommandFriendsList(HashMap<String, List<String>> usersFriendsRelationMap,
                List<String> usersFriendsList) {

            HashSet<String> res = new HashSet<>();

            for (String usersFriend : usersFriendsRelationMap.keySet()) {
                List<String> friendsList = usersFriendsRelationMap.get(usersFriend);
                res.addAll(friendsList);
            }

            for (String usersFriend : usersFriendsList) {
                res.remove(usersFriend);
            }

            return List.copyOf(res);
        }
    }
}
