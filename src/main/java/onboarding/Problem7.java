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

        // 2. 2차원 배열을 활용하여 친구관계를 표시
        len = crews.size();
        relationship = new boolean[len][len];
        for (List<String> friend : friends) {
            relationship[crewIndex.get(friend.get(0))][crewIndex.get(friend.get(1))] = true;
            relationship[crewIndex.get(friend.get(1))][crewIndex.get(friend.get(0))] = true;
        }
        return answer;
    }
}
