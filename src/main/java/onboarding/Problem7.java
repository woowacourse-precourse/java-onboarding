package onboarding;

import java.util.*;

public class Problem7 {
    static class Relationship {
        boolean[][] matrix;
        HashMap<String, Integer> friendIndices;

        public Relationship() {
            matrix = new boolean[10000][10000];
            friendIndices = new HashMap<>();
        }
    }

    /**
     * sources의 원소를 destination에 저장한다. 존재할 경우 무시한다.
     *
     * @param destination 저장할 해쉬맵
     * @param sources     저장할 원소들
     */
    private static void createIfNotExistsUser(
            HashMap<String, Integer> destination, List<String> sources) {
        for (String name : sources) {
            if (!destination.containsKey(name)) {
                destination.put(
                        name, Integer.valueOf(destination.size()));
            }
        }
    }

    /**
     * 이중 배열에 친구 관계를 표시한다.
     *
     * @param relationship 이중 배열을 가지고 있는 클래스
     * @param friend       친구 관계
     */
    private static void connectMatrix(Problem7.Relationship relationship, List<String> friend) {
        for (int index = 0; index + 1 < friend.size(); index++) {
            String friend1 = friend.get(index);
            String friend2 = friend.get(index + 1);
            int index1 = relationship.friendIndices.get(friend1);
            int index2 = relationship.friendIndices.get(friend2);
            relationship.matrix[index1][index2] = true;
            relationship.matrix[index2][index1] = true;
        }
    }

    /**
     * user의 친구 indices를 반환한다.
     *
     * @param relationship 친구 관계를 표시한 클래스
     * @param userIndex    user의 index
     * @return relationship에 할당된 user의 친구 indices
     */
    private static ArrayList<Integer> indexOfUserFriends(boolean[][] relationship, int userIndex) {
        boolean[] userRelationship = relationship[userIndex];
        ArrayList<Integer> result = new ArrayList<>();
        for (int index = 0; index < userRelationship.length; index++) {
            if (userRelationship[index])
                result.add(index);
        }
        return result;
    }

    /**
     * 해당 user가 추천 친구들과 알고 있다면 인당 10점 부여한다.
     *
     * @param recommendIndices 추천 친구의 indices
     * @param friendship       해당 user의 친구 관계
     * @return 총 점수
     */
    private static int acquaintanceScoreOfFriend(
            boolean[] friendship, ArrayList<Integer> recommendIndices) {
        int result = 0;
        int recommendScore = 10;
        for (Integer recommendIndex : recommendIndices) {
            if (friendship[recommendIndex])
                result += recommendScore;
        }
        return result;
    }

    /**
     * 추천 친구들과 아는 사람들에게 점수를 부여하여 scoreboard에 저장한다.
     *
     * @param relationship     친구 관계
     * @param friendNames      모든 user의 이름
     * @param scoreboard       점수를 저장할 해쉬맵
     * @param recommendIndices 친구 관계에 할당된 user 친구의 indices
     */
    private static void knowTogetherScore(
            HashMap<String, Integer> scoreboard, Problem7.Relationship relationship,
            ArrayList<Integer> recommendIndices, Set<String> friendNames
    ) {
        for (String friendName : friendNames) {
            int friendIndex = relationship.friendIndices.get(friendName);
            int friendScore = acquaintanceScoreOfFriend(relationship.matrix[friendIndex], recommendIndices);
            if (friendScore != 0) {
                scoreboard.put(friendName, friendScore);
            }
        }
    }

    /**
     * 방문자들에게 점수 1점을 부여한다. scoreboard에 이름이 존재하지 않더라도 새로 생성하여 부여한다.
     *
     * @param scoreboard 점수를 부여할 user 목록과 현재 점수
     * @param visitors 방문자들
     * */
    private static void visitScore(HashMap<String, Integer> scoreboard, List<String> visitors) {
        for (String visitor : visitors) {
            if (!scoreboard.containsKey(visitor)) {
                scoreboard.put(visitor, 0);
            }
            scoreboard.replace(visitor, scoreboard.get(visitor) + 1);
        }
    }

    /**
     * 점수 내림차순으로 정렬한다.
     *
     * @param scoreboard 정렬할 해쉬맵
     * @return 정렬된 어레이리스트
     * */
    private static List<String> sortScoreboard(HashMap<String, Integer> scoreboard) {
        List<String> result = new ArrayList<>(scoreboard.keySet());
        result.sort(Comparator.comparing(scoreboard::get).reversed());
        return result;
    }

    /**
     * user와 user의 친구 아닌 사람들 중에 점수가 높은 5명을 내림차순으로 정렬하여 반환한다.
     *
     * @param relationship 친구 관계
     * @param sorted 점수 기준 내림차순으로 정렬된 리스트
     * @param user 제외할 user
     * @return user와 user의 친구 아닌 사람들 중에 점수가 높은 5명
     * */
    private static List<String> refineList(
            List<String> sorted, String user, Problem7.Relationship relationship) {
        ArrayList<String> userFriends = new ArrayList<>();
        userFriends.add(user);
        int userIndex = relationship.friendIndices.get(user);
        for (String name : relationship.friendIndices.keySet()) {
            if (relationship.matrix[userIndex][relationship.friendIndices.get(name)]) {
                userFriends.add(name);
            }
        }

        int count = 0;
        ArrayList<String> result = new ArrayList<>();
        for (String addToName : sorted) {
            if (count == 5) {
                break;
            }
            if (userFriends.contains(addToName))
                continue;
            result.add(addToName);
            count++;
        }
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7.Relationship relationship = new Problem7.Relationship();

        relationship.friendIndices.put(user, 0);
        int userIndex = 0;
        // Relationship 클래스에 유저들의 index를 할당하고, 관계를 표시한다.
        for (List<String> friend : friends) {
            createIfNotExistsUser(relationship.friendIndices, friend);
            connectMatrix(relationship, friend);
        }


        // 점수를 부여한다.
        ArrayList<Integer> recommendedIndices = indexOfUserFriends(relationship.matrix, userIndex);
        HashMap<String, Integer> scoreboard = new HashMap<>();
        knowTogetherScore(scoreboard, relationship, recommendedIndices, relationship.friendIndices.keySet());
        visitScore(scoreboard, visitors);

        // 점수를 기준으로 정렬하고 정제한다.
        List<String> sorted = sortScoreboard(scoreboard);
        List<String> result = refineList(sorted, user, relationship);
        return result;
    }
}
