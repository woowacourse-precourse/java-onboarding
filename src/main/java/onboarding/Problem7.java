package onboarding;

import java.util.*;

public class Problem7 {

    // 사용자와 함께 아는 친구의 수 = 10점
    static final int score_bothFriends = 10;

    // 사용자의 타임 라인에 방문한 횟수 = 1점
    static final int score_visitedTimeline = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // friends에 저장되어 있는 각각의 유저마다 친구 목록을 저장하는 HashMap (key : username / value : 친구 목록(List<String>))
        HashMap<String, HashSet<String>> friendLists = new HashMap<>();
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            // 친구 목록에 추가
            // (서로가 서로의 친구 목록에 각각 저장되어야 하기 때문에 인자의 위치를 바꿔서 함수를 2번 호출)
            setFriendList(friendLists, friend1, friend2);
            setFriendList(friendLists, friend2, friend1);
        }

        // 전체 유저 목록 (List)
        HashSet<String> totalUserList = getTotalUserList(friendLists, visitors);

        // 각 유저별 점수를 저장하는 HashMap (key : username / value : 점수 (전부 0으로 초기화))
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (String account : totalUserList) {
            scoreMap.put(account, 0); // 0으로 초기화
        }

        // user와 이미 친구가 되어 있는 사람들의 목록
        HashSet<String> userFriends = friendLists.get(user);

        for (String oneUser : totalUserList) {
            // 본인은 제외 & user와 이미 친구가 되어 있는 사람은 추천하지 않기 때문에 제외
            if (!oneUser.equals(user) && !userFriends.contains(oneUser)) {
                // 점수 계산 후 scoreMap에 저장
                scoreMap.replace(oneUser, getScore(friendLists, visitors, oneUser));
            }
        }

        // 추천 친구 목록
        answer = getAnswer(scoreMap);
        return answer;
    }

    // friend2를 friend1의 친구 목록에 저장하는 함수
    private static void setFriendList(HashMap<String, HashSet<String>> friendLists, String friend1, String friend2) {
        // friend1의 친구 목록이 friendLists에 이미 생성되어 있는 경우
        if (friendLists.containsKey(friend1)) {
            HashSet<String> friend1List = friendLists.get(friend1); // 기존 저장되어 있던 friend1의 친구 목록
            friend1List.add(friend2); // 친구 목록에 friend2 추가
            friendLists.replace(friend1, friend1List);
        }
        // friend1의 친구 목록이 friendLists에 생성되어 있지 않은 경우
        if (!friendLists.containsKey(friend1)) {
            friendLists.put(friend1, new HashSet<>(List.of(friend2))); // 친구 목록 생성
        }
    }

    // 전체 유저 목록을 반환하는 함수
    private static HashSet<String> getTotalUserList(HashMap<String, HashSet<String>> friendLists, List<String> visitors) {
        HashSet<String> totalUserList = new HashSet<>(friendLists.keySet()); // friends에 들어있는 유저는 전부 List에 넣기

        // friends에 들어있지 않으며, visitors에만 들어있는 유저를 List에 추가
        for (String visitor : visitors) {
            if (!friendLists.containsKey(visitor)) { // friends에 들어있지 않았던 경우 = friendLists에서 같은 이름의 key가 존재하지 않는 경우
                totalUserList.add(visitor);
            }
        }

        return totalUserList;
    }

    // 유저별 점수를 계산한 후 반환하는 함수
    private static Integer getScore(HashMap<String, HashSet<String>> friendLists, List<String> visitors, String user) {
        int score = 0;

        // user와 이미 친구가 되어 있는 사람들의 목록
        HashSet<String> userFriends = friendLists.get(user);

        // friends에 들어있는 유저만 확인
        if (friendLists.containsKey(user)) {
            int bothFriendsNum = 0; // 사용자와 함께 아는 친구의 수
            for (String friend : friendLists.get(user)) {
                if (userFriends.contains(friend)) { // 사용자와 함께 아는 친구라면 bothFriendsNum + 1
                    bothFriendsNum++;
                }
            }
            score += bothFriendsNum * score_bothFriends; // score + (사용자와 함께 아는 친구의 수) * 10
        }

        for (String visitor : visitors) {
            if (user.equals(visitor)) { // 사용자의 타임 라인에 방문한 횟수만큼 score + 1
                score += score_visitedTimeline;
            }
        }

        return score;
    }

    // 점수 기준 내림차순 정렬 후, 추천 친구 목록을 반환하는 함수
    // sortResult 함수를 호출하는 것을 통해 추천 점수가 같은 경우, 이름 기준 오름차순으로 정렬하여 반환
    private static List<String> getAnswer(HashMap<String, Integer> scoreMap) {
        // 점수(value) 기준 내림차순 정렬
        List<Map.Entry<String, Integer>> sortScore = new LinkedList<>(scoreMap.entrySet());
        sortScore.sort((o1, o2) -> o2.getValue() - o1.getValue());

        // 추천 친구로 반환할 목록 (Map)
        // 추천 점수가 같은 경우에는 이름 기준 오름차순으로 정렬해야 하기 때문에 우선 Map으로 저장 (key : username / value : score)
        List<Map.Entry<String, Integer>> resultMap = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortScore) {
            if (entry.getValue() == 0) { // 추천 점수가 0점인 경우 추천하지 않음
                break;
            }
            resultMap.add(entry);
            if (resultMap.size() == 5) { // 최대 5명을 뽑음
                break;
            }
        }

        // 추천 친구 목록 반환 (점수가 같은 경우는 이름 기준 오름차순 정렬)
        return sortResult(resultMap);
    }

    // 추천 친구 목록을 반환하는 함수 (List)
    // 점수가 같은 경우는 이름 기준 오름차순 정렬
    private static List<String> sortResult(List<Map.Entry<String, Integer>> resultMap) {
        List<String> result = new ArrayList<>(); // 추천 친구 목록

        Set<String> sameScoreUsers = new HashSet<>(); // 점수가 같은 유저들의 이름을 저장하는 List
        boolean hasSame = false; // 이전에 점수가 같은 유저들이 있었는지 확인하기 위한 변수 (true : 이전에 점수가 같은 유저들이 존재 / false : 존재하지 않았음)

        for (int i = 1; i < resultMap.size(); i++) {
            // 유저 이름
            String user1_username = resultMap.get(i - 1).getKey();
            String user2_username = resultMap.get(i).getKey();
            // 점수
            int user1_score = resultMap.get(i - 1).getValue();
            int user2_score = resultMap.get(i).getValue();

            // 두 유저의 점수가 같았을 경우 -> sameScoreUsers에 둘 다 저장
            if (user1_score == user2_score) {
                sameScoreUsers.add(user1_username);
                sameScoreUsers.add(user2_username);
                hasSame = true; // 점수가 같은 유저가 있음을 표시
            }

            // 두 유저의 점수가 달랐을 경우
            // 1. 이전에 점수가 같은 유저들이 있었다면 -> sameScoreUsers에 있던 값들을 오름차순 정렬한 후 result에 전부 추가
            if (user1_score != user2_score && hasSame) {
                List<String> userList = new ArrayList<>(sameScoreUsers); // sameScoreUsers set에 저장되어 있던 값들을 가져오기
                Collections.sort(userList); // 이름순 오름차순 정렬
                result.addAll(userList);
                sameScoreUsers = new HashSet<>(); // sameScoreUsers 초기화
            }
            // 2. 이전에 점수가 같은 유저들이 없었다면 -> result에 user1의 이름을 저장
            if (user1_score != user2_score && !hasSame) {
                result.add(user1_username);
            }
            // 3. 마지막 for문이었다면 -> result에 user2의 이름을 저장
            if (user1_score != user2_score &&i == resultMap.size() - 1) {
                result.add(user2_username);
            }
        }

        return result;
    }

}
