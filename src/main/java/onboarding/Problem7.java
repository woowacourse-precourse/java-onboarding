package onboarding;

import java.util.*;

public class Problem7 {

    public static ArrayList<Integer> graph[];
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> userSet = new HashSet<>();

        //1. 친구 정보가 주어진 모든 사용자명을 추출한다.
        for(List<String> data : friends){
            String user1 = data.get(0);
            String user2 = data.get(1);
            userSet.add(user1);
            userSet.add(user2);
        }

        //2. 친구 정보를 담는 그래프(연결리스트)를 생성하여 데이터를 저장한다.
        graph = new ArrayList[userSet.size()];
        List<String> users = new ArrayList<>(userSet);

        //3. 주어진 사용자 아이디와 친구인 사용자를 조사하여 점수를 부여한다.
        //4. visitor 리스트를 조사하여, 방문한 사용자에게 1점씩 부여한다.
        //5. 모든 점수를 부여했다면 점수가 높은 5명을 추린다.

        return answer;
    }
}
