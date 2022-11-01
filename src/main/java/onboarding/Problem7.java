package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /*
        1. 친구의 친구 아이디 추가, 점수 + 10
        2. 방문자 아이디 추가, 점수 + 1
         + 만약 이미 아이디 있으면 점수만 추가
        3. user, friends[][0]에 있는 아이디의 점수 0으로 만들기
        4. 점수 높은 순으로 출력, 점수 0인 경우는 출력 안 함
         */
        List<String> answer = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<Integer> score = new ArrayList<>();
        int max;

        name.add(friends.get(0).get(1));
        score.add(10);

        for (int i = 1; i < friends.size(); i++) {
            friendsGet(friends.get(i), name, score);
        }

        for (int i = 1; i < visitors.size(); i++) {
            visitorsGet(visitors.get(i), name, score);
        }

        if (name.contains(user)) {
            score.set(name.indexOf(user), 0);
        }
        for (List<String> friend : friends) {
            if (name.contains(friend.get(0))) {
                score.set(name.indexOf(friend.get(0)), 0);
            }
        }

        do {
            max = maxScores(score);
            for (int i = 0; i < score.size(); i++) {
                if (max == score.get(i)) {
                    answer.add(name.get(score.indexOf(max)));
                }
            }
        } while (max == 0);

        return answer;
    }

    public static void friendsGet(List<String> friends, List<String> name, List<Integer> score) {
        int a;
        if (!name.contains(friends.get(1))) {
            a = score.get(name.indexOf(friends.get(1)));
            score.set(name.indexOf(friends.get(1)), a + 10);
        } else {
            name.add(friends.get(1));
            score.add(10);
        }
    }

    public static void visitorsGet(String visitors, List<String> name, List<Integer> score) {
        int a;
        if (name.contains(visitors)) {
            a = score.get(name.indexOf(visitors));
            score.set(name.indexOf(visitors), a + 1);
        } else {
            name.add(visitors);
            score.add(1);
        }
    }

    public static int maxScores(List<Integer> score) {
        int max = 0;
        for (int i = 0; i < score.size(); i++) {
            if (max < score.get(i)) {
                max = score.get(i);
            }
        }
        return max;
    }
}
