package onboarding;

import java.util.*;

/*
1. friends 목록을 돌면서 이름을 키값 점수를 value로 해쉬맵을 작성한다.
    친구이면 value에 -10을, 본인이면 -11, 친구의 친구이면 10 그것도 아니면 0점
2. visitor의 목록을 돌면서 해쉬맵에 없는 이름이면 새로 넣고 1,
    이미 있는데 0 혹은 양수의 점수를 가졌으면 + 1
    있는데 음수의 점수를 가졌으면 pass
3. value 기준으로 정렬하여 상위 5명 출력
 */

public class Problem7 {
    public static String user_name;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();
        HashMap<String, Integer> recommend_list = new HashMap<>();

        user_name = user;
//        friends.sort(new Mycomparator());
        initRecommendList(recommend_list, friends);

        return answer;
    }

    private static class Mycomparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    private static void initRecommendList(HashMap<String, Integer> recommend_list, List<List<String>> friends) {


    }
}







