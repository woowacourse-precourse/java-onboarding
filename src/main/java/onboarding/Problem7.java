package onboarding;

import java.util.*;

public class Problem7 {

    static class recommendationSort<T extends Comparable<T>> implements Comparator<List<T>> {

        @Override
        public int compare(List<T> o1, List<T> o2) {
            // 점수가 같다면, 이름 오름차순으로
            if (o1.get(1).equals(o2.get(1))) {
                return o1.get(0).compareTo(o2.get(0));
            }
            // 점수순으로
            return Integer.compare(Integer.parseInt((String) o2.get(1)), Integer.parseInt((String) o1.get(1)));
        }
    }

    /**
     * 사용자 List를 구함
     * @param user
     * @param friends
     * @return
     */
    private static List<String> getUsersList(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> users = new HashSet<>();

        for (List<String> next : friends) {
            users.add(next.get(0));
            users.add(next.get(1));
        }

        for (String next : visitors) {
            users.add(next);
        }

        List<String> result = new ArrayList<>();
        for (String userName : users) {
            result.add(userName);
        }
        return result;
    }

    /**
     * 각 사용자별 현재 이미 친구인 사람들을 구함
     * @param userList
     * @param friends
     * @return
     */
    private static HashMap<String, HashSet<String>> getEachFriendsList(List<String> userList, List<List<String>> friends) {
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for (String otherUser : userList) {
            HashSet<String> tempSet = new HashSet<>();
            result.put(otherUser, tempSet);
        }

        for(List<String> next : friends) {
            result.get(next.get(0)).add(next.get(1));
            result.get(next.get(1)).add(next.get(0));
        }
        return result;
    }

    /**
     * 친구가 아닌 사용자들 중에서 공통으로 가지는 수를 통해 점수를 구한다.
     * @param user
     * @param userList
     * @param userFriendsList
     * @return
     */
    private static HashMap<String, Integer> getFriendsScore(String user, List<String> userList, HashMap<String, HashSet<String>> userFriendsList) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String next : userList) {
            result.put(next, 0);
        }

        for (String notFriend : userList) {
            // 이미 친구인 대상에 대해서는 고려하지 않는다.
            if (userFriendsList.get(user).contains(notFriend)) {
                continue;
            }
            int friendCount = 0;
            for (String commonFriend : userList) {
                if (notFriend.equals(commonFriend)) {
                    continue;
                }
                // 만약 commonFriend가 user와 notFriend와 모두 친구라면
                if (userFriendsList.get(user).contains(commonFriend) && userFriendsList.get(notFriend).contains(commonFriend)) {
                    friendCount++;
                }
            }
            result.put(notFriend, friendCount * 10);
        }
        return result;
    }

    /**
     * 친구가 아닌 사용자들 중에서 방문한 횟수만큼 점수를 더한다.
     * @param user
     * @param userFriendsList
     * @param visitors
     * @param userScore
     * @return
     */
    private static HashMap<String, Integer> getVisitorsScore(String user, HashMap<String, HashSet<String>> userFriendsList, List<String> visitors,  HashMap<String, Integer> userScore) {

        for (String visitor : visitors) {
            if (userFriendsList.get(user).contains(visitor) || visitor.equals(user)) {
                continue;
            }
            userScore.put(visitor, userScore.get(visitor) + 1);
        }
        return userScore;
    }

    /**
     * 점수 및 이름 순으로 정렬 후 최종 추천 명단을 구하여 리턴함
     * @param user
     * @param userScore
     * @return
     */
    private static List<String> getTotalRecommendation(String user, HashMap<String, Integer> userScore) {
        List<List<String>> sortingList = new ArrayList<>();

        Set<String> keySet = userScore.keySet();
        for (String key : keySet) {
            if (userScore.get(key) == 0) continue;
            if (key.equals(user)) continue;
            List<String> temp = new ArrayList<>();
            temp.add(key);
            temp.add(String.valueOf(userScore.get(key)));
            sortingList.add(temp);
        }

        Collections.sort(sortingList, new recommendationSort<>());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < sortingList.size(); i++) {
            result.add(sortingList.get(i).get(0));
            if (result.size() >= 5) break;
        }
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userList = getUsersList(user, friends, visitors);
        HashMap<String, HashSet<String>> userFriendsList = getEachFriendsList(userList, friends);

        HashMap<String, Integer> userScore = getFriendsScore(user, userList, userFriendsList);
        HashMap<String, Integer> userVisitedScore = getVisitorsScore(user, userFriendsList, visitors, userScore);

        return getTotalRecommendation(user, userVisitedScore);
    }
}
