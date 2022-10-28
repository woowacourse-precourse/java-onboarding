package onboarding;

import java.util.*;

public class Problem7 {
    /**
     * 기능 목록
     * 1. 크루원들 이름을 구하고 2차원 배열을 위한 인덱스 부여
     * 2. 2차원 배열을 활용하여 친구관계를 표시
     * 3. user의 친구의 친구들 중 user를 제외하고 10점씩 부여
     * 4. visitors가 방문한 수만큼 1점씩 부여
     * 5. 점수를 역순으로 정렬한 후 앞에서 최대 5명까지 잘라서 출력
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> crews = new HashSet<>();
        HashMap<String, Integer> crewIndex = new HashMap<>();
        HashMap<String, Integer> crewScore = new HashMap<>();
        List<String> onlyFriends;
        boolean[][] relationship;
        int len = 0;

        // 1. 크루원들 이름을 구하고 2차원 배열을 위한 인덱스 부여
        for (List<String> friend : friends) {
            crews.add(friend.get(0));
            crews.add(friend.get(1));
        }
        int idx = 0;
        for (String crew : crews) {
            crewIndex.put(crew, idx++);
            crewScore.put(crew, 0);
        }
        onlyFriends = new ArrayList<>(crews);
        crews.addAll(visitors);

        // 2. 2차원 배열을 활용하여 친구관계를 표시
        len = crews.size();
        relationship = new boolean[len][len];
        for (List<String> friend : friends) {
            relationship[crewIndex.get(friend.get(0))][crewIndex.get(friend.get(1))] = true;
            relationship[crewIndex.get(friend.get(1))][crewIndex.get(friend.get(0))] = true;
        }

        // 3. user의 친구의 친구들 중 user를 제외하고 10점씩 부여
        for (int i = 0; i < len; i++) {
            if(relationship[crewIndex.get(user)][i]) {
                for (int j = 0; j < len; j++) {
                    if(relationship[i][j] && j != crewIndex.get(user)) {
                        String name = findCrewNameByIndex(crewIndex, j);
                        crewScore.put(name, crewScore.getOrDefault(name, 0) + 10);
                    }
                }
            }
        }
        /*
         4. visitors가 방문한 수만큼 1점씩 부여
         bedi같은 경우를 대비해서 친구관계였던 배열만 따로 구해두기
         */
        for(String visitor : visitors) {
            if(!onlyFriends.contains(visitor) || !relationship[crewIndex.get(user)][crewIndex.get(visitor)]) {
                crewScore.put(visitor, crewScore.getOrDefault(visitor, 0) + 1);
            }
        }

        // 5. 점수를 역순으로 정렬한 후 앞에서 최대 5명까지 잘라서 출력
        List<Map.Entry<String, Integer>> scoreSort = new LinkedList<>(crewScore.entrySet());
        scoreSort.sort((o1, o2) -> o2.getValue() - o1.getValue());
        idx = 0;
        for(Map.Entry<String, Integer> entry : scoreSort) {
            if (++idx > 5) break;
            if (entry.getValue() != 0) { // 추천 점수가 0인 경우 추천하지 않음
                answer.add(entry.getKey());
            }
        }
        return answer;
    }

    /**
     * crewIndex의 value를 인자로 key인 name을 찾아주는 함수
     * @param crewIndex
     * @param k
     * @return
     */
    public static String findCrewNameByIndex(HashMap<String, Integer> crewIndex, int k) {
        String name = "";
        for (String n : crewIndex.keySet()) {
            Integer index = crewIndex.get(n);
            if(k == index) {
                name = n;
            }
        }
        return name;
    }
}
