package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        // List객체를 ArrayList객체로 복사
        List<List<String>> arrayFriends = convertToArrayList(friends);
        List<String> arrayVisitors = convertToArrayList(visitors);
        // user와 친구인 유저를 Queue에 offer
        Queue<String> users = new LinkedList<String>();
        insertUserFriendsTo(user, users, arrayFriends);
        // users.size()만큼 poll()하여 user와 친구인 유저의 친구유저를 insertUserFriendsTo()
        int size = users.size();
        for (int i = 0; i < size; i++) {
            String friendOfUser = users.poll();
            arrayVisitors.remove(friendOfUser);
            insertUserFriendsTo(friendOfUser, users, arrayFriends);
        }
        // 추천할 유저의 추천점수를 map에 저장
        Map<String, Integer> userScores = new HashMap<String, Integer>();
        saveUserScore(userScores, arrayVisitors, 1);
        saveUserScore(userScores, users, users.size(), 10);
        // 추천점수 상위 5명을 answer에 add
        addHighFiveUser(answer, userScores, 5);
        return answer;
    }

    /** List객체는 요소의 삽입이나 삭제가 불가능하므로 ArrayList객체로 복사하는 함수 */
    private static <S> ArrayList<S> convertToArrayList(List<S> list) {
        ArrayList<S> arrList = new ArrayList<S>();
        arrList.addAll(list);
        return arrList;
    }

    /** 추천점수 상위 5명을 answer에 add */
    private static void addHighFiveUser(List<String> answer, Map<String, Integer> userScores, int maxAnswerNum) {
        // 유저추천점수을 기준으로 유저 정렬(내림차순)
        List<Map.Entry<String, Integer>> entries = userScores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        // 정렬한 유저추천점수 중 상위 5개에 해당하는 유저 선별. 점수 0 제외
        for (Map.Entry<String, Integer> userScore: entries) {
            if (userScore.getValue() <= 0 || entries.indexOf(userScore) >= maxAnswerNum) {
                break;
            }
            answer.add(userScore.getKey());
        }
        return;
    }

    /** 추천할 유저의 추천점수를 방문횟수로 따져 map에 저장 */
    private static void saveUserScore(Map<String, Integer> userScores, List<String> visitors, int score) {
        for (int i = 0; i < visitors.size(); i++) {
            String userName = visitors.get(i);
            int existingScore = 0;
            if (userScores.containsKey(userName) == true) {
                existingScore = userScores.get(userName);
            }
            userScores.put(userName, score + existingScore);
        }
        return;
    }

    /** 추천할 유저의 추천점수를 친구관계로 따져 map에 저장 */
    private static void saveUserScore(Map<String, Integer> userScores, Queue<String> users, int size, int score) {
        for (int i = 0; i < size; i++) {
            String userName = users.poll();
            int existingScore = 0;
            if (userScores.containsKey(userName) == true) {
                existingScore = userScores.get(userName);
            }
            userScores.put(userName, score + existingScore);
        }
        return;
    }

    /** 특정 유저와 친구인 유저를 Queue에 offer */
    private static void insertUserFriendsTo(String user, Queue<String> users, List<List<String>> friends) {
        Iterator<List<String>> friendIter = friends.iterator();
        while(friendIter.hasNext()) {
            List<String> tmp = friendIter.next();
            if (tmp.contains(user)) {
                int i = 1 - tmp.indexOf(user);
                users.offer(tmp.get(i));
                friendIter.remove();    // 한 번 특정된 친구관계는 다시 특정하지 않으므로 remove
            }
        }
        return;
    }
}